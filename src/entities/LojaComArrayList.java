package entities;

import java.util.ArrayList;

public class LojaComArrayList {

    ArrayList<Produto> estoque = new ArrayList<>();
    private int quantidadeItens;

    public LojaComArrayList() {
        this.estoque = new ArrayList<>();
        this.quantidadeItens = 0;
    }

    public void printList() {
        for (int i = 0; i < estoque.size(); i++) {
            System.out.println("Dados do produto ["+(i+1)+"]: ");
            System.out.println(estoque.get(i).toString());
        }
    }

    public void adicionarItem(Produto item) {
        estoque.add(item);
    }

    public void removeItem(int indice) {
        if (indice >= 0 && indice < estoque.size()) {
            estoque.remove(indice);
        } else {
            System.out.println("Indice Inválido");
        }
    }

    public int qntCelCarregador() {
        int quantidadeCarregador = 0;
        for (Produto carregadorLocalizacao : estoque) {
            if (carregadorLocalizacao instanceof Celular) {
                Celular procurandoCarregador = (Celular) carregadorLocalizacao;
                if (procurandoCarregador.isComCarregador() == true) {
                    quantidadeCarregador++;
                }
            }
        }
        return quantidadeCarregador;
    }

    public double computadorBarato() {
        double computadorBarato = Double.MAX_VALUE;
        for (Produto computadorBaratoLoc : estoque) {
            if (computadorBaratoLoc instanceof Computador) {
                Computador computador = (Computador) computadorBaratoLoc;
                if (computador.getPreco() < computadorBarato) {
                    computadorBarato = computador.getPreco();
                }
            }
        }
        return computadorBarato;
    }

}
