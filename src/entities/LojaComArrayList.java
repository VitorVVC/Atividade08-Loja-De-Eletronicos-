package entities;

import java.util.ArrayList;

// Classe espelho de loja apenas para comparar e tentar melhorar meus conhecimentos sob
// arrayList baseado noque já sei sobre vetores
public class LojaComArrayList {

    // Aqui não precisamos declarar tamanho máximo pois arrayList é "infinito"
    // Só adicionare e remover
    ArrayList<Produto> estoque = new ArrayList<>();

    public LojaComArrayList() {
        this.estoque = new ArrayList<>();
    }

    // Printar quantos elementos tem na loja e quantos é de cada
    public void elementosLoja() {
        int quantidadeElementos = 0;
        int celulares = 0;
        int computadores = 0;
        for (int i = 0; i < estoque.size(); i++) {
            quantidadeElementos++;
            if (estoque.get(i) instanceof Celular) {
                celulares++;
            }
            if (estoque.get(i) instanceof Computador) {
                computadores++;
            }
        }
        System.out.println("Quantidade de elementos na loja: " + quantidadeElementos);
        System.out.printf("Entre eles existem {%d} celulares & {%d} computadores", celulares, computadores);
    }
    // Adicionar um item
    public void adicionarItem(Produto item) {
        estoque.add(item);
    }
    // Remover um item
    public void removeItem(int indice) {
        if (indice >= 0 && indice < estoque.size()) {
            estoque.remove(indice);
        } else {
            System.out.println("Indice Inválido");
        }
    }

    // Printar os dados do produto ( toString ) indice por indice
    public void dadosProdutos() {
        for (int i = 0; i < estoque.size(); i++) {
            System.out.print("Dados do produto [" + (i + 1) + "]: ");
            System.out.println(estoque.get(i).toString());
        }
    }

    // Percorre o estoque por inteiro e printa o toString do computador mais barato
    public Computador computadorBarato() {
        Computador pc = null;
        double computadorBarato = Double.MAX_VALUE;
        for (int i = 0; i < estoque.size(); i++) {
            if (estoque.get(i) instanceof Computador) {
                if (estoque.get(i).getPreco() < computadorBarato) {
                    computadorBarato = estoque.get(i).getPreco();
                    pc = (Computador) estoque.get(i);
                }
            }
        }
        return pc;
    }

    // Percorre o estoque por inteiro e printa o toString do computador mais caro
    public Computador computadorCaro() {
        Computador computador = null;
        double computadorCaro = Double.MIN_VALUE;
        for (int i = 0; i < estoque.size(); i++) {
            if (estoque.get(i) instanceof Computador) {
                if (estoque.get(i).getPreco() < computadorCaro) {
                    computadorCaro = estoque.get(i).getPreco();
                    computador = (Computador) estoque.get(i);
                }
            }
        }
        return computador;
    }

    // Percorre o estoque por inteiro e printa qual o celular com menor tempo de garantia
    public Celular menorCelGarantia() {
        Celular celular = null;
        int menorGarantia = Integer.MAX_VALUE;
        for (int i = 0; i < estoque.size(); i++) {
            if (estoque.get(i) instanceof Celular) {
                if (estoque.get(i).getGarantia() < menorGarantia) {
                    menorGarantia = estoque.get(i).garantia;
                    celular = (Celular) estoque.get(i);
                }
            }
        }
        return celular;
    }
    // Calcula a media de precos da loja
    public double mediaPreco() {
        double somaPreco = 0;
        int somaEstoque = 0;
        for (int i = 0; i < estoque.size(); i++) {
            somaPreco += estoque.get(i).getPreco();
            somaEstoque++;
        }
        if (somaEstoque != 0) {
            return somaPreco / somaEstoque;
        } else {
            throw new ArithmeticException("Não há estoque para fazer a sua média");
        }
    }

    // Quantidade de celulares que possuem carregadores ( retorna apenas a quantidade que possui )
    public int qntCelCarregador() {
        int quantidadeCarregador = 0;
        for (int i = 0; i < estoque.size(); i++) {
            if (estoque.get(i) != null && estoque.get(i) instanceof Celular) {
                if (((Celular) estoque.get(i)).isComCarregador()) {
                    quantidadeCarregador++;
                }
            }
        }
        return quantidadeCarregador;
    }

    // Quantidade de PC'S que possuem impressores ( Retorna apenas a quantidade que possui (int))
    public int qntPcImperssora() {
        int quantidadeImpressora = 0;
        for (int i = 0; i < estoque.size(); i++) {
            if (estoque.get(i) instanceof Computador) {
                if (((Computador) estoque.get(i)).isComImpressora()) {
                    quantidadeImpressora++;
                }
            }
        }
        return quantidadeImpressora;
    }

    // Não possui tanta utilidade porém caso eu necessite
    public ArrayList<Produto> getEstoque() {
        return estoque;
    }
    // Get para o TAMANHO ( quantidade já armazenada ) do estoque atual
    public int getTamanhoEstoque() {
        return estoque.size();
    }

}
