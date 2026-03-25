package Aula4.ListaDeExercicios.ContaBancaria;

import java.util.Random;
import java.util.Scanner;


public class ContaBancaria {
    
    public int numeroDaconta;
    private Double saldo;
    private Double limite;

    public ContaBancaria(Double saldo, Double limite){
        Random rand = new Random();
        this.numeroDaconta = rand.nextInt(9000) + 1000;
        this.saldo = saldo;
        this.limite = limite;
    }


    //Getter de numero da conta
    public int GetNumeroDaConta(){
        return this.numeroDaconta;
    }

    //Setter de saldo
    public void SetSaldo(){
        this.saldo = saldo;
    }
    //Getter de saldo
    public Double GetSaldo(){
        return this.saldo;
    }

    //Setter de limite
    public void Setlimite(){
        if(limite < 0){
            System.out.println("O limite nao pode conter um valor negativo.");
        }
        else{
            this.limite = limite;
        }
    }
    //Getter de limite
    public Double Getlimite(){
        return this.limite;
    }

    public String sacar(){
        Scanner scanner = new Scanner(System.in);

        System.out.println("Quanto voce deseja sacar?");
        double valor = scanner.nextDouble(); 
        if(this.saldo < valor){
            return "Saldo insuficiente.";
        }
        else{
            this.saldo -= valor;
            return "Saque efetuado com sucesso! Saldo atual da conta: "+this.saldo+;
        }   
    }
}
