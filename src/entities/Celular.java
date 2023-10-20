package entities;

public class Celular extends Produto {
    private boolean comCarregador;

    public Celular(String name, double preco, int garantia, boolean comCarregador) {
        super(name, preco, garantia);
        this.comCarregador = comCarregador;
    }

    @Override
    public double calculaDesconto(int valor) {
        if (valor != 1 || valor != 2) {
            throw new IllegalArgumentException("O pagamento só pode ser 1 ou 2");
        }
        double desconto = 0;
        if (valor == 1 && comCarregador == true) {
            desconto = preco * 0.12;
        } else if (valor == 1 && comCarregador == false) {
            desconto = preco * 0.07;
        } else if (valor == 2 && comCarregador == true) {
            desconto = preco * 0.10;
        } else {
            System.out.println("Não existe desconto sobre o preco original");
        }
        return desconto;
    }
    public boolean isComCarregador() {
        return comCarregador;
    }

    public void setComCarregador(boolean comCarregador) {
        this.comCarregador = comCarregador;
    }

    @Override
    public String toString(){
        return String.format("Celular: [%s] ,Preco: [%.3f] ,Tempo de garantia: [%d] ,Tem carregador: [%s] %n",name,preco,garantia,comCarregador);
    }
}
