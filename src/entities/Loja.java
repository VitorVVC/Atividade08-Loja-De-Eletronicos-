package entities;

public class Loja {
    private Produto[] produtos;
    private int quantidadeProtudos;

    public Loja(int quantidadeMaxima) {
        this.produtos = new Produto[quantidadeMaxima];
        this.quantidadeProtudos = 0;
    }

    public void elementosNaLoja() {
        int elementosLoja = 0;
        for (Produto printElementos : produtos) {
            if (printElementos != null) {
                elementosLoja++;
            }
        }
        System.out.println("Quantidade de produtos na loja: " + elementosLoja);
    }

    public void adicionarProduto(Produto produto) {
        if (quantidadeProtudos < produtos.length) {
            produtos[quantidadeProtudos] = produto;
            quantidadeProtudos++;
        } else {
            System.out.println("Capacidade máxima atingida");
        }
    }

    public void retirarProduto(int indice) {
        if (indice < produtos.length && indice >= 0) {
            for (int i = indice; i < produtos.length - 1; i++) {
                produtos[i] = produtos[i + 1];
            }
            produtos[produtos.length - 1] = null;
            quantidadeProtudos--;
        } else {
            System.out.println("Indice inválido");
        }
    }

    public int qntCelCarregador() {
        int quantidadeCarregador = 0;
        for (Produto carregador : produtos) {
            if (carregador instanceof Celular) {
                Celular procurandoCarregador = (Celular) carregador;
                if (procurandoCarregador.isComCarregador() == true) {
                    quantidadeCarregador++;
                }
            }
        }
        return quantidadeCarregador;
    }
    // Tratar com try exception
    public Computador computadorBarato(Produto[] produtos) {
        Computador pc = null;
        double computadorBarato = Double.MAX_VALUE;
        for (int i = 0; i < produtos.length; i ++) {
            if (produtos[i] instanceof Computador) {
                if (produtos[i].getPreco() < computadorBarato) {
                    computadorBarato = produtos[i].getPreco();
                    pc = (Computador) produtos[i];
                }
            }
        }
        return pc;
    }


    public int getQuantidadeProtudos() {
        return quantidadeProtudos;
    }

}
