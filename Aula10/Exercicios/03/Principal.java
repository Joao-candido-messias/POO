import java.util.ArrayList;
import java.util.List;

public class Principal {
    public static void main(String[] args) {

        List<MaquinaIndustrial> maquinas = new ArrayList<>();

        MaquinaIndustrial injetora = new InjetoraPlastico("INJ-001");
        MaquinaIndustrial robo = new BracoRoboticoMontagem("ROB-001");
        MaquinaIndustrial prensa = new PrensaHidraulica("PRE-001");

        maquinas.add(injetora);
        maquinas.add(robo);
        maquinas.add(prensa);

        //Abastece a injetora
        ((InjetoraPlastico) injetora).abastecerPlastico(10);

        //Tenta produzir desligadas
        System.out.println("=== TESTE COM MÁQUINAS DESLIGADAS ===");
        for (MaquinaIndustrial m : maquinas) {
            try {
                m.produzirLote(60);
            } catch (MaquinaDesligadaException e) {
                System.out.println("ERRO: Máquina desligada.");
            } catch (Exception e) {
                System.out.println("Erro inesperado: " + e.getMessage());
            }
        }

        //Liga todas as maquinas
        System.out.println("\n=== LIGANDO MÁQUINAS ===");
        for (MaquinaIndustrial m : maquinas) {
            try {
                m.ligar();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }

        //Inicia turno de produção
        System.out.println("\n=== INÍCIO DO TURNO ===");
        for (int i = 1; i <= 3; i++) {
            System.out.println("\n--- LOTE " + i + " ---");

            for (MaquinaIndustrial m : maquinas) {
                try {
                    m.produzirLote(40);

                } catch (FaltaMateriaPrimaException e) {
                    System.out.println("ALARME INJETORA: Falta matéria prima!");

                } catch (EquipamentoDescalibradoException e) {
                    System.out.println("ALARME ROBÔ: Equipamento descalibrado!");

                } catch (SuperaquecimentoException e) {
                    System.out.println("ALARME PRENSA: Superaquecimento!");

                } catch (Exception e) {
                    System.out.println("Erro: " + e.getMessage());
                }
            }
        }

        //Relatório final
        System.out.println("\n=== RELATÓRIO FINAL ===");
        for (MaquinaIndustrial m : maquinas) {
            System.out.println("Máquina: " + m.getNumeroDeSerie());
            System.out.println("Peças produzidas: " + m.getPecasProduzidasTotais());
            System.out.println("Energia consumida: " + m.getEnergiaConsumidaKWh() + " kWh");
            System.out.println("-----------------------------");
        }
    }
}