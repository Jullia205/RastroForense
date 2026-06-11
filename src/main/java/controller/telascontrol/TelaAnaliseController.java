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
import model.entidades.Ocorrencia;
import model.ferramentas.BlocoDeNotas;
import model.ferramentas.LinhaDoTempo;

import java.util.List;

public class TelaAnaliseController {

    //Menu lateral
    @FXML private Label lblBlocoDeNotas;
    @FXML private Label lblDetalhes;
    @FXML private Label lblLaudo;
    @FXML private Label lblEvidencias;
    @FXML private Label lblInterrogatorio;
    @FXML private Label lblLinhaTempo;
    @FXML private Label lblHistorico;
    @FXML private Button btnAcusar;

    @FXML private StackPane painelCentral;

    //Controllers de lógica
    private CasoController casoController;
    private BlocoDeNotas blocoDeNotas;
    private EvidenciaController evidenciaController;
    private InterrogatorioController interrogatorioController;
    private LinhaDoTempo linhaDoTempo;

    private Label menuAtivo = null;

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

    //Chamado por TelaDetalhesController após clicar em ANALISAR.

    public void inicializar(CasoController casoController,
                            EvidenciaController evidenciaController,
                            InterrogatorioController interrogatorioController) {
        this.casoController = casoController;
        this.blocoDeNotas = casoController.getNotas();
        this.evidenciaController = evidenciaController;
        this.interrogatorioController = interrogatorioController;
        this.linhaDoTempo = casoController.getLinhaDoTempo();

        // Abre na aba de detalhes por padrão
        setMenuAtivo(lblDetalhes);
        mostrarDetalhes();
    }


    @FXML
    private void handleBlocoDeNotas() {
        setMenuAtivo(lblBlocoDeNotas);
        mostrarBlocoDeNotas();
    }

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
        setMenuAtivo(lblInterrogatorio);
        mostrarInterrogatorio();
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
            FXMLLoader loader = new FXMLLoader(
                    getClass().getResource("/view/TelaAcusacao.fxml")
            );
            Parent root = loader.load();

            TelaAcusacaoController controller = loader.getController();
            controller.inicializar(casoController);

            Stage stage = (Stage) btnAcusar.getScene().getWindow();
            stage.setScene(new Scene(root, 960, 540));
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void mostrarBlocoDeNotas() {
        painelCentral.getChildren().clear();

        javafx.scene.layout.VBox container = new javafx.scene.layout.VBox(0);
        container.setMaxWidth(620);

        // Área de anotações existentes
        javafx.scene.layout.StackPane areaNotas = new javafx.scene.layout.StackPane();
        areaNotas.setMinHeight(220);
        areaNotas.setStyle("-fx-background-color: #2A2020; -fx-background-radius: 4 4 0 0;");

        String texto = blocoDeNotas.getAnotacao();
        Label lblNotas = new Label(texto.isEmpty() ? "" : texto);
        lblNotas.setWrapText(true);
        lblNotas.setMaxWidth(580);
        lblNotas.setStyle(
                "-fx-font-family: 'Courier New'; -fx-font-size: 12px; " +
                        "-fx-text-fill: #C8B8B8; -fx-padding: 20;"
        );
        areaNotas.getChildren().add(lblNotas);

        // Barra inferior: campo de nova nota + botão
        javafx.scene.layout.BorderPane barraAdicionar = new javafx.scene.layout.BorderPane();
        barraAdicionar.setStyle(
                "-fx-background-color: #1E1818; -fx-padding: 14 20 14 20; " +
                        "-fx-background-radius: 0 0 4 4;"
        );

        javafx.scene.control.TextField campoNota = new javafx.scene.control.TextField();
        campoNota.setPromptText("ADICIONAR");
        campoNota.setStyle(
                "-fx-font-family: 'Courier New'; -fx-font-size: 12px; " +
                        "-fx-text-fill: #C8B8B8; -fx-background-color: transparent; " +
                        "-fx-border-color: transparent; -fx-prompt-text-fill: #888888;"
        );
        javafx.scene.layout.BorderPane.setAlignment(campoNota, javafx.geometry.Pos.CENTER_LEFT);

        Button btnAdicionar = new Button("+");
        btnAdicionar.setStyle(
                "-fx-background-color: transparent; -fx-text-fill: #CC8888; " +
                        "-fx-font-size: 20px; -fx-cursor: hand;"
        );
        btnAdicionar.setOnAction(e -> {
            String novaNota = campoNota.getText().trim();
            if (!novaNota.isEmpty()) {
                blocoDeNotas.setAnotacao(novaNota);
                campoNota.clear();
                mostrarBlocoDeNotas(); // atualiza a tela
            }
        });

        barraAdicionar.setLeft(campoNota);
        barraAdicionar.setRight(btnAdicionar);
        javafx.scene.layout.BorderPane.setAlignment(btnAdicionar, javafx.geometry.Pos.CENTER);

        container.getChildren().addAll(areaNotas, barraAdicionar);
        painelCentral.getChildren().add(container);
    }

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

            Button btnReiniciar = new Button("↺  Ver novamente");
            btnReiniciar.setStyle(
                    "-fx-font-family: 'Courier New'; " +
                            "-fx-font-size: 13px; " +
                            "-fx-font-weight: BOLD; " +
                            "-fx-text-fill: #5A3A3A; " +
                            "-fx-background-color: #E8C8C8; " +
                            "-fx-border-color: #C8A0A0; " +
                            "-fx-border-width: 1px; " +
                            "-fx-padding: 10 40 10 40; " +
                            "-fx-cursor: hand; " +
                            "-fx-background-radius: 2px;"
            );
            btnReiniciar.setOnAction(e -> {
                evidenciaController.reiniciar();
                mostrarEvidencias();
            });

            VBox box = new VBox(14, vazio, btnReiniciar);
            box.setAlignment(javafx.geometry.Pos.CENTER_LEFT);
            painelCentral.getChildren().add(box);
            return;
        }

        painelCentral.getChildren().add(criarCardEvidencia());
    }

    private void mostrarInterrogatorio() {
        painelCentral.getChildren().clear();

        if (interrogatorioController.terminou()) {
            Label fim = new Label("Interrogatório encerrado.");
            fim.setStyle("-fx-font-family: 'Courier New'; -fx-font-size: 12px; -fx-text-fill: #888888;");

            Button btnReiniciar = new Button("↺  Ver novamente");
            btnReiniciar.setStyle(
                    "-fx-font-family: 'Courier New'; " +
                            "-fx-font-size: 13px; " +
                            "-fx-font-weight: BOLD; " +
                            "-fx-text-fill: #5A3A3A; " +
                            "-fx-background-color: #E8C8C8; " +
                            "-fx-border-color: #C8A0A0; " +
                            "-fx-border-width: 1px; " +
                            "-fx-padding: 10 40 10 40; " +
                            "-fx-cursor: hand; " +
                            "-fx-background-radius: 2px;"
            );
            btnReiniciar.setOnAction(e -> {
                interrogatorioController.reiniciar();
                mostrarInterrogatorio();
            });

            VBox box = new VBox(14, fim, btnReiniciar);
            box.setAlignment(javafx.geometry.Pos.CENTER_LEFT);
            painelCentral.getChildren().add(box);
            return;
        }

        VBox container = new VBox(20);
        container.setAlignment(javafx.geometry.Pos.TOP_CENTER);
        container.setMaxWidth(680);
        container.getChildren().add(criarCardSuspeito());
        container.getChildren().add(criarCardPergunta());
        painelCentral.getChildren().add(container);
    }

    private void mostrarLinhaTempo() {
        painelCentral.getChildren().clear();

        javafx.scene.layout.VBox lista = new javafx.scene.layout.VBox(0);
        lista.setMaxWidth(620);
        lista.setStyle("-fx-background-color: #2A2020; -fx-background-radius: 4;");

        List<Ocorrencia> ocorrencias = linhaDoTempo.paraLista();

        if (ocorrencias.isEmpty()) {
            Label vazio = new Label("Nenhum evento registrado.");
            vazio.setStyle("-fx-font-family: 'Courier New'; -fx-font-size: 12px; -fx-text-fill: #888888; -fx-padding: 20;");
            lista.getChildren().add(vazio);
        } else {
            for (int i = 0; i < ocorrencias.size(); i++) {
                model.entidades.Ocorrencia oc = ocorrencias.get(i);

                javafx.scene.layout.VBox item = new javafx.scene.layout.VBox(4);
                item.setStyle("-fx-padding: 14 20 14 20;");

                Label hora = new Label(oc.getHora());
                hora.setStyle("-fx-font-family: 'Courier New'; -fx-font-size: 11px; -fx-text-fill: #888888;");

                Label desc = new Label(oc.getDescricao());
                desc.setWrapText(true);
                desc.setMaxWidth(580);
                desc.setStyle("-fx-font-family: 'Courier New'; -fx-font-size: 12px; -fx-text-fill: #C8B8B8;");

                item.getChildren().addAll(hora, desc);
                lista.getChildren().add(item);

                // separador entre itens (exceto o último)
                if (i < ocorrencias.size() - 1) {
                    javafx.scene.control.Separator sep = new javafx.scene.control.Separator();
                    sep.setStyle("-fx-background-color: #3A3A3A;");
                    lista.getChildren().add(sep);
                }
            }
        }

        javafx.scene.control.ScrollPane scroll = new javafx.scene.control.ScrollPane(lista);
        scroll.setFitToWidth(true);
        scroll.setStyle("-fx-background-color: transparent; -fx-background: transparent; -fx-border-color: transparent;");
        scroll.setMaxWidth(620);
        scroll.setMaxHeight(400);

        painelCentral.getChildren().add(scroll);
    }

    private void mostrarHistorico() {
        painelCentral.getChildren().clear();

        javafx.scene.layout.VBox lista = new javafx.scene.layout.VBox(0);
        lista.setMaxWidth(620);
        lista.setStyle("-fx-background-color: #2A2020; -fx-background-radius: 4;");

        // Percorre a pilha pelo nó interno
        // Como PilhaAcoes não tem paraLista(), acessa via exibirHistorico() adaptado
        java.util.List<String> acoes = new java.util.ArrayList<>();
        model.ferramentas.NoAcao atual = casoController.getHistorico().getTopo();
        while (atual != null) {
            acoes.add(atual.acao);
            atual = atual.proximo;
        }

        if (acoes.isEmpty()) {
            Label vazio = new Label("Nenhuma ação registrada.");
            vazio.setStyle("-fx-font-family: 'Courier New'; -fx-font-size: 12px; -fx-text-fill: #888888; -fx-padding: 20;");
            lista.getChildren().add(vazio);
        } else {
            for (int i = 0; i < acoes.size(); i++) {
                Label acao = new Label(acoes.get(i));
                acao.setWrapText(true);
                acao.setMaxWidth(580);
                acao.setStyle("-fx-font-family: 'Courier New'; -fx-font-size: 12px; -fx-text-fill: #C8B8B8; -fx-padding: 14 20 14 20;");
                lista.getChildren().add(acao);

                if (i < acoes.size() - 1) {
                    javafx.scene.control.Separator sep = new javafx.scene.control.Separator();
                    sep.setStyle("-fx-background-color: #3A3A3A;");
                    lista.getChildren().add(sep);
                }
            }
        }

        javafx.scene.control.ScrollPane scroll = new javafx.scene.control.ScrollPane(lista);
        scroll.setFitToWidth(true);
        scroll.setStyle("-fx-background-color: transparent; -fx-background: transparent; -fx-border-color: transparent;");
        scroll.setMaxWidth(620);
        scroll.setMaxHeight(400);

        painelCentral.getChildren().add(scroll);
    }

    private javafx.scene.layout.HBox criarCardEvidencia() {
        javafx.scene.layout.HBox hbox = new javafx.scene.layout.HBox(16);
        hbox.setStyle("-fx-background-color: #2A2020; -fx-padding: 20; -fx-background-radius: 4;");
        hbox.setMaxWidth(580);
        hbox.setMaxHeight(250);

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

        // Foto
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


    private void setMenuAtivo(Label item) {
        if (menuAtivo != null) menuAtivo.setStyle(ESTILO_MENU);
        menuAtivo = item;
        item.setStyle(ESTILO_MENU_ATIVO);
    }


}