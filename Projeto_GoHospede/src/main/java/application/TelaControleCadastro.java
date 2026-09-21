package application;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class TelaControleCadastro {
    @FXML
    private CheckBox Mostrarsenha;

    @FXML
    private CheckBox CheckBox;

    @FXML
    private Hyperlink Entrar;

    @FXML
    private Hyperlink PoliticaPri;

    @FXML
    private AnchorPane Telalogin;

    @FXML
    private Hyperlink TermoDUso;

    @FXML
    private Button buttonCadastro;

    @FXML
    private ImageView imagem;

    @FXML
    private ImageView imgCadeado;

    @FXML
    private ImageView imgCadeado2;

    @FXML
    private ImageView imgData;

    @FXML
    private ImageView imgEmail;

    @FXML
    private ImageView imgPerfil;

    @FXML
    private ImageView imgSeta;

    @FXML
    private ImageView imgTelefone;

    @FXML
    private Pane pNome;

    @FXML
    private Pane pTelefone;

    @FXML
    private Pane pane;

    @FXML
    private Pane panesenha;

    @FXML
    private Pane pconfisenha;

    @FXML
    private Pane pdataNascimento;

    @FXML
    private Pane pemail;

    @FXML
    private Text text;

    @FXML
    private Text texto;

    @FXML
    private Text texto2;

    @FXML
    private Text texto3;

    @FXML
    private Text texto4;

    @FXML
    private TextField txtEmail;


    @FXML
    private PasswordField PfDigitesenha1;

    @FXML
    private PasswordField PfDigitesenha2;
    
    @FXML
    private DatePicker datanascimento;

    @FXML
    private TextField txtnome;
    
    @FXML
    private TextField txtcpf;


    @FXML
    private TextField txttelefone;
    
    public static boolean validarSenhaSegura(String senha) {
    	if (senha == null || senha.isEmpty()) {
    		return false;
    	}
    	if(senha.length()<8) {
    		return false;
    	}
    	if(senha.contains(" ")) {
    		return false;
    	}
    	if(!senha.matches(".*[a-z].*")) {
    		return false;
    	}
    	if(!senha.matches(".*[A-Z].*")) {
    		return false;
    	}
    	if(!senha.matches(".*[0-9].*")) {
    		return false;
    	}
    	if(!senha.matches(".*[.!@#$%&*()?/<>_=\\-].*")) {
    		return false;
    	}
    	return true;
    }
    public void initialize() {
    	mascaras mask = new mascaras();
    	mask.aplicarMascara(txtcpf,"###.###.###-##");
    	mask.aplicarMascara(txttelefone,"(##)#####-####");
    } 	

    @FXML
    private void cadastrar(ActionEvent event) {

        String nome = txtnome.getText().toLowerCase().strip();
        String email = txtEmail.getText().strip();
        String telefone = txttelefone.getText().strip();
        LocalDate data = datanascimento.getValue();
    	DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
       	String nascimento = data.format(formato);
        String senha = PfDigitesenha1.getText().strip();
        String confirmarSenha = PfDigitesenha2.getText().strip();
        String cpf = txtcpf.getText().strip();
    	String cpflimpo = txtcpf.getText().strip().replaceAll("[.-]","");


        if (nome.isEmpty() ||
            email.isEmpty() ||
            telefone.isEmpty() ||
            nascimento.isEmpty() ||
            senha.isEmpty() ||
            confirmarSenha.isEmpty()) {

    		Alert alert = new Alert(Alert.AlertType.ERROR);
    		alert.setTitle("Erro no Cadastro");
    		alert.setContentText("Não pode conter campos vazios");
    		alert.showAndWait();

            return;
        }else {
    		if(nome.matches("[a-z ]+")) {
    			if(email.matches("[A-Za-z0-9.%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}")) {
    				ValidaCPF val = new ValidaCPF();
    				if(val.isCPF(cpflimpo)) {
    					if(validarSenhaSegura(senha)) {
    						if(senha.equals(confirmarSenha)) {
    							Alert alert = new Alert(Alert.AlertType.INFORMATION);
        			    		alert.setTitle("Cadastro");
        			    		alert.setContentText("Cadastro realizado com sucesso!");
        			    		alert.showAndWait();
    						}else {
        						Alert alert = new Alert(Alert.AlertType.ERROR);
        			    		alert.setTitle("Erro no Cadastro");
        			    		alert.setContentText("As senha precisam ser iguais");
        			    		alert.showAndWait();
        					}
    						
    					}else {
    	    				Alert alert = new Alert(Alert.AlertType.ERROR);
    	    	    		alert.setTitle("Erro no Cadastro");
    	    	    		alert.setContentText("Senha inválida!A senha deve conter pelo menos 8 dígitos, um letra ,maiúscula e um caractere especial");
    	    	    		alert.showAndWait();
    	    			}
    				}else {
    					Alert alert = new Alert(Alert.AlertType.ERROR);
    	        		alert.setTitle("Erro no Cadastro");
    	        		alert.setContentText("CPF inválido!");
    	        		alert.showAndWait();
    				}
    				
    			}else {
    				Alert alert = new Alert(Alert.AlertType.ERROR);
            		alert.setTitle("Erro no Cadastro");
            		alert.setContentText("Email inválido!");
            		alert.showAndWait();
    			}
    		}else {
        		Alert alert = new Alert(Alert.AlertType.ERROR);
        		alert.setTitle("Erro no Cadastro");
        		alert.setContentText("Nome inválido!");
        		alert.showAndWait();
    		}
        }
        if (!CheckBox.isSelected()) {

            Alert alerta = new Alert(Alert.AlertType.WARNING);
            alerta.setTitle("Cadastro");
            alerta.setHeaderText(null);
            alerta.setContentText("Você precisa aceitar os termos de uso e a política de privacidade.");
            alerta.showAndWait();

            return;
        }
    }
}
