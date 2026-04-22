package Aula7;
import java.util.Scanner;

public class Calculadora{
    public static void main(String[]args){
        Scanner scanner = new Scanner(System.in);
        int n1, n2, resultado;

        try{

            System.out.println("Insira o primeiro numero:");
            n1 = scanner.nextInt();

            System.out.println("Insira o segundo numero:");
            n2 = scanner.nextInt();

            resultado = n1/n2;

            System.out.printf("Resultado: %d", resultado);

        }catch(ArithmeticException e){
            System.out.println("Erro matemático: impossível dividir por zero!");
        }

        scanner.close();
        }
}