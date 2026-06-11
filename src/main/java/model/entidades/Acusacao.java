package model.entidades;

public class Acusacao {

    private Suspeitos suspeito1;
    private Suspeitos suspeito2;
    private Suspeitos suspeito3;

    public void adicionarSuspeito(Suspeitos suspeito) {

        if (suspeito1 == null) {
            suspeito1 = suspeito;
        }
        else if (suspeito2 == null) {
            suspeito2 = suspeito;
        }
        else if (suspeito3 == null) {
            suspeito3 = suspeito;
        }
    }

    public boolean contem(String nome) {

        if (suspeito1 != null &&
                suspeito1.getNome().equals(nome))
            return true;

        if (suspeito2 != null &&
                suspeito2.getNome().equals(nome))
            return true;

        if (suspeito3 != null &&
                suspeito3.getNome().equals(nome))
            return true;

        return false;
    }
}
