package controller;

import model.datainitializer.Dados;
import model.entidades.Evidencias;
import model.entidades.Ocorrencia;
import model.entidades.Suspeitos;
import model.ferramentas.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// ESSA RODA O JOGO EM TERMINAL

public class MainTerminal {

    static Scanner scanner = new Scanner(System.in);
    static CasoController casoController;
    static EvidenciaController evidenciaController;
    static InterrogatorioController interrogatorioController;
    static FinalController finalController;

    public static void main(String[] args) {
        limpar();
        println("╔══════════════════════════════════════╗");
        println("║         R A S T R O  F O R E N S E  ║");
        println("╚══════════════════════════════════════╝");
        println("");
        println("  Um jogo de investigação criminal.");
        println("");
        pausar("  Pressione ENTER para começar...");

        casoController = new CasoController();
        casoController.abrirCaso();

        evidenciaController = new EvidenciaController(
                casoController.getFilaEvidencias(),
                casoController.getHistorico()
        );
        interrogatorioController = new InterrogatorioController(
                casoController.getFilaInterrogatorio(),
                casoController.getHistorico()
        );
        finalController = new FinalController(casoController.getHistorico());

        menuPrincipal();
    }

    // ─── MENUS ────────────────────────────────────────────────────────────────

    static void menuPrincipal() {
        while (true) {
            limpar();
            println("┌─────────────────────────────────────┐");
            println("│  CASO - " + casoController.getTituloCaso().replace("CASO - ", "") + "                          │");
            println("├─────────────────────────────────────┤");
            println("│  [1] Detalhes do caso               │");
            println("│  [2] Laudo pericial                 │");
            println("│  [3] Evidências                     │");
            println("│  [4] Interrogatório                 │");
            println("│  [5] Linha do tempo                 │");
            println("│  [6] Histórico                      │");
            println("│  [7] Bloco de notas                 │");
            println("│  [8] ACUSAR                         │");
            println("│  [0] Sair                           │");
            println("└─────────────────────────────────────┘");
            print("  Escolha: ");

            String op = scanner.nextLine().trim();
            switch (op) {
                case "1" -> telaDetalhes();
                case "2" -> telaLaudo();
                case "3" -> telaEvidencias();
                case "4" -> telaInterrogatorio();
                case "5" -> telaLinhaTempo();
                case "6" -> telaHistorico();
                case "7" -> telaBlocoDeNotas();
                case "8" -> telaAcusacao();
                case "0" -> { println("\n  Encerrando..."); return; }
                default  -> println("  Opção inválida.");
            }
        }
    }

    // ─── TELAS ────────────────────────────────────────────────────────────────

    static void telaDetalhes() {
        limpar();
        titulo("DETALHES DO CASO");
        println(casoController.getDetalhesCaso());
        pausar("\n  ENTER para voltar...");
    }

    static void telaLaudo() {
        limpar();
        titulo("LAUDO PERICIAL");
        println(casoController.getLaudo());
        pausar("\n  ENTER para voltar...");
    }

    static void telaEvidencias() {
        while (true) {
            limpar();
            titulo("EVIDÊNCIAS");

            if (!evidenciaController.possuiEvidencias()) {
                println("  Todas as evidências já foram analisadas.");
                println("");
                println("  [1] Ver novamente");
                println("  [0] Voltar");
                print("  Escolha: ");
                String op = scanner.nextLine().trim();
                if (op.equals("1")) {
                    evidenciaController.reiniciar();
                } else {
                    return;
                }
                continue;
            }

            Evidencias ev = evidenciaController.getEvidenciaAtual();
            println(ev != null ? ev.toString() : "");
            println("");
            println("  [1] Próxima evidência");
            println("  [0] Voltar");
            print("  Escolha: ");
            String op = scanner.nextLine().trim();
            if (op.equals("1")) {
                evidenciaController.proximaEvidencia();
            } else {
                return;
            }
        }
    }

    static void telaInterrogatorio() {
        while (true) {
            limpar();
            titulo("INTERROGATÓRIO");

            if (interrogatorioController.terminou()) {
                println("  Interrogatório encerrado.");
                println("");
                println("  [1] Ver novamente");
                println("  [0] Voltar");
                print("  Escolha: ");
                String op = scanner.nextLine().trim();
                if (op.equals("1")) {
                    interrogatorioController.reiniciar();
                } else {
                    return;
                }
                continue;
            }

            Suspeitos s = interrogatorioController.getSuspeitoAtual();
            println("  SUSPEITO: " + s.getNome());
            println("  Idade: " + s.getIdade() + " anos  |  " + s.getProfissao());
            println("  Relação com a vítima: " + s.getRelacaoVitima());
            separador();
            println("  PERGUNTA: " + interrogatorioController.getPerguntaAtual());
            println("");
            println("  RESPOSTA:");
            println("  " + interrogatorioController.getRespostaAtual());
            println("");
            println("  [1] Próxima pergunta");
            println("  [0] Voltar");
            print("  Escolha: ");
            String op = scanner.nextLine().trim();
            if (op.equals("1")) {
                interrogatorioController.avancar();
            } else {
                return;
            }
        }
    }

    static void telaLinhaTempo() {
        limpar();
        titulo("LINHA DO TEMPO");
        List<Ocorrencia> ocorrencias = casoController.getLinhaDoTempo().paraLista();
        if (ocorrencias.isEmpty()) {
            println("  Nenhum evento registrado.");
        } else {
            for (Ocorrencia oc : ocorrencias) {
                println("  [" + oc.getHora() + "]  " + oc.getDescricao().replace("\n", " "));
            }
        }
        pausar("\n  ENTER para voltar...");
    }

    static void telaHistorico() {
        limpar();
        titulo("HISTÓRICO");
        NoAcao atual = casoController.getHistorico().getTopo();
        if (atual == null) {
            println("  Nenhuma ação registrada.");
        } else {
            int i = 1;
            while (atual != null) {
                println("  " + i + ". " + atual.acao);
                atual = atual.proximo;
                i++;
            }
        }
        pausar("\n  ENTER para voltar...");
    }

    static void telaBlocoDeNotas() {
        while (true) {
            limpar();
            titulo("BLOCO DE NOTAS");
            String anotacao = casoController.getNotas().getAnotacao();
            if (anotacao == null || anotacao.isEmpty()) {
                println("  (sem anotações)");
            } else {
                println("  " + anotacao.replace("\n", "\n  "));
            }
            println("");
            println("  [1] Adicionar anotação");
            println("  [0] Voltar");
            print("  Escolha: ");
            String op = scanner.nextLine().trim();
            if (op.equals("1")) {
                print("  Nova anotação: ");
                String nota = scanner.nextLine().trim();
                if (!nota.isEmpty()) {
                    casoController.getNotas().setAnotacao(nota);
                }
            } else {
                return;
            }
        }
    }

    static void telaAcusacao() {
        limpar();
        titulo("ACUSAÇÃO");
        println("  Selecione até 3 suspeitos (digite os números separados por vírgula):");
        println("");

        List<Suspeitos> todos = casoController.getSuspeitosOriginais();
        for (int i = 0; i < todos.size(); i++) {
            Suspeitos s = todos.get(i);
            println("  [" + (i + 1) + "] " + s.getNome() + " — " + s.getRelacaoVitima());
        }

        println("");
        print("  Escolha (ex: 1,3): ");
        String entrada = scanner.nextLine().trim();

        List<Suspeitos> selecionados = new ArrayList<>();
        for (String parte : entrada.split(",")) {
            try {
                int idx = Integer.parseInt(parte.trim()) - 1;
                if (idx >= 0 && idx < todos.size() && selecionados.size() < 3) {
                    Suspeitos s = todos.get(idx);
                    if (!selecionados.contains(s)) selecionados.add(s);
                }
            } catch (NumberFormatException ignored) {}
        }

        if (selecionados.isEmpty()) {
            println("\n  Nenhum suspeito selecionado. Voltando...");
            pausar("");
            return;
        }

        Suspeitos s1 = selecionados.size() > 0 ? selecionados.get(0) : null;
        Suspeitos s2 = selecionados.size() > 1 ? selecionados.get(1) : null;
        Suspeitos s3 = selecionados.size() > 2 ? selecionados.get(2) : null;

        String resultado = finalController.finalizarInvestigacao(s1, s2, s3);

        limpar();
        titulo("RESULTADO DA INVESTIGAÇÃO");
        println(resultado);
        pausar("\n  ENTER para voltar...");
    }

    // ─── UTILITÁRIOS ──────────────────────────────────────────────────────────

    static void println(String s) { System.out.println(s); }
    static void print(String s)   { System.out.print(s); }

    static void titulo(String t) {
        println("  ═══ " + t + " ═══");
        println("");
    }

    static void separador() {
        println("  ─────────────────────────────────────");
    }

    static void pausar(String msg) {
        if (!msg.isEmpty()) print(msg);
        scanner.nextLine();
    }

    static void limpar() {
        // Funciona no terminal real; no IntelliJ aparece como linhas em branco
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
}