package model.ferramentas;

import lombok.Getter;

public class PilhaAcoes {

    @Getter
    private NoAcao topo;
    private int tamanho;

    public PilhaAcoes() {
        topo = null;
        tamanho = 0;
    }

    public boolean estaVazia() {
        return topo == null;
    }

    public void registrarAcao(String acao) {
        NoAcao novo = new NoAcao(acao);
        novo.proximo = topo;
        topo = novo;
        tamanho++;
    }

    public void exibirHistorico() {
        NoAcao atual = topo;
        while (atual != null) {
            System.out.println(atual.acao);
            System.out.println("-------------------------");
            atual = atual.proximo;
        }
    }
}