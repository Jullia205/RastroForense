package model.ferramentas;

import model.entidades.Ocorrencia;

import java.util.ArrayList;
import java.util.List;

public class LinhaDoTempo {

    private NoOcorrencia inicio;
    private NoOcorrencia fim;
    private NoOcorrencia cursor;

    public void inserirNoFim(Ocorrencia ocorrencia) {
        NoOcorrencia novo = new NoOcorrencia(ocorrencia);

        if (inicio == null) {
            inicio = novo;
            fim = novo;
            cursor = novo;
        } else {
            fim.proxima = novo;
            novo.anterior = fim;
            fim = novo;
        }
    }

    public Ocorrencia ocorrenciaAtual() {
        return cursor != null ? cursor.ocorrencia : null;
    }

    public List<Ocorrencia> paraLista() {
        List<Ocorrencia> lista = new ArrayList<>();
        NoOcorrencia atual = inicio;
        while (atual != null) {
            lista.add(atual.ocorrencia);
            atual = atual.proxima;
        }
        return lista;
    }

    public void listar(){
        NoOcorrencia atual = inicio;
        while(atual!=null){
            System.out.println("--------------------------");
            System.out.println("Descrição: "+atual.ocorrencia.getDescricao());
            System.out.println("Hora: "+atual.ocorrencia.getHora());
            atual = atual.proxima;
        }
    }


}