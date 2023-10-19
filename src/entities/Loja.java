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
                produtos[i] = produtos[ i + 1 ];
            }
            produtos[produtos.length - 1] = null;
            quantidadeProtudos--;
        } else {
            System.out.println("Indice inválido");
        }
    }
    // Aqui poderia ser void ? Já que possui syso e no mesmo já retorna a quantidade
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
        //System.out.println("Quantidade de carregadores celulares que vem carregador incluso: " + quantidadeCarregador);
        return quantidadeCarregador;
    }
    // Aqui poderia ser void ? Já que possui o syso e no mesmo já retorna a posicão e o seu preco
    /*
    public double computadorBarato(Produto[] produtos) {
        double computadorBarato = DOUBLE.MAX_VALUE;
        int posicaoComputadorBarato = 0;

        for (int i = 0; i < produtos.length; i++) {
            if (produtos[i] instanceof Computador) {
                Computador procurandoPC = (Computador) produtos[i];
                if (procurandoPC.getPreco() < computadorBarato) {
                    computadorBarato = procurandoPC.getPreco();
                    posicaoComputadorBarato = i;
                }
            }
        }
        // System.out.printf("Computador mais barato custa: %.2fR$%n",computadorBarato);
        // System.out.println("E se encontra na posicão: "+posicaoComputadorBarato);
        return computadorBarato;
    }
     */
    public double computadorBarato() {
        double computadorBarato = Double.MAX_VALUE;
        for (Produto estoquePC : produtos) {
            if (estoquePC instanceof Computador) {
                Computador procurandoPC = (Computador) estoquePC;
                if (procurandoPC.getPreco() < computadorBarato) {
                    computadorBarato = procurandoPC.getPreco();
                }
            }
        }
        return computadorBarato;
    }

}
