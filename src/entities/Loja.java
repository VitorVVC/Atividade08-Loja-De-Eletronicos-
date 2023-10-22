package entities;

public class Loja {
    private Produto[] produtos;
    private int quantidadeProtudosMaximo;

    public Loja(int quantidadeMaxima) {
        this.produtos = new Produto[quantidadeMaxima];
        this.quantidadeProtudosMaximo = 0;
    }

    // Printar quantos elementos existem na loja e quantos são celular ou computador
    public void elementosNaLoja() {
        int elementosLoja = 0;
        int celulares = 0;
        int computadores = 0;
        for (Produto printElementos : produtos) {
            if (printElementos != null) {
                elementosLoja++;
            }
            if (printElementos instanceof Celular) {
                celulares++;
            }
            if (printElementos instanceof Computador) {
                computadores++;
            }
        }
        System.out.println("Quantidade de produtos na loja: " + elementosLoja);
        System.out.printf("Entre eles {%d} são Celulares e os outros {%d} são computadores%n", celulares, computadores);
    }
    // Adicionando produto ao vetor de produtos
    public void adicionarProduto(Produto produto) {
        if (quantidadeProtudosMaximo < produtos.length) {
            produtos[quantidadeProtudosMaximo] = produto;
            quantidadeProtudosMaximo++;
        } else {
            System.out.println("Capacidade máxima atingida");
        }
    }
    // Removendo produto do vetor de produtos
    public void retirarProduto(int indice) {
        if (indice < produtos.length && indice >= 0) {
            for (int i = indice; i < produtos.length - 1; i++) {
                produtos[i] = produtos[i + 1];
            }
            produtos[produtos.length - 1] = null;
            quantidadeProtudosMaximo--;
        } else {
            System.out.println("Indice inválido");
        }
    }
    // Dados de cada index de produtos
    public void dadosProdutos() {
        for (int i = 0; i < produtos.length; i++) {
            System.out.print("Dados do produto [" + (i + 1) + "]: ");
            System.out.println(produtos[i].toString());
        }
    }

    // Retorna qual computador mais barato ( toString ) neste computador
    // Tratar com try exception
    public Computador computadorBarato(Produto[] produtos) {
        Computador pc = null;
        double computadorBarato = Double.MAX_VALUE;
        for (int i = 0; i < produtos.length; i++) {
            if (produtos[i] instanceof Computador) {
                if (produtos[i].getPreco() < computadorBarato) {
                    computadorBarato = produtos[i].getPreco();
                    pc = (Computador) produtos[i];
                }
            }
        }
        return pc;
    }

    // Tratar com try exception
    // Retorna qual computador mais caro ( toString ) neste computador
    public Computador computadorCaro(Produto[] produtos) {
        Computador pc = null;
        double computadorCaro = Double.MIN_VALUE;
        for (int i = 0; i < produtos.length; i++) {
            if (produtos[i] instanceof Computador) {
                if (produtos[i].getPreco() > computadorCaro) {
                    computadorCaro = produtos[i].getPreco();
                    pc = (Computador) produtos[i];
                }
            }
        }
        return pc;
    }

    // Rertorna qual o celular com menor tempo de garantia ( toString ) neste celular
    public Celular menorCelGarantia(Produto[] produtos) {
        Celular cel = null;
        int menorCelGarantia = Integer.MAX_VALUE;
        for (int i = 0; i < produtos.length; i++) {
            if (produtos[i] instanceof Celular) {
                if (produtos[i].getGarantia() < menorCelGarantia) {
                    menorCelGarantia = produtos[i].getGarantia();
                    cel = (Celular) produtos[i];
                }
            }
        }
        return cel;
    }

    // Retorna o valor medio dos produtos da loja
    public double mediaProdutos(Produto[] produtos) {
        double somaPrecos = 0;
        // Criar está variavel foi a unica solucão que encontrei para poder percorrer
        // Sobre o array apenas elementos inicializados
        int produtosNaoZerados = 0;
        for (int i = 0; i < produtos.length; i++) {
            if (produtos[i] != null) {
                somaPrecos += produtos[i].getPreco();
                produtosNaoZerados++;
            }
        }
        if (produtosNaoZerados !=0) {
            return somaPrecos / produtosNaoZerados;
        } else {
            throw new IllegalArgumentException("Não há produtos na loja ou todos os precos estão zerados");
        }
    }

    // Retorna um inteiro de quantos celulares possuem carregadores inclusos
    public int qntCelCarregador(Produto[] produtos) {
        int quantidadeCarregador = 0;
        for (int i = 0; i < produtos.length; i++) {
            if (produtos[i] instanceof Celular) {
                if (((Celular) produtos[i]).isComCarregador()) {
                    quantidadeCarregador++;
                }
            }
        }
        return quantidadeCarregador;
    }

    // Retornar um inteiro de quantos computadores possuem impressoras inclusas
    public int qntPcImpressora(Produto[] produtos) {
        int qntImpressora = 0;
        for (int i = 0; i < produtos.length; i++) {
            if (produtos[i] instanceof Computador) {
                if (((Computador) produtos[i]).isComImpressora()) {
                    qntImpressora++;
                }
            }
        }
        return qntImpressora;
    }

    // Get no valor maximo de produtos
    public int getQuantidadeProtudosMaximos() {
        return quantidadeProtudosMaximo;
    }

    // Enquanto neste caso *AINDA* não criei uma forma de adicionar mais produtos a quantidade
    // máxima
    public void setQuantidadeProtudos(int quantidadeProtudos) {
        this.quantidadeProtudosMaximo = quantidadeProtudos;
    }

    // Get no vetor de produtos
    public Produto[] getProdutos() {
        return produtos;
    }
    // Não se faz necessário ter um set para o vetor de produtos considerando que já possue
    // Métodos para adicionar e remover produtos de sua lista
}
