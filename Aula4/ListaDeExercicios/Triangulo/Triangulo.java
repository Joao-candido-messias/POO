package Aula4.ListaDeExercicios.Triangulo;

public class Triangulo {
    private double a;
    private double b;
    private double c;

    private boolean valido(double a, double b, double c) {
        return (a + b > c) && (a + c > b) && (b + c > a);
    }

    public void setA(double a) {
        if (valido(a, this.b, this.c)) {
            this.a = a;
        }
    }

    public void setB(double b) {
        if (valido(this.a, b, this.c)) {
            this.b = b;
        }
    }

    public void setC(double c) {
        if (valido(this.a, this.b, c)) {
            this.c = c;
        }
    }

    public String getLados() {
        return a + ", " + b + ", " + c;
    }
}