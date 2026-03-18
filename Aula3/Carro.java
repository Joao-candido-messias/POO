package Aula3;

import java.util.ArrayList;
import java.util.Scanner;

public class Carro{

    String marca;
    String modelo;
    int anoDeFabricacao;

    public Carro(String marca, String modelo, int anoDeFabricacao){
        this.marca = marca;
        this.modelo = modelo;
        this.anoDeFabricacao = anoDeFabricacao;
    }

    /*Função que preenche um ArrayList de Carros em função da quantidade de Carros que o usúario deseja cadastrar
    @param quantidade Quantidade de Carros que o usúario deseja cadastrar
    @param listaDeCarros ArrayList que armazena os carros inseridos
    */
    public static ArrayList<Carro> preencherArrayDeCarros(ArrayList<Carro> listaDeCarros, int quantidade){ 
    
        Scanner scanner = new Scanner(System.in);

        for(int i = 0; i < quantidade; i++){
            System.out.println("Insira a marca do carro:");
            String marca = scanner.nextLine();

            System.out.println("Insira o modelo do carro:");
            String modelo = scanner.nextLine();

            System.out.println("Insira o ano de fabricação:");
            int ano = scanner.nextInt();
            scanner.nextLine(); // limpar buffer

            Carro carro = new Carro(marca, modelo, ano);
            listaDeCarros.add(carro);

            System.out.println("Carro cadastrado com sucesso!\n");
        }

        scanner.close();
        return listaDeCarros;
    }

    @Override
    public String toString(){
        return "Carro: {Marca: "+ marca +" Modelo: "+ modelo +" Ano de Fabricacao: "+ anoDeFabricacao +"}";
    }

    @Override
    public boolean equals(Object obj){
        
        if(this == obj) return true;

        if(obj == null || getClass() != obj.getClass()) return false;

        Carro novoCarro = (Carro) obj;

        return this.marca.equals(novoCarro.marca) && 
               this.modelo.equals(novoCarro.modelo) && 
               this.anoDeFabricacao == novoCarro.anoDeFabricacao;
    }

   
}