package model.ferramentas;

import model.entidades.Suspeitos;

import java.util.ArrayList;
import java.util.List;

public class FilaInterrogatorio {

    private NoSuspeito inicio;
    private NoSuspeito fim;
    private int tamanho;

    public void enfileirar(Suspeitos suspeito) {
        NoSuspeito novo = new NoSuspeito(suspeito);

        if (inicio == null) {
            inicio = novo;
            fim = novo;
        } else {
            fim.proximo = novo;
            fim = novo;
        }

        tamanho++;
    }

    public Suspeitos chamarProximo() {
        if (estaVazia()) {
            return null;
        }

        Suspeitos suspeito = inicio.suspeito;
        inicio = inicio.proximo;

        if (inicio == null) {
            fim = null;
        }

        tamanho--;
        return suspeito;
    }

    public Suspeitos verProximo() {
        return estaVazia() ? null : inicio.suspeito;
    }

    public boolean estaVazia() {
        return inicio == null;
    }

    public int tamanho() {
        return tamanho;
    }

    public List<Suspeitos> paraLista() {
        List<Suspeitos> lista = new ArrayList<>();
        NoSuspeito atual = inicio;
        while (atual != null) {
            lista.add(atual.suspeito);
            atual = atual.proximo;
        }
        return lista;
    }
}