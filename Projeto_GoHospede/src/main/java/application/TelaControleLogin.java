package application;

import java.io.IOException;

import javafx.concurrent.Task;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class TelaControleLogin {

    @FXML
    private Button Entrarbotton;

    @FXML
    private ImageView Tela;

    @FXML
    private Text acesse;

    @FXML
    private Text bemvindo;

    @FXML
    private Pane cadastro;

    @FXML
    private Hyperlink cadastros;

    @FXML
    private Text email;

    @FXML
    private TextField emailescrever;

    @FXML
    private ImageView imagemgoogle;

    @FXML
    private Text login;

    @FXML
    private Text senha;

    @FXML
    private PasswordField senhaescrever;

    @FXML
    private TextField senhaescrever2;

    @FXML
    void EntrarComoGoogle(MouseEvent event) {
    	imagemgoogle.setDisable(true);
    	
    	Task<UsuarioGoogle> tarefaLogin = new Task<>() {
    		@Override
    		protected UsuarioGoogle call() throws Exception{
    			return GoogleLoginService.entrarComGoogle();
    		}
    	};
    	tarefaLogin.setOnSucceeded(evento ->{
    		UsuarioGoogle usuario = tarefaLogin.getValue();   	
    		
    	try {
    		abrirtela(usuario);
    	}catch(IOException e) {
    			e.printStackTrace();
    			mostrarErro(e.getMessage());
    		}
    	}
    	);
    	
    	tarefaLogin.setOnFailed(evento ->{
    		Throwable erro = tarefaLogin.getException();
    		erro.printStackTrace();
    		imagemgoogle.setDisable(false);
    	}
    	);
    	Thread thread = new Thread(tarefaLogin,"login-google");
    	thread.start();
    }
    private void abrirtela(UsuarioGoogle usuario) throws IOException {
    	/*FXMLLoader carregartela = new FXMLLoader(getClass().getResource("/application/telaprincipal.fxml"));
    Parent tela = carregartela.load();
    Tela_Controle_Principal controller = carregartela.getController();
    controller.receberUsuario(usuario);
    Stage janela =(Stage) imagemgoogle.getScene().getWindow();
    janela.setScene(new Scene (tela));*/
    	Alert alert = new Alert(Alert.AlertType.INFORMATION);
    	alert.setTitle("Login com Google");
    	alert.setHeaderText("Login realizado com sucesso");
    	alert.setContentText("Entrada com sucesso");
    	alert.showAndWait();
    }
    private void mostrarErro(String mensagem) {
    	Alert alert = new Alert(Alert.AlertType.ERROR);
    	alert.setTitle("Login com Google");
    	alert.setHeaderText("Erro na autenticação");
    	alert.setContentText(mensagem);
    	alert.showAndWait();
    }
    
    @FXML
    void abrirTelaControleCadastro(ActionEvent event) {
    	try {
            Parent root = FXMLLoader.load(getClass().getResource("/application/TelaCadastro.fxml"));
            Stage stage = (Stage) cadastros.getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
            mostrarErro("Não foi possível carregar a tela de cadastro: " + e.getMessage());
        }
    }
        
    @FXML
    void entrar(ActionEvent event) {

    }

}
