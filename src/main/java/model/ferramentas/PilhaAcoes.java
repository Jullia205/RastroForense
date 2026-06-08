package model.ferramentas;

public class PilhaAcoes {

    private NoAcao topo;
    private int tamanho;

    public PilhaAcoes() {
        topo = null;
        tamanho = 0;
    }

    public boolean estaVazia() {
        return topo == null;
    }

    public int getTamanho() {
        return tamanho;
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
            atual = atual.proximo;
        }
    }
}