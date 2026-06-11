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
import javafx.scene.layout.VBox;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class TelaAnaliseController {

    // --- Menu lateral ---
    @FXML private Label lblDetalhes;
    @FXML private Label lblLaudo;
    @FXML private Label lblEvidencias;
    @FXML private Label lblInterrogatorio;
    @FXML private Label lblLinhaTempo;
    @FXML private Label lblHistorico;
    @FXML private Button btnAcusar;

    // --- Área central ---
    @FXML private StackPane painelCentral;

    // --- Controllers de lógica ---
    private CasoController casoController;
    private EvidenciaController evidenciaController;
    private InterrogatorioController interrogatorioController;

    private Label menuAtivo = null;

    // Estilo base e ativo do menu
    private static final String ESTILO_MENU =
            "-fx-font-family: 'Courier New'; -fx-font-size: 13px; " +
                    "-fx-text-fill: #AAAAAA; -fx-cursor: hand; -fx-padding: 10 20 10 20;";
    private static final String ESTILO_MENU_ATIVO =
            "-fx-font-family: 'Courier New'; -fx-font-size: 13px; " +
                    "-fx-text-fill: #CC2222; -fx-cursor: hand; -fx-padding: 10 20 10 20; " +
                    "-fx-font-weight: BOLD;";
    private static final String ESTILO_MENU_BLOQUEADO =
            "-fx-font-family: 'Courier New'; -fx-font-size: 13px; " +
                    "-fx-text-fill: #555555; -fx-padding: 10 20 10 20;";

    /**
     * Chamado por TelaDetalhesController após clicar em ANALISAR.
     */
    public void inicializar(CasoController casoController,
                            EvidenciaController evidenciaController,
                            InterrogatorioController interrogatorioController) {
        this.casoController = casoController;
        this.evidenciaController = evidenciaController;
        this.interrogatorioController = interrogatorioController;

        atualizarBloqueioInterrogatorio();

        // Abre na aba de detalhes por padrão
        setMenuAtivo(lblDetalhes);
        mostrarDetalhes();
    }

    // ──────────────────────────────────────────
    // Handlers do menu lateral
    // ──────────────────────────────────────────

    @FXML
    private void handleDetalhes() {
        setMenuAtivo(lblDetalhes);
        mostrarDetalhes();
    }

    @FXML
    private void handleLaudo() {
        setMenuAtivo(lblLaudo);
        mostrarLaudo();
    }

    @FXML
    private void handleEvidencias() {
        setMenuAtivo(lblEvidencias);
        mostrarEvidencias();
    }

    @FXML
    private void handleInterrogatorio() {
        if (!evidenciaController.possuiEvidencias()) {
            setMenuAtivo(lblInterrogatorio);
            mostrarInterrogatorio();
        }
        // Se ainda há evidências, ignora o clique (item bloqueado)
    }

    @FXML
    private void handleLinhaTempo() {
        setMenuAtivo(lblLinhaTempo);
        mostrarLinhaTempo();
    }

    @FXML
    private void handleHistorico() {
        setMenuAtivo(lblHistorico);
        mostrarHistorico();
    }

    @FXML
    private void handleAcusar() {
        try {
            // TODO: trocar pelo FXML da tela de acusação
            FXMLLoader loader = new FXMLLoader(
                    getClass().getResource("/view/TelaAcusacao.fxml")
            );
            Parent root = loader.load();
            Stage stage = (Stage) btnAcusar.getScene().getWindow();
            stage.setScene(new Scene(root, 960, 540));
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // ──────────────────────────────────────────
    // Conteúdo de cada painel
    // ──────────────────────────────────────────

    private void mostrarDetalhes() {
        painelCentral.getChildren().clear();
        Label txt = new Label(casoController.getDetalhesCaso());
        txt.setWrapText(true);
        txt.setStyle("-fx-font-family: 'Courier New'; -fx-font-size: 12px; -fx-text-fill: #C8B8B8;");
        painelCentral.getChildren().add(txt);
    }

    private void mostrarLaudo() {
        painelCentral.getChildren().clear();
        Label txt = new Label(casoController.getLaudo());
        txt.setWrapText(true);
        txt.setStyle("-fx-font-family: 'Courier New'; -fx-font-size: 12px; -fx-text-fill: #C8B8B8;");
        painelCentral.getChildren().add(txt);
    }

    private void mostrarEvidencias() {
        painelCentral.getChildren().clear();

        if (!evidenciaController.possuiEvidencias()) {
            Label vazio = new Label("Todas as evidências já foram analisadas.");
            vazio.setStyle("-fx-font-family: 'Courier New'; -fx-font-size: 12px; -fx-text-fill: #888888;");
            painelCentral.getChildren().add(vazio);
            return;
        }

        // Painel da evidência atual
        javafx.scene.layout.HBox card = criarCardEvidencia();
        painelCentral.getChildren().add(card);
    }

    private void mostrarInterrogatorio() {
        painelCentral.getChildren().clear();

        if (interrogatorioController.terminou()) {
            Label fim = new Label("Interrogatório encerrado.");
            fim.setStyle("-fx-font-family: 'Courier New'; -fx-font-size: 12px; -fx-text-fill: #888888;");
            painelCentral.getChildren().add(fim);
            return;
        }

        javafx.scene.layout.VBox container = new javafx.scene.layout.VBox(20);
        container.setAlignment(javafx.geometry.Pos.TOP_CENTER);
        container.setMaxWidth(680);

        // Card superior: foto + detalhes/resposta
        container.getChildren().add(criarCardSuspeito());

        // Card inferior: pergunta + seta fixa
        container.getChildren().add(criarCardPergunta());

        painelCentral.getChildren().add(container);
    }

    private void mostrarLinhaTempo() {
        painelCentral.getChildren().clear();
        // TODO: implementar linha do tempo
        Label placeholder = new Label("Linha do tempo — em breve.");
        placeholder.setStyle("-fx-font-family: 'Courier New'; -fx-font-size: 12px; -fx-text-fill: #888888;");
        painelCentral.getChildren().add(placeholder);
    }

    private void mostrarHistorico() {
        painelCentral.getChildren().clear();
        // TODO: exibir PilhaAcoes
        Label placeholder = new Label("Histórico — em breve.");
        placeholder.setStyle("-fx-font-family: 'Courier New'; -fx-font-size: 12px; -fx-text-fill: #888888;");
        painelCentral.getChildren().add(placeholder);
    }

    // ──────────────────────────────────────────
    // Cards reutilizáveis
    // ──────────────────────────────────────────

    private javafx.scene.layout.HBox criarCardEvidencia() {
        javafx.scene.layout.HBox hbox = new javafx.scene.layout.HBox(16);
        hbox.setStyle("-fx-background-color: #2A2020; -fx-padding: 20; -fx-background-radius: 4;");
        hbox.setMaxWidth(580);
        hbox.setMaxHeight(220);

        javafx.scene.layout.VBox info = new javafx.scene.layout.VBox(12);
        info.setAlignment(javafx.geometry.Pos.TOP_LEFT);

        model.entidades.Evidencias ev = evidenciaController.getEvidenciaAtual();
        Label detalhes = new Label(ev != null ? ev.toString() : "");
        detalhes.setWrapText(true);
        detalhes.setMaxWidth(300);
        detalhes.setStyle("-fx-font-family: 'Courier New'; -fx-font-size: 12px; -fx-text-fill: #C8B8B8;");

        Button btnAvancar = new Button("▶");
        btnAvancar.setStyle(
                "-fx-background-color: transparent; -fx-text-fill: #CC8888; " +
                        "-fx-font-size: 18px; -fx-cursor: hand;"
        );
        btnAvancar.setOnAction(e -> {
            evidenciaController.proximaEvidencia();
            atualizarBloqueioInterrogatorio();
            mostrarEvidencias();
        });

        info.getChildren().addAll(detalhes, btnAvancar);
        hbox.getChildren().add(info);
        return hbox;
    }

    private javafx.scene.layout.HBox criarCardSuspeito() {
        javafx.scene.layout.HBox card = new javafx.scene.layout.HBox(0);
        card.setMaxWidth(680);
        card.setPrefHeight(200);
        card.setStyle("-fx-background-color: #2A2020; -fx-background-radius: 4;");

        // Foto (esquerda)
        model.entidades.Suspeitos s = interrogatorioController.getSuspeitoAtual();

        javafx.scene.layout.StackPane fotoBox = new javafx.scene.layout.StackPane();
        fotoBox.setPrefWidth(170);
        fotoBox.setPrefHeight(200);
        fotoBox.setMinWidth(170);
        fotoBox.setStyle("-fx-background-color: #3A3030;");

        if (s != null) {
            javafx.scene.image.ImageView iv = getImagemSuspeito(s.getNome());
            if (iv != null) {
                fotoBox.getChildren().add(iv);
            } else {
                Label fotoLabel = new Label("FOTO DO\nINDIVÍDUO");
                fotoLabel.setStyle("-fx-font-family: 'Courier New'; -fx-font-size: 10px; -fx-text-fill: #666666; -fx-text-alignment: center;");
                fotoBox.getChildren().add(fotoLabel);
            }
        }

        // Detalhes + separador + resposta (direita)
        javafx.scene.layout.VBox infoBox = new javafx.scene.layout.VBox(0);
        infoBox.setPrefWidth(510);
        javafx.scene.layout.HBox.setHgrow(infoBox, javafx.scene.layout.Priority.ALWAYS);

        // Detalhes: nome, idade, profissão, relação
        String detalhesTexto = s != null
                ? s.getNome() + " | " + s.getIdade() + " anos\n"
                + s.getProfissao() + " | " + s.getRelacaoVitima()
                : "";
        Label detalhes = new Label(detalhesTexto);
        detalhes.setWrapText(true);
        detalhes.setPrefHeight(100);
        detalhes.setMaxWidth(510);
        detalhes.setStyle(
                "-fx-font-family: 'Courier New'; -fx-font-size: 12px; " +
                        "-fx-text-fill: #C8B8B8; -fx-padding: 14 16 10 16;"
        );

        javafx.scene.control.Separator sep = new javafx.scene.control.Separator();
        sep.setStyle("-fx-background-color: #3A3A3A;");

        // Resposta à pergunta atual
        Label resposta = new Label(interrogatorioController.getRespostaAtual());
        resposta.setWrapText(true);
        resposta.setPrefHeight(86);
        resposta.setMaxWidth(510);
        resposta.setStyle(
                "-fx-font-family: 'Courier New'; -fx-font-size: 12px; " +
                        "-fx-text-fill: #AAAAAA; -fx-padding: 10 16 14 16;"
        );

        infoBox.getChildren().addAll(detalhes, sep, resposta);
        card.getChildren().addAll(fotoBox, infoBox);
        return card;
    }

    private javafx.scene.image.ImageView getImagemSuspeito(String nome) {
        String nomeArquivo = "";

        if (nome.contains("César") || nome.contains("Cesar")) nomeArquivo = "Cesar.png";
        else if (nome.contains("Hortência") || nome.contains("Hortencia")) nomeArquivo = "Hortencia.png";
        else if (nome.contains("Marcos")) nomeArquivo = "Marcos.png";
        else if (nome.contains("Mariana")) nomeArquivo = "Mariana.png";
        else if (nome.contains("Yanka")) nomeArquivo = "Yanka.png";
        else if (nome.contains("Mirabela")) nomeArquivo = "Mirabela.png";
        if (nomeArquivo.isEmpty()) return null;

        javafx.scene.image.Image img = new javafx.scene.image.Image(
                getClass().getResourceAsStream("/images/" + nomeArquivo)
        );
        javafx.scene.image.ImageView iv = new javafx.scene.image.ImageView(img);
        iv.setFitWidth(170);
        iv.setFitHeight(200);
        iv.setPreserveRatio(false);
        return iv;
    }

    private javafx.scene.layout.BorderPane criarCardPergunta() {
        javafx.scene.layout.BorderPane rodape = new javafx.scene.layout.BorderPane();
        rodape.setMaxWidth(680);
        rodape.setStyle(
                "-fx-background-color: #1E1818; -fx-padding: 14 20 14 20; " +
                        "-fx-background-radius: 4;"
        );

        Label pergunta = new Label(interrogatorioController.getPerguntaAtual());
        pergunta.setWrapText(true);
        pergunta.setMaxWidth(580);
        pergunta.setStyle(
                "-fx-font-family: 'Courier New'; -fx-font-size: 12px; -fx-text-fill: #C8B8B8;"
        );

        Button btnAvancar = new Button("▶");
        btnAvancar.setStyle(
                "-fx-background-color: transparent; -fx-text-fill: #CC8888; " +
                        "-fx-font-size: 18px; -fx-cursor: hand; -fx-padding: 0 0 0 16;"
        );
        btnAvancar.setOnAction(e -> {
            interrogatorioController.avancar();
            mostrarInterrogatorio();
        });

        rodape.setLeft(pergunta);
        rodape.setRight(btnAvancar);
        javafx.scene.layout.BorderPane.setAlignment(btnAvancar, javafx.geometry.Pos.CENTER);
        javafx.scene.layout.BorderPane.setAlignment(pergunta, javafx.geometry.Pos.CENTER_LEFT);

        return rodape;
    }
    // ──────────────────────────────────────────
    // Utilitários
    // ──────────────────────────────────────────

    private void setMenuAtivo(Label item) {
        if (menuAtivo != null) menuAtivo.setStyle(ESTILO_MENU);
        menuAtivo = item;
        item.setStyle(ESTILO_MENU_ATIVO);
    }

    private void atualizarBloqueioInterrogatorio() {
        if (evidenciaController.possuiEvidencias()) {
            lblInterrogatorio.setStyle(ESTILO_MENU_BLOQUEADO);
        } else {
            lblInterrogatorio.setStyle(ESTILO_MENU);
        }
    }
}