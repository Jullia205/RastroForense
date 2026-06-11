package controller.telascontrol;

import controller.CasoController;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class TelaFinalController {

    @FXML private Label lblTituloCaso;
    @FXML private Label lblDetalhesFinais;
    @FXML private Label lblTextoFinal;

    public void inicializar(CasoController casoController, String textoFinal) {
        lblTituloCaso.setText(casoController.getTituloCaso());
        lblDetalhesFinais.setText(casoController.getDetalhesCaso());
        lblTextoFinal.setText(textoFinal);
    }

    @FXML
    private void handleEncerrar() {
        Stage stage = (Stage) lblTextoFinal.getScene().getWindow();
        stage.close();
    }
}