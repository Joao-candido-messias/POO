package Aula7;
import java.util.Scanner;
public class Fomrulario {
    public static void main(String[]args){
        Scanner scanner = new Scanner(System.in);
        try{
            String idade;
            
            System.out.println("Insira a sua idade:");
            idade = scanner.nextLine();
            //System.out.println("Idade digitada: "+ Integer.parseInt(idade)); Apenas confirmava o sucesso da conversão.
        }catch(NumberFormatException e){
            System.out.println("Por favor, utilize apenas algarismos numéricos.");
        }
    }
}
