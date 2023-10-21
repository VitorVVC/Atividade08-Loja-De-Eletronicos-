package application;

import entities.Celular;
import entities.Computador;
import entities.Loja;

import java.util.Scanner;

public class  Util  {
        // Enxergo muitas mudancas a serem implementadas ainda , como caso alguem escreva
        // algo errado poder voltar e reescrever.
        // E infinitas outras adicões hahah , acho que esta é a graca de progamar !
        // Sempre há oque mudarmos e melhorarmos. Porém para esta atividade acredito que
        // Está classe auxiliar seja mais que o necessário

    public static Loja obterDados(Scanner sc) {
        System.out.print("Quantos itens sua loja pode comportar em seu máximo? ");
        int quantidade = sc.nextInt();
        sc.nextLine();

        Loja lojaUsuario = new Loja(quantidade);
        String decisao;
        // Realizar uma acão:
        do {
            // Pedir ao usuario que digite qual produto que será adicionado
            System.out.print("Qual item voce deseja adicionar? Computador ou Celular? ");
            // Armazenar oque ele escreveu
            decisao = sc.next();
            sc.nextLine();
            // E caso sejá diferente de computador ou celular ele printa que voce so deve digitar
            // produtos que há em loja
            if (!decisao.toLowerCase().equals("computador") && !decisao.toLowerCase().equals("celular")) {
                System.out.println("Por favor digite apenas produtos que tenhamos na Loja! ");
                // Caso digite corretamente cai no else e encerra essa funcão
            } else {
                System.out.println("Obrigado! Agora vamos cadastrar as informacões do item");
            } // Ele enquanto oque for escrito for diferente de computador ou celular
            // Executará a linha de cod "do{ "
        } while (!decisao.toLowerCase().equals("computador") && !decisao.toLowerCase().equals("celular"));

        // Se a decisão for computador ele entrará na funcão especifica para está classe
        if (decisao.toLowerCase().equals("computador")) {
            // Loop percorrendo a quantidade de itens na loja
            for (int i = 0; i < quantidade; i++) {
                // Métodos para obter as informacões do computador
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
                // Armazenar a resposta em string para ter maior controle sobre o código
                strComImpressora = sc.next();
                sc.nextLine();
                // Enquanto a string sob a var booleana for diferente de true ou false
                while (!strComImpressora.toLowerCase().equals("true") && !strComImpressora.toLowerCase().equals("false")) {
                    // Ele printa pedindo novamente a variavel
                    System.out.print("Entrada invalida, Por favor digite true ou false: ");
                    strComImpressora = sc.next();
                    sc.nextLine();
                }
                // Após isso aplica a mudanca para o boolean temImpressora , referente a resposta
                if (strComImpressora.toLowerCase().equals("true")) {
                    temImpressora = true;
                } else if (strComImpressora.toLowerCase().equals("false")) {
                    temImpressora = false;
                } else {
                    throw new IllegalArgumentException("ERROR");
                }
                // Cria objeto compUser para adicionar a loja do usuario
                Computador compUser = new Computador(nome, preco, garantia, temImpressora);
                lojaUsuario.adicionarProduto(compUser);
                // Print para confirmar se tudo está ok
                System.out.print("Voce deseja saber as informacoes do produto? Se deseja digite 'Sim' se não 'Não': ");
                String infoOuN = sc.next();
                sc.nextLine();
                // Caso seja sim , ele printa o compUser
                if (infoOuN.toLowerCase().equals("sim")) {
                    System.out.println(compUser.toString());
                    // Se não encerra
                } else {
                    System.out.println("Ok, progama encerrado.");
                }
            }
            // Caso o progama seja para adicionar um celular :
        } else if (decisao.toLowerCase().equals("celular")) {
            for (int i = 0; i < quantidade; i++) {
                // Métodos para obter os dados do celular
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

                // Mesmo método para fazer o usuario digitar true false sem encerrar o progama
                // E atribuir sua resposta ao boolean tem carregador
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
                // Cria um celular e o adiciona aos produtos
                Celular celularUser = new Celular(nome, preco, garantia, temCarregador);
                lojaUsuario.adicionarProduto(celularUser);
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
