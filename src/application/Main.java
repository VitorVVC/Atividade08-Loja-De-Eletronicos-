package application;

import entities.*;

import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        // Exemplo com valores predefinidos sem usar arrayList
        /*
        Loja minhaLoja = new Loja(10);

        minhaLoja.adicionarProduto(new Computador("Computador A", 10000, 6, true));
        minhaLoja.adicionarProduto(new Computador("Computador B", 6000, 12, false));
        minhaLoja.adicionarProduto(new Celular("Celular A", 10000, 12, false));
        minhaLoja.adicionarProduto(new Celular("Celular A", 5000, 3, true));

        minhaLoja.elementosNaLoja();
        minhaLoja.retirarProduto(2);
        minhaLoja.elementosNaLoja();
        System.out.println("Quantidade de celulares com carregador: " + minhaLoja.qntCelCarregador());
        System.out.println("Computador mais barato da loja: " + minhaLoja.computadorBarato());
         */

        // Exemplo com valores predefinidos usando ArrayList
        /*
        LojaComArrayList loja = new LojaComArrayList();
        ArrayList<LojaComArrayList> estoqueLoja = new ArrayList<>();

        loja.adicionarItem(new Computador("Computador X", 17000, 12, true));
        loja.adicionarItem(new Computador("Computador Y", 7000, 6, false));
        loja.adicionarItem(new Celular("Celular X", 7000, 6, false));
        loja.adicionarItem(new Celular("Celular Y", 10000, 12, true));

        loja.printList();
        loja.removeItem(2);
        System.out.println("Quantidade de celulares com carregador: " + loja.qntCelCarregador());
        System.out.println("Computador mais barato da loja: " + loja.computadorBarato());
         */
        // Exemplo interagindo com o usuario ( SEM ARRAYLIST ) :(
        Loja lojaUsuario = obterDados(sc);


    }

    private static Loja obterDados(Scanner sc) {
        System.out.print("Quantos itens sua loja pode comportar? ");
        int quantidade = sc.nextInt();
        sc.nextLine();

        Loja lojaUsuario = new Loja(quantidade);
        String decisao;
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

                // Static alguma coisa
                //int x = Util.teste();

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
                System.out.print("Voce deseja saber as informacoes do produto? Se deseja digite 'Sim' se não 'Não': ");
                String infoOuN = sc.next();
                sc.nextLine();
                if (infoOuN.toLowerCase().equals("sim")) {
                    System.out.println(compUser.toString());
                } else {
                    System.out.println("Ok, progama encerrado.");
                }
            }
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
                System.out.print("O seu computador vem com impressora? [ True para sim & False para não ]: ");
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
