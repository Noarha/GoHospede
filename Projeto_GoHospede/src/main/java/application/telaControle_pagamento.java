package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.ImageView;
import javafx.scene.input.Clipboard;
import javafx.scene.input.ClipboardContent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.shape.Line;
import javafx.scene.text.Text;

public class telaControle_pagamento {

    @FXML
    private AnchorPane achorpanesuperior;

    @FXML
    private Pane botaocartao;

    @FXML
    private Button botaofinalizarpagamento;

    @FXML
    private Pane botaopix;

    @FXML
    private Hyperlink hypercontato;

    @FXML
    private Hyperlink hyperinicio;

    @FXML
    private Hyperlink hyperservico;

    @FXML
    private Hyperlink hypersobrenos;

    @FXML
    private ImageView imgCopiarPix;

    @FXML
    private ImageView imgcadeado;

    @FXML
    private ImageView imgcalendario;

    @FXML
    private ImageView imgcartao;

    @FXML
    private ImageView imgcartao1;

    @FXML
    private ImageView imgescudo;

    @FXML
    private ImageView imgfone;

    @FXML
    private ImageView imgfundo;

    @FXML
    private ImageView imgmedalha;

    @FXML
    private ImageView imgpix;

    @FXML
    private ImageView imgpix1;

    @FXML
    private ImageView imgpix2;

    @FXML
    private ImageView imgqrcode;

    @FXML
    private ImageView imgrelogio;

    @FXML
    private Line line1;

    @FXML
    private Line line2;

    @FXML
    private ToggleGroup pagamentoGroup;

    @FXML
    private Pane panePix;

    @FXML
    private Pane panecartao;

    @FXML
    private Pane panedoqrcode;

    @FXML
    private Pane panefundo;

    @FXML
    private Pane paneinferior;

    @FXML
    private Pane panepix;

    @FXML
    private RadioButton rbCartao;

    @FXML
    private RadioButton rbPix;

    @FXML
    private StackPane stack;

    @FXML
    private Text txtatendimento24h;

    @FXML
    private Text txtcartao;

    @FXML
    private Text txtcodigopix;

    @FXML
    private Text txtcodigopix1;

    @FXML
    private Text txtconforto;

    @FXML
    private Text txtcvv;

    @FXML
    private Text txtescaneie;

    @FXML
    private Text txtescaneie1;

    @FXML
    private Text txtescolhaaforma;

    @FXML
    private Text txtexperiencia;

    @FXML
    private TextField txtfieldcodigopix;

    @FXML
    private TextField txtfieldcvv;

    @FXML
    private TextField txtfieldnumerocartao;

    @FXML
    private TextField txtfieldvalidade;

    @FXML
    private Text txtgarantimos;

    @FXML
    private Text txtgo;

    @FXML
    private Text txthospede;

    @FXML
    private Text txthttps;

    @FXML
    private Text txtmelhores;

    @FXML
    private Text txtou;

    @FXML
    private Text txtpagamento;

    @FXML
    private Text txtpagarcompix;

    @FXML
    private Text txtpagarcompix1;

    @FXML
    private Text txtpix;

    @FXML
    private Text txtrapido;

    @FXML
    private Text txtreserva;

    @FXML
    private Text txtseusdados;

    @FXML
    private Text txtsuporte;

    @FXML
    private Text txtvalidade;

    @FXML
    private Text txtvalido;

    @FXML
    private Text txtvisamastercard;

    @FXML
    private HBox xboxpaia;


@FXML
private void selecionarCartao(ActionEvent event) {
    panePix.setVisible(false);
    panecartao.setVisible(true);
}

@FXML
private void selecionarPix(ActionEvent event) {
    panePix.setVisible(true);
    panecartao.setVisible(false);
}

@FXML
public void initialize() {
    imgCopiarPix.setOnMouseClicked(event -> {
       
        String codigo = txtcodigopix.getText();

       
        ClipboardContent conteudo = new ClipboardContent();
        conteudo.putString(codigo);

        Clipboard clipboard = Clipboard.getSystemClipboard();
        clipboard.setContent(conteudo);

        System.out.println("Código PIX copiado!");
    });
}
}







