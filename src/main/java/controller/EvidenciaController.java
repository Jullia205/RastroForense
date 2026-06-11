package controller;

import model.entidades.Evidencias;
import model.ferramentas.FilaEvidencias;
import model.ferramentas.PilhaAcoes;

import java.util.ArrayList;
import java.util.List;

public class EvidenciaController {

    private final FilaEvidencias fila;
    private final PilhaAcoes historico;
    private final List<Evidencias> todasEvidencias;

    public EvidenciaController(FilaEvidencias fila, PilhaAcoes historico) {
        this.fila = fila;
        this.historico = historico;
        this.todasEvidencias = new ArrayList<>(fila.paraLista());
    }

    public Evidencias getEvidenciaAtual() {
        return fila.verProximo();
    }

    public Evidencias proximaEvidencia() {
        Evidencias atual = fila.chamarProximo();
        if (atual != null) {
            historico.registrarAcao("Evidência analisada: " + atual.toString());
        }
        return fila.verProximo();
    }

    public boolean possuiEvidencias() {
        return !fila.estaVazia();
    }

    public void reiniciar() {
        fila.limpar();
        for (Evidencias e : todasEvidencias) {
            fila.enfileirar(e);
        }
    }
}