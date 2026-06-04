package gerenciadados.dados.nos;
import gerenciadados.dados.Ocorrencia;

public class NoOcorrencia {
    public Ocorrencia ocorrencia;
    public NoOcorrencia proxima;

    public NoOcorrencia(Ocorrencia ocorrencia){
        this.ocorrencia = ocorrencia;
        this.proxima = null;
    }
}
