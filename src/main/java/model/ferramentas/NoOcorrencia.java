package model.ferramentas;
import model.entidades.Ocorrencia;

public class NoOcorrencia {
    public Ocorrencia ocorrencia;
    public NoOcorrencia proxima;
    public NoOcorrencia anterior;

    public NoOcorrencia(Ocorrencia ocorrencia){
        this.ocorrencia = ocorrencia;
        this.proxima = null;
        this.anterior = null;
    }
}