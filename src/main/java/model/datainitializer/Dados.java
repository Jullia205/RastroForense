package model.datainitializer;

import model.entidades.Evidencias;
import model.entidades.Suspeitos;
import model.ferramentas.FilaEvidencias;
import model.ferramentas.FilaInterrogatorio;
import model.ferramentas.PilhaAcoes;

public class Dados {

    Suspeitos hortencia = new Suspeitos(
            "Hortência Rodrigues Santana",
            37,
            "Contadora"
    );

    Suspeitos yanka = new Suspeitos(
            "Yanka Rodrigues Andrade",
            11,
            "Nenhuma"
    );

    Suspeitos mirabela = new Suspeitos(
            "Mirabela Andrade Sousa",
            30,
            "Médica"
    );

    Suspeitos mariana = new Suspeitos(
            "Mariana Barreto Marques",
            30,
            "Enfermeira"
    );

    Suspeitos marcos = new Suspeitos(
            "Marcos Nunes",
            55,
            "Mordomo"
    );


    Suspeitos.Relacionamento mariEParcos = new Suspeitos.Relacionamento(mariana, marcos, "pai e filha");
    Suspeitos.Relacionamento mirabelaECesar = new Suspeitos.Relacionamento(mirabela, hortencia, "irmãs");
    Suspeitos.Relacionamento yankaEHortencia = new Suspeitos.Relacionamento(yanka, hortencia, "mãe e filha");
    Suspeitos.Relacionamento yankaEMirabela = new Suspeitos.Relacionamento(yanka, mirabela, "tia e sobrinha");

    // EVIDÊNCIAS

    Evidencias vinhoBeladona = new Evidencias(
            "887-00-1",
            "Escritório de César",
            "Taça contendo resíduos de vinho. A perícia identificou vestígios de beladona misturados à bebida."
    );

    Evidencias cartasMirabela = new Evidencias(
            "887-00-2",
            "Gaveta do escritório",
            "Cartas trocadas entre César e Mirabela revelam um relacionamento amoroso extraconjugal. Trechos indicam que Mirabela pedia constantemente por dinheiro."
    );

    Evidencias documentosFinanceiros = new Evidencias(
            "887-00-3",
            "Cofre da residência",
            "Documentos bancários indicam graves dificuldades financeiras e risco de falência da família."
    );

    Evidencias bibliaYanka = new Evidencias(
            "887-00-4",
            "Quarto de Yanka",
            "Bíblia infantil contendo marcações frequentes em passagens sobre pecado, possessão e julgamento divino."
    );

    Evidencias materialOcultista = new Evidencias(
            "887-00-5",
            "Compartimento oculto atrás da estante do escritório",
            "Coleção de manuscritos, símbolos ritualísticos e anotações relacionadas a práticas satanistas mantidas em segredo pela vítima."
    );

    Evidencias remediosDormir = new Evidencias(
            "887-00-6",
            "Aposentos da enfermeira",
            "Frascos de medicamentos sedativos parcialmente utilizados. Vestígios da substância também foram encontrados no organismo da vítima."
    );

    Evidencias pedidoDemissao = new Evidencias(
            "887-00-7",
            "Quarto do mordomo",
            "Pedido de demissão assinado três dias antes da morte da vítima, alegando motivos éticos e pessoais."
    );

    Evidencias paginaQueimada = new Evidencias(
            "887-00-8",
            "Lareira do escritório",
            "Página parcialmente queimada contendo instruções para um ritual de purificação espiritual realizado na noite anterior ao óbito."
    );

    public PilhaAcoes criarHistorico() {

        PilhaAcoes pilha = new PilhaAcoes();

        pilha.registrarAcao(
                "Caso 3458887 iniciado"
        );

        return pilha;
    }

    public FilaEvidencias criarFilaEvidencias() {

        FilaEvidencias fila = new FilaEvidencias();

        fila.enfileirar(vinhoBeladona);
        fila.enfileirar(cartasMirabela);
        fila.enfileirar(documentosFinanceiros);
        fila.enfileirar(bibliaYanka);
        fila.enfileirar(materialOcultista);
        fila.enfileirar(remediosDormir);
        fila.enfileirar(pedidoDemissao);
        fila.enfileirar(paginaQueimada);

        return fila;
    }

    public FilaInterrogatorio criarFilaInterrogatorio() {

        FilaInterrogatorio fila = new FilaInterrogatorio();

        fila.enfileirar(hortencia);
        fila.enfileirar(yanka);
        fila.enfileirar(mirabela);
        fila.enfileirar(mariana);
        fila.enfileirar(marcos);

        return fila;
    }


}
