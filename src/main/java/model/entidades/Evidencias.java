package model.entidades;

public class Evidencias { //julia

    private final int IDCASO = 3458887;
    private final String DATA = "01/01/2003";
    private final String ENDERECO = "Rua Felicia, nº 789";
    private String idColeta;
    private String localDeColeta;
    private String descricao;

    public Evidencias(String idColeta, String localDeColeta, String descricao) {
        this.idColeta = idColeta;
        this.localDeColeta = localDeColeta;
        this.descricao = descricao;
    }

    public int getIDCASO() {
        return IDCASO;
    }

    public String getDATA() {
        return DATA;
    }

    public String getENDERECO() {
        return ENDERECO;
    }

    public String getIdColeta() {
        return idColeta;
    }

    public String getLocalDeColeta() {
        return localDeColeta;
    }

    public String getDescricao() {
        return descricao;
    }
}
