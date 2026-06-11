package controller;

import lombok.Getter;
import model.datainitializer.Dados;
import model.entidades.Caso;
import model.entidades.Suspeitos;
import model.ferramentas.*;

import java.util.List;

public class CasoController {

    private final Dados dados;
    private Caso caso;
    @Getter
    private FilaEvidencias filaEvidencias;
    @Getter
    private FilaInterrogatorio filaInterrogatorio;
    @Getter
    private PilhaAcoes historico;
    @Getter
    private LinhaDoTempo linhaDoTempo;
    @Getter
    private BlocoDeNotas notas;
    @Getter
    private List<Suspeitos> suspeitosOriginais;
    private boolean casoAberto;

    public CasoController() {
        this.dados = new Dados();
        this.casoAberto = false;
    }

    public void abrirCaso() {
        this.caso = new Caso();
        this.filaEvidencias = dados.criarFilaEvidencias();
        this.filaInterrogatorio = dados.criarFilaInterrogatorio();
        this.linhaDoTempo = dados.criarLinhaDoTempo();
        this.historico = dados.criarHistorico();
        this.notas = new BlocoDeNotas("");
        this.casoAberto = true;
        this.suspeitosOriginais = this.filaInterrogatorio.paraLista(); // <-- adicionar
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
