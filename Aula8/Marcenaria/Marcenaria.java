import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Marcenaria {

    public void instrucoes(String caminho) throws ProjetoInacessivelException {

        try (BufferedReader br = new BufferedReader(new FileReader(caminho))) {
            System.out.println("Lendo arquivo de instruções...");

        } catch (IOException e) {
            System.err.println("Erro de I/O registrado");
            throw new ProjetoInacessivelException("Não foi possível acessar o projeto", e);
        }
    }

    public void carregarMateriais(String primeiroMaterial, String segundoMaterial, String terceiroMaterial)
            throws ProjetoInacessivelException {

        try {
            System.out.println("Carregando: " + primeiroMaterial);
            instrucoes(primeiroMaterial);

            System.out.println("Carregando: " + segundoMaterial);
            instrucoes(segundoMaterial);

            System.out.println("Carregando: " + terceiroMaterial);
            instrucoes(terceiroMaterial);

            System.out.println("Todos os materiais foram carregados com sucesso!");

        } catch (ProjetoInacessivelException e) {
            System.out.println("Erro ao carregar materiais: " + e.getMessage());
            throw e;

        } finally {
            System.out.println("Fechando o galpão da marcenaria...");
        }
    }

    public static void main(String[] args) {
        String projeto = "./projeto_mesa.txt";
        Marcenaria marcenaria = new Marcenaria();

        try {
            marcenaria.instrucoes(projeto);

        } catch (ProjetoInacessivelException e) {
            System.out.println("Erro: " + e.getMessage());

        } finally {
            System.out.println("Limpando a bancada e desligando as máquinas...");
        }
    }
}