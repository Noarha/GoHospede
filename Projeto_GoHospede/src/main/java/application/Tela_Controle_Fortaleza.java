package application;

import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.control.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
public class Tela_Controle_Fortaleza {

	

    @FXML
    private TableColumn<Hotel, String> late;
    
    @FXML
    private TableColumn<Hotel, String> lcidade;
    
    @FXML
    private TableColumn<Hotel, String> ldisponivel;

    @FXML
    private TableColumn<Hotel, String> lhotel;

    @FXML
    private TableColumn<Hotel, String> lquantidade;

    @FXML
    private TableColumn<Hotel, String> lvalor;

    
    @FXML
    private TableView<Hotel> as;

 

    @FXML
    private ComboBox<Integer> combohospede;

    @FXML
    private ComboBox<String> combolocal;

    @FXML
    private ImageView imagecalendario;

    @FXML
    private ImageView imagefortaleza;

    @FXML
    private ImageView imagelocalizador;

    @FXML
    private ImageView imagepessoa;

    @FXML
    private Label lblmenucontato;

    @FXML
    private Label lblmenudestinos;

    @FXML
    private Label lblmenuinicio;

    @FXML
    private Label lblmenuservico;

    @FXML
    private Label lblmenusobre;

    @FXML
    private Pane paneblack;
    @FXML
    private DatePicker dtEntrada;

    @FXML
    private DatePicker dtSaida;
    @FXML
    private Button btnpesquisar;
    @FXML
    void teladestinos(MouseEvent event) {

    }

    @FXML
    void telainicio(MouseEvent event) {

    }
    @FXML
    public void initialize() {

        carregarCidades();

        combohospede.getItems().addAll(
            1, 2, 3, 4, 5, 6 , 7 , 8 , 9 , 10
        );

        lhotel.setCellValueFactory(
            new PropertyValueFactory<>("nome")
        );

        lcidade.setCellValueFactory(
            new PropertyValueFactory<>("cidade")
        );

        ldisponivel.setCellValueFactory(
            new PropertyValueFactory<>("disponivelDe")
        );

        late.setCellValueFactory(
            new PropertyValueFactory<>("disponivelAte")
        );

        lvalor.setCellValueFactory(
            new PropertyValueFactory<>("valor")
        );

        lquantidade.setCellValueFactory(
            new PropertyValueFactory<>("quartos")
        );
    }
    private void carregarCidades() {

        combolocal.getItems().clear();

        try (BufferedReader br =
                 new BufferedReader(new FileReader("dados/cidades.txt"))) {

            String linha;

            while ((linha = br.readLine()) != null) {

                if (!linha.trim().isEmpty()) {
                    combolocal.getItems().add(linha);
                }
            }

        } catch (IOException e) {

            alerta(
                "Erro",
                "Não foi possível carregar cidades.txt"
            );
        }
    }
    @FXML
    private void pesquisar() {

        String cidade = combolocal.getValue();

        LocalDate entrada = dtEntrada.getValue();
        LocalDate saida = dtSaida.getValue();

        Integer hospedes = combohospede.getValue();

        if (cidade == null) {

            alerta(
                "Atenção",
                "Selecione uma cidade."
            );

            return;
        }

        if (entrada == null) {

            alerta(
                "Atenção",
                "Informe a data de entrada."
            );

            return;
        }

        if (saida == null) {

            alerta(
                "Atenção",
                "Informe a data de saída."
            );

            return;
        }

        if (hospedes == null) {

            alerta(
                "Atenção",
                "Informe a quantidade de hóspedes."
            );

            return;
        }

        if (saida.isBefore(entrada) ||
            saida.isEqual(entrada)) {

            alerta(
                "Atenção",
                "A data de saída deve ser posterior à entrada."
            );

            return;
        }

        carregarHoteis(
            cidade,
            entrada,
            saida
        );
    }
    private void carregarHoteis(
            String cidadePesquisa,
            LocalDate entradaPesquisa,
            LocalDate saidaPesquisa) {

        ObservableList<Hotel> lista =
                FXCollections.observableArrayList();

        DateTimeFormatter formato =
                DateTimeFormatter.ofPattern("dd/MM/yyyy");

        try (BufferedReader br =
                 new BufferedReader(
                     new FileReader("dados/hoteis.txt"))) {

            String linha;

            while ((linha = br.readLine()) != null) {

                // Ignora linhas vazias
                if (linha.trim().isEmpty()) {
                    continue;
                }

                String[] dados = linha.split(";", -1);

                // Precisamos de 6 informações
                if (dados.length < 6) {
                    System.out.println("Linha inválida no hoteis.txt:");
                    System.out.println(linha);
                    continue;
                }

                String nome = dados[0].trim();
                String cidade = dados[1].trim();

                LocalDate disponivelDe =
                        LocalDate.parse(
                            dados[2].trim(),
                            formato
                        );

                LocalDate disponivelAte =
                        LocalDate.parse(
                            dados[3].trim(),
                            formato
                        );

                double valor =
                        Double.parseDouble(
                            dados[4].trim()
                        );

                int quartos =
                        Integer.parseInt(
                            dados[5].trim()
                        );

                boolean cidadeIgual =
                        cidade.equalsIgnoreCase(cidadePesquisa);

                boolean entradaValida =
                        !entradaPesquisa.isBefore(disponivelDe);

                boolean saidaValida =
                        !saidaPesquisa.isAfter(disponivelAte);

                if (cidadeIgual
                        && entradaValida
                        && saidaValida
                        && quartos > 0) {

                    Hotel hotel = new Hotel(
                        nome,
                        cidade,
                        disponivelDe,
                        disponivelAte,
                        valor,
                        quartos
                    );

                    lista.add(hotel);
                }
            }

            as.setItems(lista);

            if (lista.isEmpty()) {

                alerta(
                    "Pesquisa",
                    "Nenhum hotel disponível para este período."
                );
            }

        } catch (Exception e) {

            e.printStackTrace();

            alerta(
                "Erro",
                "Erro ao carregar os hotéis."
            );
        }
    }
    private void alerta(String titulo, String mensagem) {

        Alert alert = new Alert(
            Alert.AlertType.INFORMATION
        );

        alert.setTitle(titulo);
        alert.setHeaderText(null);
        alert.setContentText(mensagem);

        alert.showAndWait();
    }
}
