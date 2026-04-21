import java.util.Scanner;
    public class Estudante {
        Scanner scanner = new Scanner(System.in);
        private double nota;

        public void setNota() {
            System.out.println("Inira a nota do aluno: ");
            double nota = scanner.nextDouble();
            if (nota > 0 && nota < 10) {
                this.nota = nota;
            }else{
                System.out.println("Nota inválida!");
            }
        }
        //Getter de nota
        public double getNota() {
            return nota;
        }
    }