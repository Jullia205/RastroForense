package model.ferramentas;

import model.entidades.Evidencias;

import java.util.ArrayList;
import java.util.List;

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

    public Evidencias chamarProximo() {

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

    public Evidencias verProximo() {
        return estaVazia() ? null : inicio.evidencia;
    }

    public Evidencias consultarPrimeira() {

        if (estaVazia()) {
            return null;
        }

        return inicio.evidencia;
    }

    public void limpar() {
        inicio = null;
        fim = null;
        tamanho = 0;
    }

    public List<Evidencias> paraLista() {
        List<Evidencias> lista = new ArrayList<>();
        NoEvidencia atual = inicio;
        while (atual != null) {
            lista.add(atual.evidencia);
            atual = atual.proximo;
        }
        return lista;
    }


}