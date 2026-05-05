import java.util.ArrayList;

public class Principal{
    public static void main(String[] args) {

        ArrayList<FuncionarioHospital> folhaPagamento = new ArrayList<>();

        try {
            Medico medico = new Medico(
                    "Dr. Silva",
                    "M001",
                    10000,
                    "Cirurgião",
                    5
            );

            Enfermeiro enfermeiro = new Enfermeiro(
                    "Ana Souza",
                    "E001",
                    5000,
                    "UTI",
                    0.40
            );

            Administrativo admin = new Administrativo(
                    "Carlos Lima",
                    "A001",
                    3000,
                    "RH",
                    true
            );

            folhaPagamento.add(medico);
            folhaPagamento.add(enfermeiro);
            folhaPagamento.add(admin);

            try {
                admin.setSalarioBase(900);
            } catch (ValorInvalidoException e) {
                System.out.println("Erro ao alterar salário do administrativo: " + e.getMessage());
            }

            try {
                enfermeiro.setPercentualInsalubridade(0.99);
            } catch (ValorInvalidoException e) {
                System.out.println("Erro ao alterar insalubridade: " + e.getMessage());
            }

            try {
                medico.setHorasTrabalhadasMensais(400);
            } catch (ValorInvalidoException e) {
                System.out.println("Erro ao alterar horas do médico: " + e.getMessage());
            }

            // TESTE DE POLIMORFISMO
            System.out.println("\n=== FOLHA DE PAGAMENTO ===");

            for (FuncionarioHospital f : folhaPagamento) {
                System.out.println("Funcionário: " + f.getNome());
                System.out.println("Salário final: R$ " + f.calcularSalario());
                System.out.println("------------------------");
            }

        } catch (Exception e) {
            System.out.println("Erro geral: " + e.getMessage());
        }
    }
}