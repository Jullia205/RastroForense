package controller.telascontrol;

import controller.CasoController;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class TelaPrincipalController {

    @FXML
    private Button btnAbrirCaso;

    private final CasoController casoController = new CasoController();

    @FXML
    private void handleAbrirCaso() {
        try {
            casoController.abrirCaso();

            FXMLLoader loader = new FXMLLoader(
                    getClass().getResource("/view/TelaDetalhes.fxml")
            );
            Parent root = loader.load();

            TelaDetalhesController proximoController = loader.getController();
            proximoController.inicializar(casoController);

            Stage stage = (Stage) btnAbrirCaso.getScene().getWindow();
            stage.setScene(new Scene(root, 960, 540));
            stage.show();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void handleBtnHoverEnter() {
        btnAbrirCaso.setStyle(
                "-fx-font-family: 'Courier New';" +
                        "-fx-font-size: 14px;" +
                        "-fx-font-weight: BOLD;" +
                        "-fx-text-fill: #FFFFFF;" +
                        "-fx-background-color: #555555;" +
                        "-fx-border-color: #AAAAAA;" +
                        "-fx-border-width: 2px;" +
                        "-fx-padding: 10 28 10 28;" +
                        "-fx-cursor: hand;"
        );
    }

    @FXML
    private void handleBtnHoverExit() {
        btnAbrirCaso.setStyle(
                "-fx-font-family: 'Courier New';" +
                        "-fx-font-size: 14px;" +
                        "-fx-font-weight: BOLD;" +
                        "-fx-text-fill: #CCCCCC;" +
                        "-fx-background-color: #3A3A3A;" +
                        "-fx-border-color: #888888;" +
                        "-fx-border-width: 2px;" +
                        "-fx-padding: 10 28 10 28;" +
                        "-fx-cursor: hand;"
        );
    }
}