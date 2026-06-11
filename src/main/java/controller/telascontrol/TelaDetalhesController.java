package controller.telascontrol;

import controller.CasoController;
import controller.EvidenciaController;
import controller.InterrogatorioController;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class TelaDetalhesController {


    @FXML
    private Label txtDetalhesCaso;

    @FXML
    private Button btnAnalisar;

    private CasoController casoController;

    public void inicializar(CasoController casoController) {
        this.casoController = casoController;
        txtDetalhesCaso.setText(casoController.getDetalhesCaso());
    }

    @FXML
    private void handleAnalisar() {
        try {
            FXMLLoader loader = new FXMLLoader(
                    getClass().getResource("/view/TelaAnalise.fxml")
            );
            Parent root = loader.load();

            TelaAnaliseController proximoController = loader.getController();
            proximoController.inicializar(
                    casoController,
                    new EvidenciaController(casoController.getFilaEvidencias(), casoController.getHistorico()),
                    new InterrogatorioController(casoController.getFilaInterrogatorio(), casoController.getHistorico())
            );

            Stage stage = (Stage) btnAnalisar.getScene().getWindow();
            stage.setScene(new Scene(root, 960, 540));
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void handleBtnHoverEnter() {
        btnAnalisar.setStyle(
                "-fx-font-family: 'Courier New';" +
                        "-fx-font-size: 13px;" +
                        "-fx-font-weight: BOLD;" +
                        "-fx-text-fill: #3A1A1A;" +
                        "-fx-background-color: #F0D0D0;" +
                        "-fx-border-color: #D0A0A0;" +
                        "-fx-border-width: 1px;" +
                        "-fx-padding: 10 40 10 40;" +
                        "-fx-cursor: hand;" +
                        "-fx-background-radius: 2px;"
        );
    }

    @FXML
    private void handleBtnHoverExit() {
        btnAnalisar.setStyle(
                "-fx-font-family: 'Courier New';" +
                        "-fx-font-size: 13px;" +
                        "-fx-font-weight: BOLD;" +
                        "-fx-text-fill: #5A3A3A;" +
                        "-fx-background-color: #E8C8C8;" +
                        "-fx-border-color: #C8A0A0;" +
                        "-fx-border-width: 1px;" +
                        "-fx-padding: 10 40 10 40;" +
                        "-fx-cursor: hand;" +
                        "-fx-background-radius: 2px;"
        );
    }
}