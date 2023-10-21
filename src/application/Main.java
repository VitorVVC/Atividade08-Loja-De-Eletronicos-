package application;

import entities.*;

import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        // Exemplo com valores predefinidos sem usar arrayList

        Loja minhaLoja = new Loja(10);

        minhaLoja.adicionarProduto(new Computador("Computador A", 10000, 6, true));
        minhaLoja.adicionarProduto(new Computador("Computador B", 6000, 12, false));
        minhaLoja.adicionarProduto(new Celular("Celular A", 10000, 12, false));
        minhaLoja.adicionarProduto(new Celular("Celular A", 5000, 3, true));

        minhaLoja.elementosNaLoja();
        minhaLoja.retirarProduto(2);
        minhaLoja.elementosNaLoja();
        System.out.println("Quantidade de celulares com carregador: " + minhaLoja.qntCelCarregador(minhaLoja.getProdutos()));
        System.out.println("Quantidade de PC'S com impressora incluso: " + minhaLoja.qntPcImpressora(minhaLoja.getProdutos()));
        System.out.println("Computador mais barato da loja: " + minhaLoja.computadorBarato(minhaLoja.getProdutos()));
        System.out.println("Celular com menor tempo de garantia: " + minhaLoja.menorCelGarantia(minhaLoja.getProdutos()));
        System.out.printf("Média dos precos da loja: %.2f%n", minhaLoja.mediaProdutos(minhaLoja.getProdutos()));


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

        Loja lojaUsuario = Util.obterDados(sc);


    }


}
