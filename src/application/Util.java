package application;

import entities.Celular;
import entities.Computador;
import entities.Loja;

import java.util.Scanner;

public class  Util  {
    // Futura forma de fazer uma classe auxiliar para a main
    // Transportando oque há de metodos statics da main para aqui
    // E assim a main so puxar e printar os métodos :D
    // Valeu professor por me dar essa ideia.

    public static Loja obterDados(Scanner sc) {
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
