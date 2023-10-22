package application;

import entities.Celular;
import entities.Computador;
import entities.Loja;

import java.util.Scanner;

public class Util {
    // Enxergo muitas mudancas a serem implementadas ainda , como caso alguem escreva
    // algo errado poder voltar e reescrever.
    // E infinitas outras adicões hahah , acho que esta é a graca de progamar !
    // Sempre há oque mudarmos e melhorarmos. Porém para esta atividade acredito que
    // Está classe auxiliar seja mais que o necessário

    public static Loja obterDados(Scanner sc) {
        // Recebe dados para formar o construtor da loja do usuario
        System.out.print("Quantos itens sua loja pode comportar em seu máximo? ");
        int quantidade = sc.nextInt();
        sc.nextLine();

        Loja lojaUsuario = new Loja(quantidade);
        String decisao;
        // Recebe qual produto o usuário deseja adicionar e trata com excessões e erros para
        // Limitar as acões de quem escreve
        do {
            System.out.print("Qual item voce deseja adicionar? Computador ou Celular? ");
            decisao = sc.next();
            sc.nextLine();
            if (!decisao.toLowerCase().equals("computador") && !decisao.toLowerCase().equals("celular")) {
                System.out.println("Por favor digite apenas produtos que tenhamos na Loja! ");
            } else {
                System.out.println("Obrigado! Agora vamos cadastrar as informacões do item");
            }
        } while (!decisao.toLowerCase().equals("computador") && !decisao.toLowerCase().equals("celular"));

        // Caso a resposta seja computador ele receberá dados para formar um construtor
        // para um computador e no fim adicionará a lista que possui uma quantidade máx
        if (decisao.toLowerCase().equals("computador")) {
            for (int i = 0; i < quantidade; i++) {
                System.out.printf("Tela de cadastro do item numero [%d]%n", (i + 1));
                System.out.print("Entre com o nome do modelo de seu aparelho: ");
                String nome = sc.nextLine();
                System.out.print("Entre com o preco: ");
                double preco = sc.nextDouble();
                sc.nextLine();
                System.out.print("Entre com o tempo de garantia em meses: ");
                int garantia = sc.nextInt();
                sc.nextLine();
                String strComImpressora;
                boolean temImpressora = false;
                System.out.print("O seu computador vem com impressora? [ True para sim & False para não ]: ");
                strComImpressora = sc.next();
                sc.nextLine();
                while (!strComImpressora.toLowerCase().equals("true") && !strComImpressora.toLowerCase().equals("false")) {
                    System.out.print("Entrada invalida, Por favor digite true ou false: ");
                    strComImpressora = sc.next();
                    sc.nextLine();
                }
                if (strComImpressora.toLowerCase().equals("true")) {
                    temImpressora = true;
                } else if (strComImpressora.toLowerCase().equals("false")) {
                    temImpressora = false;
                } else {
                    throw new IllegalArgumentException("ERROR");
                }
                Computador compUser = new Computador(nome, preco, garantia, temImpressora);
                lojaUsuario.adicionarProduto(compUser);
                // Método apenas para testes, para conferir se tudo que foi escrito está
                // devidamente salvo
                System.out.print("Voce deseja saber as informacoes do produto? Se deseja digite 'Sim' se não 'Não': ");
                String infoOuN = sc.next();
                sc.nextLine();
                if (infoOuN.toLowerCase().equals("sim")) {
                    System.out.println(compUser.toString());
                } else {
                    System.out.println("Ok, progama encerrado.");
                }
            }
            // Caso seja um celular recebe dados para formar um construtor de celular
            // para incrementar a loja do usuario
        } else if (decisao.toLowerCase().equals("celular")) {
            for (int i = 0; i < quantidade; i++) {
                System.out.printf("Tela de cadastro do item numero [%d]%n", (i + 1));
                System.out.print("Entre com o nome do modelo de seu aparelho: ");
                String nome = sc.nextLine();
                System.out.print("Entre com o preco: ");
                double preco = sc.nextDouble();
                sc.nextLine();
                System.out.print("Entre com o tempo de garantia em meses: ");
                int garantia = sc.nextInt();
                sc.nextLine();
                String strComCarregador;
                boolean temCarregador;
                System.out.print("O seu celular vem com carregador? [ True para sim & False para não ]: ");
                strComCarregador = sc.next();
                sc.nextLine();

                while (!strComCarregador.toLowerCase().equals("true") && !strComCarregador.toLowerCase().equals("false")) {
                    System.out.print("Entrada invalida, Por favor digite true ou false: ");
                    strComCarregador = sc.next();
                    sc.nextLine();
                }
                if (strComCarregador.toLowerCase().equals("true")) {
                    temCarregador = true;
                } else if (strComCarregador.toLowerCase().equals("false")) {
                    temCarregador = false;
                } else {
                    throw new IllegalArgumentException("ERROR");
                }
                Celular celularUser = new Celular(nome, preco, garantia, temCarregador);
                lojaUsuario.adicionarProduto(celularUser);
                // Método teste para conferir e bater oque foi digitado com oque foi salvo a memoria
                System.out.print("Voce deseja saber as informacoes do produto? Se deseja digite 'Sim' se não 'Não': ");
                String infoOuN = sc.next();
                sc.nextLine();
                if (infoOuN.toLowerCase().equals("sim")) {
                    System.out.println(celularUser.toString());
                } else {
                    System.out.println("Ok, progama encerrado.");
                }
            }
        }
        return lojaUsuario;
    }

}
