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

    public boolean inserirApos(Ocorrencia referencia, Ocorrencia nova) {
        NoOcorrencia alvo = buscarNo(referencia);
        if (alvo == null) {
            return false;
        }
        NoOcorrencia novoNo = new NoOcorrencia(nova);
        NoOcorrencia proximoAntigo = alvo.proxima;

        alvo.proxima = novoNo;
        novoNo.anterior = alvo;
        novoNo.proxima = proximoAntigo;

        if (proximoAntigo != null) {
            proximoAntigo.anterior = novoNo;
        } else {
            fim = novoNo;
        }

        return true;
    }

    public Ocorrencia avancar() {
        if (cursor != null && cursor.proxima != null) {
            cursor = cursor.proxima;
        }
        return ocorrenciaAtual();
    }

    public Ocorrencia voltar() {
        if (cursor != null && cursor.anterior != null) {
            cursor = cursor.anterior;
        }
        return ocorrenciaAtual();
    }

    public Ocorrencia ocorrenciaAtual() {
        return cursor != null ? cursor.ocorrencia : null;
    }

    private NoOcorrencia buscarNo(Ocorrencia ocorrencia) {
        NoOcorrencia atual = inicio;
        while (atual != null) {
            if (atual.ocorrencia == ocorrencia) {
                return atual;
            }
            atual = atual.proxima;
        }
        return null;
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
            System.out.println("Quem relatou: "+atual.ocorrencia.getQuemRelatou().getNome());
            atual = atual.proxima;
        }
    }


}