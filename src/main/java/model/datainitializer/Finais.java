package model.datainitializer;

import model.entidades.Acusacao;

public class Finais {
    private static final String FINAL_VERDADEIRO =
            """
            A investigação identificou corretamente Yanka e Mariana como participantes da morte de César. A criança confessou que envenenou o vinho do pai, com a justificativa de “Estar purificando sua alma do Satanás”. Já a enfermeira teria batizado o chá da vítima com medicamentos para dormir.\n
            Mirabela também foi acusada como cúmplice de Mariana por ter permitido o uso de suas receitas médicas para comprar os soníferos usados no crime, apesar de alegar não saber das intenções da enfermeira.\n
            FINAL: A VERDADE REVELADA
            """;

    private static final String FINAL_ESPECIAL =
            """
            A investigação revelou que a morte de César foi resultado da ação conjunta de Yanka e Mariana.Yanka confessou ter colocado beladona no vinho do pai durante a reza.\nMariana, pouco tempo depois, administrou medicamentos sedativos à vítima durante a noite.\n
            A combinação das substâncias provocou uma intoxicação fatal. Durante o interrogatório final, Yanka afirmou que acreditava estar libertando o pai de uma influência demoníaca. Mariana alegou não ter conhecimento do envenenamento, mas sua participação foi fundamental para o desfecho do caso.\n
            FINAL: JUSTIÇA PERFEITA
            """;

    private static final String FINAL_PARCIAL_YANKA =
            """
            A investigação identificou corretamente Yanka como responsável pelo envenenamento.\n
            As evidências demonstram que foi ela quem entregou à vítima o vinho contaminado por beladona.\n
            Entretanto, a administração dos sedativos não foi considerada, deixando parte da verdade oculta.\n
            FINAL: VERDADE PARCIAL
            """;

    private static final String FINAL_PARCIAL_MARIANA =
            """
            A investigação identificou corretamente o envolvimento de Mariana nos acontecimentos que antecederam a morte da vítima.\n
            Os medicamentos administrados contribuíram para agravar o quadro clínico de César.\n
            No entanto, a origem do veneno não foi descoberta, impedindo a reconstrução completa dos fatos.\n
            FINAL: VERDADE PARCIAL
            """;

    private static final String FINAL_RUIM =
            """
            A acusação apresentada ignora a principal responsável pelo envenenamento.\n 
            Embora algumas das pessoas acusadas possuíssem motivos para desejar a morte de César, as evidências coletadas apontavam para outra direção.\n
            Sem identificar quem contaminou o vinho consumido pela vítima, a investigação fracassou.\n
            FINAL: CASO NÃO SOLUCIONADO
            """;

    public String avaliar(Acusacao acusacao) {

        boolean yanka = acusacao.contem("Yanka Rodrigues Andrade");

        boolean mariana = acusacao.contem("Mariana Barreto Marques");

        boolean mirabela = acusacao.contem("Mirabela Andrade Sousa");


        if (yanka && mariana && mirabela) {
            return FINAL_VERDADEIRO;
        }

        if (yanka && mariana) {
            return FINAL_ESPECIAL;
        }

        if (yanka) {
            return FINAL_PARCIAL_YANKA;
        }

        if (mariana) {
            return FINAL_PARCIAL_MARIANA;
        }

        return FINAL_RUIM;
    }

}
