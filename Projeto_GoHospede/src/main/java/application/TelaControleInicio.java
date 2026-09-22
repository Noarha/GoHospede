package application;

import javafx.scene.input.MouseEvent;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Rectangle;
import java.util.List;
public class TelaControleInicio {

	@FXML
    private Button bntpesquisar;

    
	 @FXML
	    private Label lblmenudestinos;

    @FXML
    private Label lbldestino;

    @FXML
    private DatePicker datecheckinin;

    @FXML
    private ImageView imagemfundo;

    @FXML
    private ImageView imgcoroa;

    @FXML
    private Pane paneblack;

    @FXML
    private AnchorPane paneteste;

    @FXML
    private ImageView praiacumbuco;

    @FXML
    private ImageView praiafortaleza;

    @FXML
    private ImageView praiaporto;

    @FXML
    private Spinner<Integer> spinnerhospede;

    @FXML
    private TextField textdestino;

    @FXML
    private Label txtcheckinin;

    @FXML
    private Label txtcheckinout;

    @FXML
    private Label txtencontre;

    @FXML
    private Label txthospede;

    @FXML
    private Label txtreserve;

    @FXML
    private Label txtviagem;
    
    @FXML
    private ImageView direito;

    @FXML
    private ImageView esquerdo;
    
    @FXML
    private AnchorPane painelinicio;

    @FXML
    private Label lblmenuinicio;
    @FXML
    private AnchorPane praiasparte1;
    @FXML
    private ComboBox<String> combodestino;
    @FXML
    private AnchorPane praiasparte2;
    @FXML
    private AnchorPane paineldestinos;

    private List<AnchorPane> paineis;
    private int painelAtual = 0;
    private void mostrarPainelAtual() {

        for (int i = 0; i < paineis.size(); i++) {
            paineis.get(i).setVisible(i == painelAtual);
        }
    }
    private final ObservableList<String> todosOsLugares =
            FXCollections.observableArrayList(
                    "Fortaleza",
                    "Cumbuco",
                    "Porto das Dunas",
                    "Jericoacara",
                    "Guaramiranga"
                    );
	public void initialize() { 
		 lblmenuinicio.setStyle("-fx-text-fill: #0078D7;");
		paineldestinos.setVisible(false);
		painelinicio.setVisible(true);
		 combodestino.setEditable(true);

		    combodestino.getEditor().textProperty().addListener((obs, antigo, texto) -> {

		        String filtro = texto.toLowerCase();

		        ObservableList<String> filtrados =
		                FXCollections.observableArrayList();

		        for (String lugar : todosOsLugares) {
		            if (lugar.toLowerCase().contains(filtro)) {
		                filtrados.add(lugar);
		            }
		        }

		        combodestino.setItems(filtrados);

		        combodestino.show();
		    });
		  
		    
		 SpinnerValueFactory.IntegerSpinnerValueFactory valores =
		            new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 10, 1);

		 spinnerhospede.setValueFactory(valores);
		paineis = List.of(
			    praiasparte1,
			    praiasparte2
			);
		double largura = 250.0; 
        double altura = 150.0;
       praiafortaleza.setFitWidth(largura);
       praiafortaleza.setFitHeight(altura);
       praiafortaleza.setPreserveRatio(false);
        Rectangle clip = new Rectangle(largura, altura);
        clip.setArcWidth(10); 
        clip.setArcHeight(10);
        
        praiafortaleza.setClip(clip);
        praiacumbuco.setFitWidth(largura);
        praiacumbuco.setFitHeight(altura);
        praiacumbuco.setPreserveRatio(false);

        Rectangle clipCumbuco = new Rectangle(largura, altura);
        clipCumbuco.setArcWidth(10);
        clipCumbuco.setArcHeight(10);

        praiacumbuco.setClip(clipCumbuco);
        
        praiaporto.setFitWidth(largura);
        praiaporto.setFitHeight(altura);
        praiaporto.setPreserveRatio(false);

        Rectangle clipporto = new Rectangle(largura, altura);
        clipporto.setArcWidth(10);
        clipporto.setArcHeight(10);

        praiaporto.setClip(clipporto);
        painelAtual = 0;
		mostrarPainelAtual();
	}
	  @FXML
	    void anterior(MouseEvent event) {
		  if (painelAtual > 0) {
		        painelAtual--;
		        mostrarPainelAtual();
		    }
	    }

	    @FXML
	    void proximo(MouseEvent event) {
	    	  if (painelAtual < paineis.size() - 1) {
	    	        painelAtual++;
	    	        mostrarPainelAtual();
	    	    }
	    }
	    @FXML
	    void destinocumbuco(MouseEvent event) {
	    	Alert alert = new Alert(Alert.AlertType.INFORMATION);
	    	alert.setTitle("destino");
	    	alert.setContentText("destino cumbuco");
	    	alert.showAndWait();
	    }

	    @FXML
	    void destinofortaleza(MouseEvent event) {
	    	Alert alert = new Alert(Alert.AlertType.INFORMATION);
	    	alert.setTitle("destino");
	    	alert.setContentText("destino fortaleza");
	    	alert.showAndWait();
	    }

	    @FXML
	    void destinoporto(MouseEvent event) {
	    	Alert alert = new Alert(Alert.AlertType.INFORMATION);
	    	alert.setTitle("destino");
	    	alert.setContentText("destino porto das dunas");
	    	alert.showAndWait();
	    }
	    
	    @FXML
	    void pesquisarhoteis(MouseEvent event) {

	    }
	    @FXML
	    void destinoguaramiranga(MouseEvent event) {
	    	Alert alert = new Alert(Alert.AlertType.INFORMATION);
	    	alert.setTitle("destino");
	    	alert.setContentText("destino guaramiranga");
	    	alert.showAndWait();
	    }

	    @FXML
	    void destinojericoacara(MouseEvent event) {
	    	Alert alert = new Alert(Alert.AlertType.INFORMATION);
	    	alert.setTitle("destino");
	    	alert.setContentText("destino jericoacara");
	    	alert.showAndWait();
	    }
	    @FXML
	    void telainicio(MouseEvent event) {
	    	   lblmenuinicio.setStyle("-fx-text-fill: #0078D7;");
	    	   lblmenudestinos.setStyle("-fx-text-fill: #FFFFFF;");
	    	painelinicio.setVisible(true);
	    	paineldestinos.setVisible(false);
	    }
	    @FXML
	    void teladestinos(MouseEvent event) {
	    	 lblmenudestinos.setStyle("-fx-text-fill: #0078D7;");
	    	 lblmenuinicio.setStyle("-fx-text-fill: #FFFFFF;");
	    	painelinicio.setVisible(false);
	    	paineldestinos.setVisible(true);
	    }
	   

	}
