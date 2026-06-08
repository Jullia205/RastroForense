package model.ferramentas;

import model.entidades.Evidencias;

public class FilaEvidencias {

    private NoEvidencia inicio;
    private NoEvidencia fim;
    private int tamanho;

    public FilaEvidencias() {
        inicio = null;
        fim = null;
        tamanho = 0;
    }

    public boolean estaVazia() {
        return inicio == null;
    }

    public int getTamanho() {
        return tamanho;
    }

    public void enfileirar(Evidencias evidencia) {

        NoEvidencia novo = new NoEvidencia(evidencia);

        if (estaVazia()) {
            inicio = novo;
            fim = novo;
        } else {
            fim.proximo = novo;
            fim = novo;
        }

        tamanho++;
    }

    public Evidencias desenfileirar() {

        if (estaVazia()) {
            return null;
        }

        Evidencias removida = inicio.evidencia;

        inicio = inicio.proximo;

        if (inicio == null) {
            fim = null;
        }

        tamanho--;

        return removida;
    }

    public Evidencias consultarPrimeira() {

        if (estaVazia()) {
            return null;
        }

        return inicio.evidencia;
    }

    public void listarFila() {

        NoEvidencia atual = inicio;

        while (atual != null) {
            System.out.println(atual.evidencia);
            atual = atual.proximo;
        }
    }
}