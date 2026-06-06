package model.entidades;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@ToString
public class Ocorrencia {
     private String descricao;
     private String hora;
     private Suspeitos quemRelatou;
}