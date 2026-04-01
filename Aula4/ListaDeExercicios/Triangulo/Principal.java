package Aula4.ListaDeExercicios.Triangulo;

public class Principal {
    public static void main(String[] args) {
        Triangulo t = new Triangulo();

        t.setA(3);
        t.setB(4);
        t.setC(5);

        System.out.println(t.getLados());

        t.setC(10);
        System.out.println(t.getLados());
    }
}
