package entities;

public  abstract class Produto {

    protected String name;
    protected double preco;
    protected int garantia;

    public Produto(String name, double preco, int garantia) {
        this.name = name;
        this.preco =  validarDouble(preco);
        this.garantia = validarInt(garantia);
    }

    public abstract double calculaDesconto(int valor);

    public int validarInt(int valor){
        if(valor < 0){
            throw new IllegalArgumentException("Não aceitamos numeros negativos nessa entrada");
        }
        return valor;
    }
    public double validarDouble(double valor){
        if(valor < 0){
            throw new IllegalArgumentException("Não aceitamos numeros negativos nessa entrada");
        }
        return valor;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public int getGarantia() {
        return garantia;
    }

    public void setGarantia(int garantia) {
        this.garantia = garantia;
    }
}
