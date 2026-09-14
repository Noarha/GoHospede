package application;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;

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
    private TextField txtconfirmarsenha;

    @FXML
    private TextField txtnascimento;

    @FXML
    private TextField txtnome;

    @FXML
    private TextField txtsenha;

    @FXML
    private TextField txttelefone;
    
    @FXML
    private void cadastrar(ActionEvent event) {

        String nome = txtnome.getText().trim();
        String email = txtEmail.getText().trim();
        String telefone = txttelefone.getText().trim();
        String nascimento = txtnascimento.getText().trim();
        String senha = txtsenha.getText();
        String confirmarSenha = txtconfirmarsenha.getText();


        if (nome.isEmpty() ||
            email.isEmpty() ||
            telefone.isEmpty() ||
            nascimento.isEmpty() ||
            senha.isEmpty() ||
            confirmarSenha.isEmpty()) {

            Alert alerta = new Alert(Alert.AlertType.WARNING);
            alerta.setTitle("Cadastro");
            alerta.setHeaderText(null);
            alerta.setContentText("Preencha todos os campos para realizar o cadastro.");
            alerta.showAndWait();

            return;
        }

        if (!senha.equals(confirmarSenha)) {

            Alert alerta = new Alert(Alert.AlertType.ERROR);
            alerta.setTitle("Cadastro");
            alerta.setHeaderText(null);
            alerta.setContentText("As senhas não são iguais.");
            alerta.showAndWait();

            return;
        }

        if (!CheckBox.isSelected()) {

            Alert alerta = new Alert(Alert.AlertType.WARNING);
            alerta.setTitle("Cadastro");
            alerta.setHeaderText(null);
            alerta.setContentText("Você precisa aceitar os termos de uso e a política de privacidade.");
            alerta.showAndWait();

            return;
        }

        Alert alerta = new Alert(Alert.AlertType.INFORMATION);
        alerta.setTitle("Cadastro");
        alerta.setHeaderText(null);
        alerta.setContentText("Cadastro realizado com sucesso!");
        alerta.showAndWait();
    }


}
