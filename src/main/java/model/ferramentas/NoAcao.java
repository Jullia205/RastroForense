package model.ferramentas;

public class NoAcao {

    public String acao;
    public NoAcao proximo;

    public NoAcao(String acao) {
        this.acao = acao;
        this.proximo = null;
    }
}