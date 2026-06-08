package model.ferramentas;

import model.entidades.Evidencias;

public class NoEvidencia {
    public Evidencias evidencia;
    public NoEvidencia proximo;

    public NoEvidencia(Evidencias evidencia) {
        this.evidencia = evidencia;
        this.proximo = null;
    }
}
