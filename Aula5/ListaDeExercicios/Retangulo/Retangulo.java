package Aula4.ListaDeExercicios.Retangulo;

public class Retangulo {
    private double largura;
    private double altura;

    public void setLargura(double largura) {
        this.largura = largura;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }

    public double getArea() {
        return largura * altura;
    }
}
