package Aula4.ListaDeExercicios.Usuario;

public class Usuario {
    private String nome;
    private String senha;

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setSenha(String senha) {
        if (senha != null && senha.length() >= 8) {
            this.senha = senha;
        }else {
            System.out.println("Senha inválida. Deve conter pelo menos 8 caracteres.");
        }
    }

    public String getSenha() {
        if (senha == null) return null;
        return "********";
    }
}