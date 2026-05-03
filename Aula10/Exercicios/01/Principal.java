import java.util.ArrayList;

public class Principal {
    public static void main(String[] args) {

        ArrayList<NaveEspacial> frota = new ArrayList<>();

        try {
            NaveCargueiro cargueiro = new NaveCargueiro(
                    "C-01", 1500, 200, 100, 300
            );

            NaveCombate combate = new NaveCombate(
                    "B-01", 1000, 500, 10, true
            );

            NaveExploracao exploracao = new NaveExploracao(
                    "E-01", 800, 300, true
            );

            frota.add(cargueiro);
            frota.add(combate);
            frota.add(exploracao);

            // TESTE ENCAPSULAMENTO
            try {
                cargueiro.setCapacidadeMaximaCarga(50);
            } catch (CargaIncompativelException e) {
                System.out.println("Encapsulamento OK: " + e.getMessage());
            }

            // TESTE POLIMORFISMO
            for (NaveEspacial nave : frota) {
                System.out.println("\nTipo: " + nave.getClass().getSimpleName());
                System.out.println("ID: " + nave.getIdentificador());

                try {
                    nave.viajar(1000);
                } catch (Exception e) {
                    System.out.println("Erro na viagem: " + e.getMessage());
                }
            }

        } catch (Exception e) {
            System.out.println("Erro geral: " + e.getMessage());
        }
    }
}