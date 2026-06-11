package controller;

import lombok.Getter;
import model.datainitializer.Dados;
import model.entidades.Caso;
import model.ferramentas.BlocoDeNotas;
import model.ferramentas.FilaEvidencias;
import model.ferramentas.FilaInterrogatorio;
import model.ferramentas.PilhaAcoes;

public class CasoController {

    private final Dados dados;
    private Caso caso;
    @Getter
    private FilaEvidencias filaEvidencias;
    @Getter
    private FilaInterrogatorio filaInterrogatorio;
    @Getter
    private PilhaAcoes historico;
    private BlocoDeNotas notas;
    private boolean casoAberto;

    public CasoController() {
        this.dados = new Dados();
        this.casoAberto = false;
    }

    public void abrirCaso() {
        this.caso = new Caso();
        this.filaEvidencias = dados.criarFilaEvidencias();
        this.filaInterrogatorio = dados.criarFilaInterrogatorio();
        this.historico = dados.criarHistorico();
        this.casoAberto = true;
    }

    public String getTituloCaso() {
        return "CASO - " + caso.getIDCASO();
    }

    public String getDetalhesCaso() {
        historico.registrarAcao("Detalhes do caso visualizados");
        return caso.toString();
    }

    public String getLaudo() {
        historico.registrarAcao("Laudo visualizado");
        return "LAUDO PERICIAL\n"
                + "-------------------------------\n"
                + "VÍTIMA: " + caso.getVITIMA() + "\n"
                + "GÊNERO: " + caso.getGENERO() + "\n"
                + "DATA: " + caso.getDATA() + "\n"
                + "CRIME: " + caso.getCRIME() + "\n"
                + "-------------------------------\n"
                + caso.getLAUDO();
    }


    public void reiniciarCaso() {
        abrirCaso();
        historico.registrarAcao("Caso reiniciado");
    }
}
