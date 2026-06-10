package model.ferramentas;

import lombok.Getter;
import model.datainitializer.Dados;
import model.entidades.Suspeitos;

import java.util.ArrayList;
import java.util.List;

@Getter
public class FilaInterrogatorio {

    private NoSuspeito inicio;
    private NoSuspeito fim;
    private int tamanho;
    private int perguntaAtual = 1;


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


    public String getPerguntaAtualS() {

        switch (perguntaAtual) {

            case 1:
                return "O que aconteceu na noite prévia ao crime?";

            case 2:
                return "Como era sua relação com César?";

            case 3:
                return "Você tem alguma ideia de quem poderia querer César morto?";

            case 4:
                return "Onde você estava entre 21:45h e meia-noite?";

            default:
                return "";
        }
    }

    public void avancarPergunta() {

        perguntaAtual++;

        if (perguntaAtual > 4) {

            perguntaAtual = 1;
            chamarProximo();
        }
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