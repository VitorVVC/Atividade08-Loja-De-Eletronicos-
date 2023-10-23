package application;

import entities.*;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("'Date: 'dd/MM/yyyy '& Hour: 'HH:mm");
        ZoneId zoneId = ZoneId.systemDefault();
        //ZoneId zoneId = ZoneId.of("America/New_York");
        LocalDateTime localDateTime = LocalDateTime.now(zoneId);
        System.out.println(formatter.format(localDateTime));

        // Exemplo com valores predefinidos sem usar arrayList

        Loja minhaLoja = new Loja(10);
        System.out.println("=====================================================");
        System.out.println("WITHOUT ARRAYLIST PRINTS: ");

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

        LojaComArrayList loja = new LojaComArrayList();
        System.out.println("=====================================================");
        System.out.println("ARRAY LIST PRINTS: ");
        loja.adicionarItem(new Computador("Computador X", 15000, 12, true));
        loja.adicionarItem(new Computador("Computador Y", 5000, 6, false));
        loja.adicionarItem(new Celular("Celular X", 7000, 6, false));
        loja.adicionarItem(new Celular("Celular Y", 10000, 12, true));

        loja.elementosLoja();
        loja.dadosProdutos();
        loja.removeItem(2);
        System.out.println("Quantidade de celulares com carregador: " + loja.qntCelCarregador());
        System.out.println("Quantidade de PC'S com impressora: " + loja.qntPcImperssora());
        System.out.println("Computador mais barato da loja: " + loja.computadorBarato());
        System.out.println("Celular com menor tempo de garantia: " + loja.menorCelGarantia());
        System.out.printf("Média dos precos da loja: %.2f%n", loja.mediaPreco());


        System.out.println("=====================================================");
        // Exemplo interagindo com o usuario ( SEM ARRAYLIST ) :(
        // System.out.println("GETTING DADS: ");
        // Loja lojaUsuario = Util.obterDados(sc);


    }


}
