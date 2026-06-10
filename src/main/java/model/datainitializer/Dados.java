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
            "Contadora",
            "Esposa da vítima",
            "Todos jantamos por volta das 20:00. Enquanto comíamos, vi meu marido trocando olhares e carícias com minha irmã e não aguentei. Puxei meu marido pela camisa e discuti com ele em seu escritório. Decidi que não ficaria mais naquela casa e fui para um bar.",
            "Para o resto do mundo ele era um homem conservador exemplar. Em casa, era diferente. César gostava de controlar tudo e todos. Nosso casamento já estava desgastado há anos, mas eu ainda tentava manter a família unida.",
            "A maioria das pessoas gostava dele. Pelo menos era o que parecia. Mas ninguém conhece realmente um homem apenas pelos sermões que ele faz aos domingos. Quem sabe ele não irritou alguém?",
            "Eu já tinha saído da mansão. Passei algumas horas em um bar da cidade e só voltei pela manhã."
    );

    Suspeitos yanka = new Suspeitos(
            "Yanka Rodrigues Andrade",
            11,
            "Nenhuma",
            "Filha da vítima",
            "Mamãe e papai brigaram na janta e depois no escritório. Eu só terminei de jantar e fui para cima para dormir, já que a gente tinha que ir para o culto de manhã cedinho.",
            "Papai era um grande pastor. Muitas pessoas vinham pedir conselhos para ele. Eu queria ser igual a ele quando crescesse. Às vezes ele parecia cansado ou preocupado, mas sempre me dizia que Deus tinha um plano e que devemos nos manter fiéis a sua palavra.",
            "Não consigo imaginar alguém querendo machucar meu pai. Ele ajudava tanta gente. Talvez alguém tenha entendido alguma coisa errada. Sempre via papai atrás de Mariana.",
            "Eu estava no meu quarto lendo minha bíblia. O senhor Marcos até veio verificar se eu já tinha ido dormir."
    );

    Suspeitos mirabela = new Suspeitos(
            "Mirabela Andrade Sousa",
            30,
            "Médica",
            "Cunhada da vítima",
            "Minha irmã fez um bafafá por conta do idiota do marido dela e saiu umas 21:00, provavelmente para o cassino, como sempre. César parece não ter se importado muito e chamou todo mundo para a reza noturna. Logo depois eu fui me arrumar para dormir.",
            "César era muito carismático. As pessoas viam apenas o pastor respeitado, mas eu conheci um lado mais humano dele. Ele tinha defeitos, claro, mas também carregava muitos segredos. Recentemente ele estava mais estranho que o normal, passava mais tempo no escritório do que comigo.",
            "César tinha uma reputação impecável. Se alguém o odiava, certamente não demonstrava isso em público. Mas algumas pessoas dentro desta casa tinham motivos para guardar ressentimentos. Hortênsia pode ter enlouquecido na noite anterior, mas não faria algo assim.",
            "Eu estava nos meus aposentos. Minha perna estava machucada e eu pretendia descansar. Tenho insônia, então fiquei acordada por algum tempo lendo até o sonífero fazer efeito."
    );

    Suspeitos mariana = new Suspeitos(
            "Mariana Barreto Marques",
            30,
            "Enfermeira",
            "Enfermeira pessoal da cunhada da vítima",
            "Jantei com meu pai na sala de funcionários enquanto toda a comoção acontecia. Quase uma hora depois da reza, seu César disse estar se sentindo mal e pediu um chá de camomila. Fui dormir depois de fazer o chá, então não sei o que aconteceu.",
            "Eu trabalhava para a doutora Mirabela, então não tinha muita escolha além de conviver com ele. Fora de casa todos o admiravam. Dentro dela, bem, nem sempre ele tratava as pessoas da mesma forma respeitosa que tratava seus fiéis.",
            "Para quem o conhecia apenas da igreja, isso parecia impossível. Mas a polícia deveria investigar não apenas quem ele era diante da congregação, mas também quem ele era quando ninguém estava olhando.",
            "Estava na enfermaria organizando medicamentos quando César pediu um chá. Depois disso fui para o meu quarto."
    );

    Suspeitos marcos = new Suspeitos(
            "Marcos Marques Nunes",
            55,
            "Mordomo",
            "Mordomo da vítima",
            "O jantar da família pareceu estar meio tenso, mas fui orientado a não me envolver em brigas do patrão. Enquanto ele e a dona Hortênsia discutiam, fui organizar o quarto da pequena que ia dormir. Ela insistiu que não estava com sono e que ia ler, então me retirei. Logo depois peguei o chá e subi para o escritório.",
            "Nunca vi ninguém falar mal dele em público. Era respeitado por toda a comunidade. Mas uma casa grande guarda muitos problemas que quem está de fora nunca vê. Eu trabalhei muito tempo com ele.",
            "Eu servi esta família por muitos anos. Aprendi que existe uma grande diferença entre a imagem que uma pessoa constrói e a vida que ela realmente leva. Apesar de não ser o que aparenta, é inegável que ele ajudou muita gente.",
            "Entreguei o chá ao patrão e depois verifiquei se todas as portas estavam trancadas antes de me recolher. Todos já haviam ido deitar."
    );


    Suspeitos.Relacionamento mariEMarcos = new Suspeitos.Relacionamento(mariana, marcos, "pai e filha");
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
            "Gaveta do escritório de César",
            "Cartas trocadas entre César e Mirabela revelam um relacionamento amoroso extraconjugal. Trechos indicam que Mirabela pedia constantemente por dinheiro."
    );

    Evidencias documentosFinanceiros = new Evidencias(
            "887-00-3",
            "Cofre da residência",
            "Documentos bancários indicam graves dificuldades financeiras e risco de falência da família."
    );

    Evidencias biblia = new Evidencias(
            "887-00-4",
            "Escritório de César",
            "Bíblia rosa contendo marcações coloridas frequentes em passagens sobre pecado, possessão e purificação divina."
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
        fila.enfileirar(biblia);
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
