package application;

import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.List;

import com.google.api.client.auth.oauth2.Credential;
import com.google.api.client.extensions.java6.auth.oauth2.AuthorizationCodeInstalledApp;
import com.google.api.client.extensions.jetty.auth.oauth2.LocalServerReceiver;
import com.google.api.client.googleapis.auth.oauth2.GoogleAuthorizationCodeFlow;
import com.google.api.client.googleapis.auth.oauth2.GoogleClientSecrets;
import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport;
import com.google.api.client.http.GenericUrl;
import com.google.api.client.http.HttpRequestFactory;
import com.google.api.client.http.HttpResponse;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.JsonObjectParser;
import com.google.api.client.json.gson.GsonFactory;
import com.google.api.client.util.store.MemoryDataStoreFactory;

public class GoogleLoginService {

   
    private static final JsonFactory JSON_FACTORY =
            GsonFactory.getDefaultInstance();

    
    private static final List<String> SCOPES = List.of(
            "openid",
            "profile",
            "email"
    );


    private static final String ARQUIVO_CREDENCIAIS =
            "/credentials.json";


    public static UsuarioGoogle entrarComGoogle() throws Exception {

       
        NetHttpTransport transporte =
                GoogleNetHttpTransport.newTrustedTransport();

        InputStream arquivo = GoogleLoginService.class
                .getResourceAsStream(ARQUIVO_CREDENCIAIS);

        if (arquivo == null) {
            throw new FileNotFoundException(
                    "O arquivo credentials.json não foi encontrado "
                    + "em src/main/resources."
            );
        }

      
        GoogleClientSecrets credenciaisCliente;

        try (InputStreamReader leitor = new InputStreamReader(
                arquivo,
                StandardCharsets.UTF_8
        )) {

            credenciaisCliente = GoogleClientSecrets.load(
                    JSON_FACTORY,
                    leitor
            );
        }

       
        GoogleAuthorizationCodeFlow fluxo =
                new GoogleAuthorizationCodeFlow.Builder(
                        transporte,
                        JSON_FACTORY,
                        credenciaisCliente,
                        SCOPES
                )

            
                .setDataStoreFactory(
                        MemoryDataStoreFactory.getDefaultInstance()
                )
                .setAccessType("offline")
                .build();

      
        LocalServerReceiver receptor =
                new LocalServerReceiver.Builder()
                        .setPort(-1)
                        .build();

        Credential autorizacao =
                new AuthorizationCodeInstalledApp(
                        fluxo,
                        receptor
                ).authorize("usuario");

        return buscarDadosUsuario(
                transporte,
                autorizacao
        );
    }


    private static UsuarioGoogle buscarDadosUsuario(
            NetHttpTransport transporte,
            Credential autorizacao
    ) throws Exception {

        
        HttpRequestFactory requisicoes =
                transporte.createRequestFactory(requisicao -> {

                    autorizacao.initialize(requisicao);

                    requisicao.setParser(
                            new JsonObjectParser(JSON_FACTORY)
                    );
                });

       
        GenericUrl endereco = new GenericUrl(
                "https://openidconnect.googleapis.com/v1/userinfo"
        );

        HttpResponse resposta =
                requisicoes
                        .buildGetRequest(endereco)
                        .execute();

        try {

            UsuarioGoogle usuario =
                    resposta.parseAs(UsuarioGoogle.class);

            if (usuario.getEmail() == null) {
                throw new IllegalStateException(
                        "O Google não retornou o e-mail do usuário."
                );
            }

            if (!Boolean.TRUE.equals(
                    usuario.getEmailVerificado()
            )) {
                throw new IllegalStateException(
                        "O e-mail da conta Google não está verificado."
                );
            }

            return usuario;

        } finally {

            resposta.disconnect();
        }
    }
}