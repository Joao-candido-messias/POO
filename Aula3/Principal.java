package Aula3;

import java.util.ArrayList;

public class Principal {

    public static void main(String[] args) {
        
        ArrayList<Carro> listaDeCarros = new ArrayList<>();

        Carro.preencherArrayDeCarros(listaDeCarros, 2);

        for(Carro carro : listaDeCarros){
            System.out.println(carro);
        }

    }
}