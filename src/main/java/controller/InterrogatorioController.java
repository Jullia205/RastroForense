package controller;

import model.entidades.Suspeitos;
import model.ferramentas.FilaInterrogatorio;
import model.ferramentas.PilhaAcoes;

import java.util.ArrayList;
import java.util.List;

public class InterrogatorioController {

    private final FilaInterrogatorio fila;
    private final PilhaAcoes historico;
    private final List<Suspeitos> todosSuspeitos;

    public InterrogatorioController(FilaInterrogatorio fila, PilhaAcoes historico) {
        this.fila = fila;
        this.historico = historico;
        this.todosSuspeitos = new ArrayList<>(fila.paraLista());
    }

    public Suspeitos getSuspeitoAtual() {
        return fila.verProximo();
    }

    public String getPerguntaAtual() {
        return fila.getPerguntaAtualS();
    }

    public String getRespostaAtual() {
        Suspeitos suspeito = fila.verProximo();
        if (suspeito == null) return "Interrogatório encerrado.";
        return suspeito.getResposta(fila.getPerguntaAtual());
    }

    public void avancar() {
        Suspeitos suspeitoAtual = fila.verProximo();
        if (suspeitoAtual != null) {
            historico.registrarAcao("Pergunta feita a " + suspeitoAtual.getNome());
        }
        fila.avancarPergunta();
    }

    public boolean terminou() {
        return fila.estaVazia();
    }

    public void reiniciar() {
        fila.limpar();
        fila.resetarPergunta();
        for (Suspeitos s : todosSuspeitos) {
            fila.enfileirar(s);
        }
    }
}