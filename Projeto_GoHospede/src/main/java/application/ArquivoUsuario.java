package application;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.security.SignatureSpi;
import java.util.ArrayList;
import java.util.List;


public class ArquivoUsuario {
	public static final String caminho = "dados/usuario.txt";
	public static void criarArquivo() {
		try {
			File pasta = new File("dados");
			if(!pasta.exists()) {
				pasta.mkdir();
			}
			File arquivo = new File(caminho);
			if(!arquivo.exists()) {
				arquivo.createNewFile();
			}
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
	public static boolean cadastrar(Usuario usuario) {
		criarArquivo();
		if(emailExiste(usuario.getEmail())) {
			return false;
		}
		try (
			BufferedWriter escritor = new BufferedWriter(new FileWriter(caminho,true))) {
				escritor.write(usuario.converterParaLinha());
				escritor.newLine();
				return true;
		}catch(Exception e) {
			System.out.println((e.getMessage()));
			return false;
		}
	}
	public static boolean emailExiste(String email) {
		List<Usuario> usuarios = listar();
		for(Usuario usuario:usuarios) {
			if(usuario.getEmail().equalsIgnoreCase(email)) {
				return true;
			}
		}
		return false;
	}
	public static List<Usuario> listar(){
		criarArquivo();
		List<Usuario> usuarios = new ArrayList<>();
		try(BufferedReader leitor = new BufferedReader(
				new FileReader(caminho))){
			String linha;
			while((linha=leitor.readLine()) != null) {
				if(linha.isBlank()) {
					continue;
				}
				String[] dados = linha.split(";");
				if(dados.length!=6) {
					continue;
				}
				Usuario usuario = new Usuario(
								dados[0],
								dados[1],
								dados[2],
								dados[3],
								dados[4],
								dados[5]
			
						);
				usuarios.add(usuario);		
			}
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		return usuarios;
	}
	public static Usuario fazerLogin(String email, String senha) {
		
		List<Usuario> usuarios = listar();
		for(Usuario usuario:usuarios) {
			
			boolean emailCorreto = usuario.getEmail().equalsIgnoreCase(email);
			boolean senhaCorreta = usuario.getSenha().equalsIgnoreCase(senha);
			System.out.println(emailCorreto+";"+senhaCorreta);
			if (emailCorreto && senhaCorreta) {
			
				return usuario;
			}
		}
		
		return null;
	}
}


