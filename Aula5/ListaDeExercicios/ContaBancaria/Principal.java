public class Principal {
    public static void main(String[] args) {

        // Criando uma conta de teste
        ContaBancaria conta = new ContaBancaria(1000.0, 500.0);

        // Chamando o método sacar
        String resultado = conta.sacar();

        // Exibindo o resultado
        System.out.println(resultado);
    }
}