public class InjetoraPlastico extends MaquinaIndustrial{
    private double kgMateriaPrima;

    public InjetoraPlastico(String numeroSerie) {
        super(numeroSerie);
        this.kgMateriaPrima = 0;
    }

    // Getter de materiaPrima
    public double getKgMateriaPrima() {
        return this.kgMateriaPrima;
    }

    /**
     * Metodo que abastece a injetora de plastico em função da quantidade de material
     */
    public void abastecerPlastico(double quantidade) {
        if (quantidade <= 0) {
            throw new IllegalArgumentException("Quantidade de plástico inválida.");
        }
        this.kgMateriaPrima += quantidade;
    }

    /**
     * Metodo que produz um lote de peças em uma Injetora de plastico
     * @param quantidade: Quantidade de peças a serem produzidas no lote
     * @throws FaltaMateriaPrimaException: Para quando a quantidade de materia prima é insuficiente 
     */
    @Override
    public void produzirLote(int quantidade) throws FaltaMateriaPrimaException {

        if (!getLigada()) {
            throw new IllegalStateException("Máquina desligada.");
        }

        double consumoPorPeca = 0.2;
        double energiaPorPeca = 0.5;

        double totalPlasticoNecessario = quantidade * consumoPorPeca;
        double totalEnergia = quantidade * energiaPorPeca;

        if (this.kgMateriaPrima < totalPlasticoNecessario) {
            throw new FaltaMateriaPrimaException("Plástico insuficiente para produzir o lote.");
        }

        // consome matéria-prima
        this.kgMateriaPrima -= totalPlasticoNecessario;

        // registra produção na superclasse
        registrarProducao(quantidade, totalEnergia);

        System.out.println("Produção concluída com sucesso: " + quantidade + " peças.");
        return;
    }
}