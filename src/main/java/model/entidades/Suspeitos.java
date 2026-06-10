package model.entidades;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@ToString
public class Suspeitos {
    private String nome;
    private int idade;
    private String profissao;
    private String relacaoVitima;

    private String resposta1;
    private String resposta2;
    private String resposta3;
    private String resposta4;

    public record Relacionamento(Suspeitos s1, Suspeitos s2, String relacao) {}

    public String getResposta(int pergunta) {

        switch (pergunta) {

            case 1:
                return resposta1;

            case 2:
                return resposta2;

            case 3:
                return resposta3;

            case 4:
                return resposta4;

            default:
                return "";
        }
    }
}