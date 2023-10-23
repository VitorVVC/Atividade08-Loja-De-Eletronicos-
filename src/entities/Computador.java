package entities;

public class Computador extends Produto {

    // Unico método extra de computador para um produto é se ele vem incluso com impressora
    private boolean comImpressora;

    // Construtor
    public Computador(String name, double preco, int garantia, boolean comImpressora) {
        super(name, preco, garantia);
        this.comImpressora = comImpressora;
    }

    // Método obrigatório de calcular o desconto e o retornar
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

    // Getters & Setters
    public boolean isComImpressora() {
        return comImpressora;
    }

    public void setComImpressora(boolean comImpressora) {
        this.comImpressora = comImpressora;
    }
    // Método toString para um print personalizado 
    @Override
    public String toString(){
        return String.format("\nComputador: [%s] ,Preco: [%.3f] ,Tempo de garantia: [%d] ,Possue Impressora: [%s] %n",name,preco,garantia,comImpressora);
    }
}
