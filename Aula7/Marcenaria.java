package Aula7;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Marcenaria {

    public void instrucoes() throws IOException {

        String caminho = "./projeto_mesa.txt";

        try (BufferedReader br = new BufferedReader(new FileReader(caminho))) {

            System.out.println("Lendo arquivo de instruções...");

        } catch (FileNotFoundException e) {

            throw new IOException("Arquivo de projeto não encontrado");

        } catch (IOException e) {

            System.out.println(e.getMessage());

        }
    }

    public static void main(String[] args) {

        Marcenaria marcenaria = new Marcenaria();

        try {

            marcenaria.instrucoes();

        } catch (IOException e) {

            System.out.println("Erro: " + e.getMessage());

        } finally {

            System.out.println(
                "Limpando a bancada e desligando as máquinas..."
            );

        }
    }
}