import model.entidades.Ocorrencia;
import model.entidades.Suspeitos;
import model.ferramentas.FilaInterrogatorio;
import model.ferramentas.LinhaDoTempo;

public class Main {

    public static void main(String[] args) {

        // ---------- 1) Criando alguns suspeitos do caso ----------
        // (graças ao @AllArgsConstructor do Lombok, dá pra montar o objeto direto, sem setters um a um)
        Suspeitos hortencia = new Suspeitos("Hortência Rodrigues Santana", 37, "Contadora");
        Suspeitos mirabela  = new Suspeitos("Mirabela Andrade Sousa", 30, "Médica");
        Suspeitos mariana   = new Suspeitos("Mariana Barreto Marques", 30, "Enfermeira");
        Suspeitos marcos    = new Suspeitos("Marcos Nunes", 55, "Mordomo");

        // ---------- 1.1) Testando o record Relacionamento (a "tupla" pessoa1 - pessoa2 - descrição) ----------
        // Como é um record, ele já vem com toString() pronto, então dá pra imprimir direto sem escrever nada a mais.
        Suspeitos.Relacionamento mariEParcos = new Suspeitos.Relacionamento(mariana, marcos, "pai e filha");
        Suspeitos.Relacionamento mirabelaECesar = new Suspeitos.Relacionamento(mirabela, hortencia, "irmãs");

        System.out.println("===== RELACIONAMENTOS ENTRE SUSPEITOS =====");
        System.out.println(mariEParcos.s1().getNome() + " e " + mariEParcos.s2().getNome()
                + " -> " + mariEParcos.relacao());
        System.out.println(mirabelaECesar.s1().getNome() + " e " + mirabelaECesar.s2().getNome()
                + " -> " + mirabelaECesar.relacao());
        // o toString() automático do record também já sai pronto, caso queira só logar/depurar:
        System.out.println("toString() automático do record -> " + mariEParcos);

        // ---------- 2) Montando a linha do tempo do caso ----------
        LinhaDoTempo linhaDoTempo = new LinhaDoTempo();

        Ocorrencia jantar = new Ocorrencia("Família reunida para o jantar de fim de ano", "20:00", hortencia);
        Ocorrencia escandalo = new Ocorrencia("Hortência descobre a traição e faz escândalo", "20:20", hortencia);
        Ocorrencia cha = new Ocorrencia("Marcos entrega o chá medicinal a César", "22:35", marcos);
        Ocorrencia corpoEncontrado = new Ocorrencia("Empregada encontra César sem vida", "05:00", mariana);

        linhaDoTempo.inserirNoFim(jantar);
        linhaDoTempo.inserirNoFim(escandalo);
        linhaDoTempo.inserirNoFim(cha);
        linhaDoTempo.inserirNoFim(corpoEncontrado);

        System.out.println("===== LINHA DO TEMPO (ordem de registro) =====");
        linhaDoTempo.listar();

        // testando inserirApos: o investigador descobre um novo fato e encaixa entre dois eventos já existentes
        Ocorrencia conversaEscritorio = new Ocorrencia("César chama Hortência para conversar no escritório", "21:00", marcos);
        linhaDoTempo.inserirApos(escandalo, conversaEscritorio);

        System.out.println("\n===== LINHA DO TEMPO (após inserir evento no meio) =====");
        linhaDoTempo.listar();

        // testando a navegação do cursor (avançar / voltar)
        System.out.println("\n===== TESTANDO O CURSOR =====");
        System.out.println("Atual: " + linhaDoTempo.ocorrenciaAtual().getDescricao());
        System.out.println("Avançando -> " + linhaDoTempo.avancar().getDescricao());
        System.out.println("Avançando -> " + linhaDoTempo.avancar().getDescricao());
        System.out.println("Voltando  -> " + linhaDoTempo.voltar().getDescricao());

        // ---------- 3) Testando a fila de interrogatório ----------
        FilaInterrogatorio fila = new FilaInterrogatorio();
        fila.enfileirar(hortencia);
        fila.enfileirar(mirabela);
        fila.enfileirar(mariana);
        fila.enfileirar(marcos);

        System.out.println("\n===== FILA DE INTERROGATÓRIO =====");
        System.out.println("Tamanho da fila: " + fila.tamanho());
        System.out.println("Próximo a depor (sem remover): " + fila.verProximo().getNome());

        System.out.println("\nChamando suspeitos para depor, em ordem (FIFO):");
        while (!fila.estaVazia()) {
            Suspeitos chamado = fila.chamarProximo();
            System.out.println(" -> " + chamado.getNome() + " (" + chamado.getProfissao() + ") foi chamado para depor.");
        }

        System.out.println("Fila vazia? " + fila.estaVazia());
    }
}
