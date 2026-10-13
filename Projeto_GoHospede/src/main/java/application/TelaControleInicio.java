package application;

import javafx.scene.input.MouseEvent;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
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
import javafx.stage.Stage;

import java.io.IOException;
import java.time.LocalDate;
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
    private ImageView praiafortaleza11;
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
    private DatePicker ckechinOUt;
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
   @FXML
   private ImageView guara;

   @FXML
   private ImageView praiacanoa; 
   @FXML
   private ImageView praiajeri;
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
                    "Guaramiranga",
                    "Canoa Quebrada"
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
        
        
        
        praiacanoa.setFitWidth(largura);
        praiacanoa.setFitHeight(altura);
        praiacanoa.setPreserveRatio(false);

        Rectangle clipCanoa = new Rectangle(largura, altura);
        clipCanoa.setArcWidth(10);
        clipCanoa.setArcHeight(10);

        praiacanoa.setClip(clipCanoa);
        
        
        praiajeri.setFitWidth(largura);
        praiajeri.setFitHeight(altura);
        praiajeri.setPreserveRatio(false);

        Rectangle clipJeri = new Rectangle(largura, altura);
        clipJeri.setArcWidth(10);
        clipJeri.setArcHeight(10);

        praiajeri.setClip(clipJeri);
        
        
        guara.setFitWidth(largura);
        guara.setFitHeight(altura);
        guara.setPreserveRatio(false);

        Rectangle clipGuara = new Rectangle(largura, altura);
        clipGuara.setArcWidth(10);
        clipGuara.setArcHeight(10);

        guara.setClip(clipGuara);
        
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
	    @FXML
	    void destinocanoa(MouseEvent event) {
	    	Alert alert = new Alert(Alert.AlertType.INFORMATION);
	    	alert.setTitle("destino");
	    	alert.setContentText("destino guaramiranga");
	    	alert.showAndWait();
	    }
	    @FXML
	    private void pesquisarHoteis(ActionEvent event) throws IOException {

	        // Pega os dados escolhidos na primeira tela
	        String destino = combodestino.getValue();
	        LocalDate entrada = datecheckinin.getValue();
	        LocalDate saida = ckechinOUt.getValue();
	        Integer hospedes = spinnerhospede.getValue();

	        // Verifica se o destino foi informado
	        if (destino == null || destino.trim().isEmpty()) {
	            Alert alert = new Alert(Alert.AlertType.WARNING);
	            alert.setTitle("Atenção");
	            alert.setHeaderText(null);
	            alert.setContentText("Selecione um destino.");
	            alert.showAndWait();
	            return;
	        }

	        // Verifica a entrada
	        if (entrada == null) {
	            Alert alert = new Alert(Alert.AlertType.WARNING);
	            alert.setTitle("Atenção");
	            alert.setHeaderText(null);
	            alert.setContentText("Informe a data de entrada.");
	            alert.showAndWait();
	            return;
	        }

	        // Verifica a saída
	        if (saida == null) {
	            Alert alert = new Alert(Alert.AlertType.WARNING);
	            alert.setTitle("Atenção");
	            alert.setHeaderText(null);
	            alert.setContentText("Informe a data de saída.");
	            alert.showAndWait();
	            return;
	        }

	        // Verifica as datas
	        if (saida.isBefore(entrada) || saida.isEqual(entrada)) {
	            Alert alert = new Alert(Alert.AlertType.WARNING);
	            alert.setTitle("Atenção");
	            alert.setHeaderText(null);
	            alert.setContentText(
	                "A data de saída deve ser posterior à data de entrada."
	            );
	            alert.showAndWait();
	            return;
	        }

	        // Verifica hóspedes
	        if (hospedes == null || hospedes <= 0) {
	            Alert alert = new Alert(Alert.AlertType.WARNING);
	            alert.setTitle("Atenção");
	            alert.setHeaderText(null);
	            alert.setContentText("Informe a quantidade de hóspedes.");
	            alert.showAndWait();
	            return;
	        }

	        // Carrega a segunda tela
	        FXMLLoader loader = new FXMLLoader(
	            getClass().getResource("/application/telapraiafortaleza.fxml")
	        );

	        Parent root = loader.load();

	        // Pega o controller da segunda tela
	        Tela_Controle_Fortaleza controller =
	            loader.getController();

	        // Envia os dados da primeira tela para a segunda
	        controller.receberPesquisa(
	            destino,
	            entrada,
	            saida,
	            hospedes
	        );

	        // Troca de tela
	        Stage stage = (Stage) ((Node) event.getSource())
	            .getScene()
	            .getWindow();

	        stage.setScene(new Scene(root));
	        stage.show();
	    }

	}
