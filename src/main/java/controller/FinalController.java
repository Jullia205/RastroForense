package controller;

import model.datainitializer.Finais;
import model.entidades.Acusacao;
import model.entidades.Suspeitos;
import model.ferramentas.PilhaAcoes;

public class FinalController {
    private final Finais finais;
    private final PilhaAcoes historico;

    public FinalController(PilhaAcoes historico) {
        this.finais = new Finais();
        this.historico = historico;
    }

    public String finalizarInvestigacao(Suspeitos s1, Suspeitos s2, Suspeitos s3) {
        Acusacao acusacao = new Acusacao();


        return finais.avaliar(acusacao);
    }
}
