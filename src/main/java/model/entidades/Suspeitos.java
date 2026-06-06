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
    public record Relacionamento(Suspeitos s1, Suspeitos s2, String relacao) {}
}