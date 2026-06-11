package controller;

import model.entidades.Evidencias;
import model.ferramentas.FilaEvidencias;
import model.ferramentas.PilhaAcoes;

public class EvidenciaController {

    private final FilaEvidencias fila;
    private final PilhaAcoes historico;

    public EvidenciaController(FilaEvidencias fila, PilhaAcoes historico) {
        this.fila = fila;
        this.historico = historico;
    }

    public Evidencias getEvidenciaAtual() {
        return fila.verProximo();
    }
    public Evidencias proximaEvidencia() {

        Evidencias atual = fila.chamarProximo();

        if (atual != null) {
            historico.registrarAcao(
                    "Evidência analisada: " +
                            atual.toString()
            );
        }
        return fila.verProximo();
    }

    public boolean possuiEvidencias() {
        return !fila.estaVazia();
    }


}