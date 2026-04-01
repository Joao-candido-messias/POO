package Aula4.ListaDeExercicios.Estudante;

public class Principal{
    public static void main(String[] args) {
        Estudante e = new Estudante();

        e.setNota(8.5);
        System.out.println(e.getNota());

        e.setNota(11);
        System.out.println(e.getNota());
    }
}