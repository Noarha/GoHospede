package application;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Hyperlink;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Line;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class servicoTela_Controle {

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
    private ImageView imgbandeja;

    @FXML
    private ImageView imgcalendario;

    @FXML
    private ImageView imgcalendario2;

    @FXML
    private ImageView imgcama;

    @FXML
    private ImageView imgcarro;

    @FXML
    private ImageView imgescudo;

    @FXML
    private ImageView imgfone;

    @FXML
    private ImageView imgfundo;

    @FXML
    private ImageView imgmedalha;

    @FXML
    private Line line1;

    @FXML
    private Line line2;

    @FXML
    private Line line3;

    @FXML
    private Line line4;

    @FXML
    private Line line5;

    @FXML
    private Pane paneservico;

    @FXML
    private Pane panesuperior;

    @FXML
    private Text txtasmelhores;

    @FXML
    private Text txtatendimento;

    @FXML
    private Text txtatividade;

    @FXML
    private Text txtconforto;

    @FXML
    private Text txtestamos;

    @FXML
    private Text txtestamossempre;

    @FXML
    private Text txtexperiencia;

    @FXML
    private Text txtexperiencias;

    @FXML
    private Text txtgarantimos;

    @FXML
    private Text txtmelhores;

    @FXML
    private Text txtmontamos;

    @FXML
    private Text txtplanejamento;

    @FXML
    private Text txtreserva;

    @FXML
    private Text txtservico;

    @FXML
    private Text txtseusdados;

    @FXML
    private Text txtsolucoes;

    @FXML
    private Text txtsuporte;

    @FXML
    private Text txttransfers;

    @FXML
    private Text txttraslados;
    
    @FXML
    void AbrirTelaSobrenos(ActionEvent event) {
    	try {
            Parent root = FXMLLoader.load(getClass().getResource("/application/sobrenos.fxml"));
            Stage stage = (Stage) hypersobrenos.getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();

        }
    }

    @FXML
    void AbrirTelainicio(ActionEvent event) {
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





