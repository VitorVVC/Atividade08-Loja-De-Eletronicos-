package entities;

public class Computador extends Produto {

    private boolean comImpressora;

    public Computador(String name, double preco, int garantia, boolean comImpressora) {
        super(name, preco, garantia);
        this.comImpressora = comImpressora;
    }

    @Override
    public double calculaDesconto(int valor) {
        double desconto = 0;
        if (valor != 1 || valor != 2) {
            throw new IllegalArgumentException("O pagamento só pode ser 1 ou 2");
        } else {
            if (valor == 1 && comImpressora == true) {
                desconto = preco * 0.10;
            } else if (valor == 1 && comImpressora == false) {
                desconto = preco * 0.05;
            } else if (valor == 2 && comImpressora == true) {
                desconto = preco * 0.07;
            } else {
                System.out.println("Não existe desconto sobre o preco original");
            }
        }
        return desconto;
    }

    public boolean isComImpressora() {
        return comImpressora;
    }

    public void setComImpressora(boolean comImpressora) {
        this.comImpressora = comImpressora;
    }
    @Override
    public String toString(){
        return String.format("Computador: [%s] ,Preco: [%.2f] ,Tempo de garantia: [%d] ,Possue Impressora: [%s] %n",name,preco,garantia,comImpressora);
    }
}
