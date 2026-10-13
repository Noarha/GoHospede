package application;


import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Hyperlink;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Line;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class SobrenosTela_Controle {

    @FXML
    private Hyperlink hypercontato;

    @FXML
    private Hyperlink hyperdestinos;

    @FXML
    private Hyperlink hyperinicio;

    @FXML
    private Hyperlink hyperservico;

    @FXML
    private Hyperlink hypersobrenos;

    @FXML
    private ImageView imgcalendario;

    @FXML
    private ImageView imgdiamante;

    @FXML
    private ImageView imgescudo;

    @FXML
    private ImageView imgescudo1;

    @FXML
    private ImageView imgfecha;

    @FXML
    private ImageView imgfone;

    @FXML
    private ImageView imgfundo;

    @FXML
    private ImageView imgmedalha;

    @FXML
    private ImageView imgpessoas;

    @FXML
    private Line linedourada1;

    @FXML
    private Line linedourada2;

    @FXML
    private Pane paneinferior;

    @FXML
    private Pane panesobrenos;

    @FXML
    private Pane panesuperior;

    @FXML
    private Text txt24h;

    @FXML
    private Text txtcompromisso;

    @FXML
    private Text txtconforto;

    @FXML
    private Text txtcontecomgohospede;

    @FXML
    private Text txtestamos;

    @FXML
    private Text txtexperiencia;

    @FXML
    private Text txtgarantimos;

    @FXML
    private Text txtgohospede;

    @FXML
    private Text txtmelhorpreco;

    @FXML
    private Text txtmissao;

    @FXML
    private Text txtnossavisao;

    @FXML
    private Text txtnossosvalores;

    @FXML
    private Text txtoferecer;

    @FXML
    private Text txtreserva;

    @FXML
    private Text txtserreferencia;

    @FXML
    private Text txtseusdados;

    @FXML
    private Text txtsobrenos;
    

    @FXML
    void AbrirTelacontato(ActionEvent event) {
    	

    }

    @FXML
    void AbrirTelaserviços(ActionEvent event) {
    	try {
            Parent root = FXMLLoader.load(getClass().getResource("/application/Servico.fxml"));
            Stage stage = (Stage) hyperservico.getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();

        }
    }
    @FXML
    void AbrirtelaInicio(ActionEvent event) {
    	try {
            Parent root = FXMLLoader.load(getClass().getResource("/application/TelaInicio.fxml"));
            Stage stage = (Stage) hyperinicio.getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();

        }
    }

}


