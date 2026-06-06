package model.ferramentas;

import model.entidades.Suspeitos;

public class NoSuspeito {
    public Suspeitos suspeito;
    public NoSuspeito proximo;

    public NoSuspeito(Suspeitos suspeito) {
        this.suspeito = suspeito;
        this.proximo = null;
    }
}
