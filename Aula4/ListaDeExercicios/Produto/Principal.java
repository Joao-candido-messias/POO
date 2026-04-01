package Aula4.ListaDeExercicios.Produto;

public class Principal {
    public static void main(String[] args) {
        Produto p = new Produto();

        p.adicionarEstoque(10);
        p.removerEstoque(5);
        p.removerEstoque(10);

        System.out.println(p.getQuantidadeEmEstoque());
    }
}
