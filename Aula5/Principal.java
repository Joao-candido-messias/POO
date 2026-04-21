import java.util.Scanner;

public class Principal{
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        // Entrada de dados
        System.out.print("Digite o nome do aluno: ");
        String nome = scanner.nextLine();

        System.out.print("Digite a primeira nota: ");
        Double nota1 = scanner.nextDouble();

        System.out.print("Digite a segunda nota: ");
        Double nota2 = scanner.nextDouble();

        // Criando objeto
        Aluno aluno = new Aluno(nome, nota1, nota2);

        // Exibindo resultado
        System.out.println(aluno.calcularMedia());

        scanner.close();
          
        }
}
    
