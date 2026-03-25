package Aula4.ListaDeExercicios.ContaBancaria;

import java.util.Random;


public class ContaBancaria {
    
    public int numeroDaconta;
    private Double saldo;
    private Double limite;

    public ContaBancaria(int numeroDaconta, Double saldo, Double limite){
        this.numeroDaconta = numeroDaconta;
        this.saldo = saldo;
        this.limite = limite;
    }

    //Setter de numero da conta
    public void SetNumeroDaConta(){
        Random rand = new Random();
        this.numeroDaconta = rand.nextInt(9000) + 1000;
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
}
