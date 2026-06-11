package controller.telascontrol;

import controller.CasoController;
import controller.FinalController;
import model.entidades.Suspeitos;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import java.util.ArrayList;
import java.util.List;

public class TelaAcusacaoController {

    @FXML private Label lblTituloCaso;
    @FXML private FlowPane painelSuspeitos;
    @FXML private Button btnAcusar;

    private CasoController casoController;
    private FinalController finalController;
    private List<Suspeitos> selecionados = new ArrayList<>();

    public void inicializar(CasoController casoController) {
        this.casoController = casoController;
        this.finalController = new FinalController(casoController.getHistorico());

        lblTituloCaso.setText(casoController.getTituloCaso());
        popularSuspeitos();
    }

    private void popularSuspeitos() {
        // ANTES: List<Suspeitos> todos = casoController.getFilaInterrogatorio().paraLista();
        List<Suspeitos> todos = casoController.getSuspeitosOriginais();

        for (Suspeitos s : todos) {
            VBox card = criarCardSuspeito(s);
            painelSuspeitos.getChildren().add(card);
        }
    }

    private VBox criarCardSuspeito(Suspeitos s) {
        VBox card = new VBox(8);
        card.setAlignment(Pos.CENTER);
        card.setPrefWidth(160);
        card.setStyle("-fx-cursor: hand;");


        StackPane fotoBox = new StackPane();
        fotoBox.setPrefSize(160, 200);
        fotoBox.setStyle("-fx-background-color: #2A2020;");

        ImageView iv = getImagemSuspeito(s.getNome());
        if (iv != null) {
            iv.setFitWidth(160);
            iv.setFitHeight(200);
            iv.setPreserveRatio(false);
            fotoBox.getChildren().add(iv);
        } else {
            Label placeholder = new Label("FOTO");
            placeholder.setStyle("-fx-font-family: 'Courier New'; -fx-font-size: 11px; -fx-text-fill: #555555;");
            fotoBox.getChildren().add(placeholder);
        }


        Label nome = new Label(s.getNome().split(" ")[0]); // só primeiro nome
        nome.setStyle(
                "-fx-font-family: 'Courier New'; -fx-font-size: 12px; " +
                        "-fx-text-fill: #AAAAAA; -fx-font-weight: BOLD;"
        );

        card.getChildren().addAll(fotoBox, nome);

        // Clique para selecionar/desselecionar
        card.setOnMouseClicked(e -> toggleSelecionado(s, card, fotoBox, nome));

        return card;
    }

    private void toggleSelecionado(Suspeitos s, VBox card, StackPane fotoBox, Label nome) {
        if (selecionados.contains(s)) {
            selecionados.remove(s);
            fotoBox.setStyle("-fx-background-color: #2A2020;");
            nome.setStyle(
                    "-fx-font-family: 'Courier New'; -fx-font-size: 12px; " +
                            "-fx-text-fill: #AAAAAA; -fx-font-weight: BOLD;"
            );
        } else if (selecionados.size() < 3) {
            selecionados.add(s);
            fotoBox.setStyle("-fx-background-color: #5A1010; -fx-border-color: #CC2222; -fx-border-width: 2px;");
            nome.setStyle(
                    "-fx-font-family: 'Courier New'; -fx-font-size: 12px; " +
                            "-fx-text-fill: #CC2222; -fx-font-weight: BOLD;"
            );
        }
    }

    @FXML
    private void handleVoltar() {
        try {
            FXMLLoader loader = new FXMLLoader(
                    getClass().getResource("/view/TelaAnalise.fxml")
            );
            Parent root = loader.load();

            TelaAnaliseController controller = loader.getController();
            controller.inicializar(
                    casoController,
                    new controller.EvidenciaController(casoController.getFilaEvidencias(), casoController.getHistorico()),
                    new controller.InterrogatorioController(casoController.getFilaInterrogatorio(), casoController.getHistorico())
            );

            Stage stage = (Stage) btnAcusar.getScene().getWindow();
            stage.setScene(new Scene(root, 960, 540));
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void handleAcusar() {
        if (selecionados.isEmpty()) return;

        Suspeitos s1 = selecionados.size() > 0 ? selecionados.get(0) : null;
        Suspeitos s2 = selecionados.size() > 1 ? selecionados.get(1) : null;
        Suspeitos s3 = selecionados.size() > 2 ? selecionados.get(2) : null;

        String textoFinal = finalController.finalizarInvestigacao(s1, s2, s3);

        try {
            FXMLLoader loader = new FXMLLoader(
                    getClass().getResource("/view/TelaFinal.fxml")
            );
            Parent root = loader.load();

            TelaFinalController controller = loader.getController();
            controller.inicializar(casoController, textoFinal);

            Stage stage = (Stage) btnAcusar.getScene().getWindow();
            stage.setScene(new Scene(root, 960, 540));
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private ImageView getImagemSuspeito(String nome) {
        String arquivo = "";
        if (nome.contains("Yanka")) arquivo = "Yanka.png";
        else if (nome.contains("Mariana")) arquivo = "Mariana.png";
        else if (nome.contains("Mirabela")) arquivo = "Mirabela.png";
        else if (nome.contains("Hortência") || nome.contains("Hortencia")) arquivo = "Hortencia.png";
        else if (nome.contains("Marcos")) arquivo = "Marcos.png";
        if (arquivo.isEmpty()) return null;
        var stream = getClass().getResourceAsStream("/images/" + arquivo);
        if (stream == null) return null;
        return new ImageView(new Image(stream));
    }
}