package Aula7;
import java.util.Scanner;

public class EscalaMusical {
    public static void main(String[]args){

        Scanner scanner = new Scanner(System.in);

        String[] escala = {"Do", "Re", "Mi", "Fa", "Sol", "La", "Si"};

        try{
            int posicao;
            System.out.println("Insira uma posicao (numero inteiro de 1 a 7) no vetor:");
            posicao = scanner.nextInt();

            System.out.println("A nota correspondente a essa posição é: " +escala[posicao - 1]);
        }catch(ArrayIndexOutOfBoundsException e){
            System.out.println("O valor digitado não esta dentro do intervalo da escala.");
        }
    } 
}
