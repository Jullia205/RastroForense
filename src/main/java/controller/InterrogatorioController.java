package controller;

import model.entidades.Suspeitos;
import model.ferramentas.FilaInterrogatorio;
import model.ferramentas.PilhaAcoes;

public class InterrogatorioController {

    private final FilaInterrogatorio fila;
    private PilhaAcoes historico;

    public InterrogatorioController(FilaInterrogatorio fila, PilhaAcoes historico) {
        this.fila = fila;
        this.historico = historico;
    }

    public Suspeitos getSuspeitoAtual() {
        return fila.verProximo();
    }

    public String getPerguntaAtual() {
        return fila.getPerguntaAtualS();
    }

    public String getRespostaAtual() {

        Suspeitos suspeito = fila.verProximo();

        if (suspeito == null) {
            return "Interrogatório encerrado.";
        }

        return suspeito.getResposta(
                fila.getPerguntaAtual()
        );
    }

    public void avancar() {

        Suspeitos suspeitoAtual = fila.verProximo();

        if (suspeitoAtual != null) {

            historico.registrarAcao(
                    "Pergunta feita a "
                            + suspeitoAtual.getNome()
            );
        }

        fila.avancarPergunta();
    }

    public boolean terminou() {
        return fila.estaVazia();
    }
}