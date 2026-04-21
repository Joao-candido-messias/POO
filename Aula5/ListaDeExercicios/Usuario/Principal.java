package Aula4.ListaDeExercicios.Usuario;

public class Principal {
    public static void main(String[] args) {
        Usuario u = new Usuario();

        u.setNome("Joao");
        u.setSenha("12345678");

        System.out.println(u.getSenha());

        u.setSenha("123");
        System.out.println(u.getSenha());
    }
}
