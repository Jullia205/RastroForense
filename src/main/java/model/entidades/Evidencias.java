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

    @Override
    public String toString() {
        return "Protocolo 000067-01012003\n" +
                "------------------------\n" +
                "ID: " + IDCASO +
                "\nDATA: " + DATA +
                "\nENDEREÇO: " + ENDERECO +
                "\n------------------------" +
                "\nID-COLETA: " + idColeta +
                "\n------------------------" +
                "\nDESCRIÇÃO: " + descricao +
                "\nLOCAL DE COLETA: " + localDeColeta
                ;
    }
}
