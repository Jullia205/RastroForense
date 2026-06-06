package model.ferramentas;

public class LinhaDoTempo {
    NoOcorrencia inicio;

    public void listar(){
        NoOcorrencia atual = inicio;
        while(atual!=null){
            System.out.println("--------------------------");
            System.out.println("Descrição: "+atual.ocorrencia.descricao);
            System.out.println("Hora: "+atual.ocorrencia.hora);
            atual = atual.proxima;
        }

    }
}
