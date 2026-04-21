public class Produto {
    private int quantidadeEmEstoque;

    public void adicionarEstoque(int qtd) {
        if (qtd > 0) {
            quantidadeEmEstoque += qtd;
        }
    }

    public void removerEstoque(int qtd) {
        if (qtd > 0 && quantidadeEmEstoque - qtd >= 0) {
            quantidadeEmEstoque -= qtd;
            System.out.println("Removidos " + qtd + " itens do estoque.");
        } else {
            System.out.println("Quantidade inválida para remoção.");
        }
    }

    public int getQuantidadeEmEstoque() {
        return quantidadeEmEstoque;
    }
}
