package model.datainitializer;

import model.entidades.Evidencias;
import model.entidades.Ocorrencia;
import model.entidades.Suspeitos;
import model.ferramentas.FilaEvidencias;
import model.ferramentas.FilaInterrogatorio;
import model.ferramentas.LinhaDoTempo;
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
            "As pessoas viam apenas o pastor respeitado, mas eu conheci um lado mais humano dele. Ele tinha defeitos, claro, carregava muitos segredos. Recentemente ele estava mais estranho que o normal, passava muito tempo no escritório",
            "César tinha uma reputação impecável. Mas algumas pessoas dentro desta casa tinham motivos para guardar ressentimentos. Hortênsia pode ter enlouquecido na noite anterior, mas não faria algo assim.",
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
            "O jantar da família pareceu estar meio tenso. Enquanto ele e a dona Hortênsia discutiam, fui organizar o quarto da pequena que ia dormir. Ela insistiu que não estava com sono e que ia ler, então me retirei. Logo depois peguei o chá e subi para o escritório.",
            "Nunca vi ninguém falar mal dele em público. Era respeitado por toda a comunidade. Mas uma casa grande guarda muitos problemas que quem está de fora nunca vê. Eu trabalhei muito tempo com ele.",
            "Eu servi esta família por muitos anos. Aprendi que existe uma grande diferença entre a imagem que uma pessoa constrói e a vida que ela realmente leva. Apesar disso é inegável que ele ajudou muita gente.",
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
            "Taça contendo resíduos de vinho.\nA perícia identificou vestígios de beladona misturados à bebida."
    );

    Evidencias cartasMirabela = new Evidencias(
            "887-00-2",
            "Escritório de César",
            "Cartas trocadas entre César e Mirabela revelam um relacionamento amoroso extraconjugal.\nTrechos indicam que Mirabela pedia constantemente por dinheiro."
    );

    Evidencias documentosFinanceiros = new Evidencias(
            "887-00-3",
            "Cofre da residência",
            "Documentos bancários indicam graves dificuldades financeiras e risco de falência da família."
    );

    Evidencias biblia = new Evidencias(
            "887-00-4",
            "Escritório de César",
            "Bíblia rosa contendo marcações coloridas frequentes\nem passagens sobre pecado, possessão e purificação divina."
    );

    Evidencias materialOcultista = new Evidencias(
            "887-00-5",
            "Compartimento oculto atrás da estante do escritório",
            "Coleção de manuscritos, símbolos ritualísticos e anotações\nrelacionadas a práticas satanistas mantidas em segredo pela vítima."
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

    //Ocorrências

    Ocorrencia oc1 = new Ocorrencia(
            "20:00",
            "Família inteira reunida para jantar.\nTodos comem a mesma comida, exceto os funcionários."
    );

    Ocorrencia oc2 = new Ocorrencia(
            "20:20",
            "Durante o jantar, Hortênsia descobre o caso \nentre César e Mirabela e faz um escândalo na frente de todos."
    );

    Ocorrencia oc3 = new Ocorrencia(
            "21:00",
            "César e Hortênsia sobem para conversar em seu escritório.\nBarulhos e gritos são ouvidos pela casa."
    );

    Ocorrencia oc4 = new Ocorrencia(
            "21:00",
            "Após a discussão,\nHortênsia sai de casa sem informar para onde foi."
    );

    Ocorrencia oc5 = new Ocorrencia(
            "21:00",
            "Enquanto isso, Marcos sobe para conversar com Yanka no quarto da criança."
    );

    Ocorrencia oc6 = new Ocorrencia(
            "21:30",
            "Todos, exceto Yanka que estava em seu quarto,\nse reúnem para a sessão de leitura bíblica na sala do andar de baixo."
    );

    Ocorrencia oc7 = new Ocorrencia(
            "21:45",
            "César vai para o escritório."
    );

    Ocorrencia oc8 = new Ocorrencia(
            "22:30",
            "César pede um chá medicinal a Mariana, alegando estar se sentindo mal."
    );

    Ocorrencia oc9 = new Ocorrencia(
            "22:45",
            "Marcos chega ao escritório e entrega o chá a César."
    );

    Ocorrencia oc10 = new Ocorrencia(
            "22:45",
            "Marcos e César desejam boa noite um ao outro. Marcos fecha as portas do escritório."
    );

    Ocorrencia oc11 = new Ocorrencia(
            "22:45",
            "O restante da casa se prepara para dormir,\npois haverá um culto especial de ano novo pela manhã."
    );

    Ocorrencia oc12 = new Ocorrencia(
            "05:00",
            "Hortênsia retorna para casa visivelmente embriagada\ne começa a bater e gritar na porta do escritório."
    );

    Ocorrencia oc13 = new Ocorrencia(
            "05:00",
            "Os demais moradores ainda se encontram em seus quartos."
    );

    Ocorrencia oc14 = new Ocorrencia(
            "05:02",
            "Marcos abre o escritório e encontra César sem vida."
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
    public LinhaDoTempo criarLinhaDoTempo() {

        LinhaDoTempo linha = new LinhaDoTempo();

        linha.inserirNoFim(oc1);
        linha.inserirNoFim(oc2);
        linha.inserirNoFim(oc3);
        linha.inserirNoFim(oc4);
        linha.inserirNoFim(oc5);
        linha.inserirNoFim(oc6);
        linha.inserirNoFim(oc7);
        linha.inserirNoFim(oc8);
        linha.inserirNoFim(oc9);
        linha.inserirNoFim(oc10);
        linha.inserirNoFim(oc11);
        linha.inserirNoFim(oc12);
        linha.inserirNoFim(oc13);
        linha.inserirNoFim(oc14);

        return linha;
    }

}
