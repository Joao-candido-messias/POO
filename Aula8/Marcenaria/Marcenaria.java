import java.io.IOException;

public class Marcenaria {
    public static void instrucoes() throws IOException{
        String caminho = "./projeto_mesa.txt";
        
        try (BufferedReader br = new BufferedReader(new FileReader(caminho))) {
            throw new Exception("Arquivo inexistente");
        }catch(IOException e){
            System.out.println(e.getMessage());
        }
    }

}