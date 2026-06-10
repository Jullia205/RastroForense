package model.entidades;

public class Caso {

    int IDCASO = 3458887;
    private final String DATA = "01/01/2003";
    private final String CRIME = "Morte suspeita";

    private final String VITIMA = "César Andrade Silva";
    private final String GENERO = "Masculino";
    private final String ESTADO = "Casado";
    private final String ENDERECO = "Rua Felicia, nº 789";

    private final String DESCRICAO = "\nA vítima foi encontrada sem sinais vitais em seu escritório por volta das 05:00 da manhã. \nNão foram identificados sinais aparentes de luta corporal ou arrombamento no local.";
    private final String LAUDO =
            "\nO exame toxicológico detectou a presença de compostos derivados da planta Atropa belladonna (beladona) e medicamentos de efeito sedativo no organismo da vítima." +
            "\nA análise preliminar indica que a combinação das substâncias contribuiu para o agravamento do quadro clínico observado antes do óbito." +
            "\nRecomenda-se investigação complementar.";

    public int getIDCASO() {
        return IDCASO;
    }

    public String getDATA() {
        return DATA;
    }

    public String getCRIME() {
        return CRIME;
    }

    public String getVITIMA() {
        return VITIMA;
    }

    public String getGENERO() {
        return GENERO;
    }

    public String getESTADO() {
        return ESTADO;
    }

    public String getENDERECO() {
        return ENDERECO;
    }

    public String getDESCRICAO() {
        return DESCRICAO;
    }

    public String getLAUDO() {
        return LAUDO;
    }

    @Override
    public String toString() {
        return "Protocolo 000067-01012003\n" +
                "------------------------\n" +
                "ID: " + IDCASO +
                "\nDATA: " + DATA +
                "\nCRIME: " + CRIME +
                "\n------------------------" +
                "\nVITIMA: " + VITIMA +
                "\nGENERO: " + GENERO +
                "\nESTADO: " + ESTADO +
                "\nENDERECO: " + ENDERECO +
                "\n------------------------" +
                "\nDESCRICAO: " + DESCRICAO
                ;
    }

}





