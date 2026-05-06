public class BracoRoboticoMontagem extends MaquinaIndustrial{
    private double percentualCalibracao;

    public BracoRoboticoMontagem(String numeroDeserie) {
        super(numeroDeserie);
        this.percentualCalibracao = 100;
    }

    //Getter de percentualCalibracao
    public double getPercentualCalibracao(){
        return this.percentualCalibracao;
    }
    //Setter de percentualCalibracao
    public void setPercentualCalibracao(double percentualCalibracao) throws IllegalArgumentException{
        if(percentualCalibracao < 0 || percentualCalibracao > 100){
            throw new IllegalArgumentException("O percentual de calibracao deve ser entre 0 e 100");
        }
        this.percentualCalibracao = percentualCalibracao;
    }

    /**
     * Metodo que recalibra o braco robotico, setando o percentual de calibracao para 100. Caso o percentual de calibracao já seja 100, exibe uma mensagem informando que o braco robotico já está calibrado
     */
    protected void recalibrar(){
        if(this.getPercentualCalibracao() == 100){
            System.out.println("O braco robotico já está calibrado");
            return;
        }
        System.out.println("Recalibrando braco robotico...");
        this.percentualCalibracao = 100;
    }

    /**
     * Metodo que registra a producao de pecas em um braco robotico. Encrementando pecasProduzidasTotais e energiaConsumidaKWh. Caso o percentual de calibracao seja menor que 20, lança uma exceção do tipo EquipamentoDescalibradoException
     */
    @Override
    public void produzirLote(int quantidade) throws Exception {

        if (!getLigada()) {
            System.out.println("Máquina desligada.");
            return;
        }

        if (quantidade <= 0) {
            throw new IllegalArgumentException("Quantidade inválida.");
        }

        if (this.percentualCalibracao < 20) {
            throw new EquipamentoDescalibradoException("Braço robótico descalibrado.");
        }

        double energia = 15.0;

        registrarProducao(quantidade, energia);

        // reduz calibração
        this.percentualCalibracao -= quantidade * 0.5;

        // não deixa negativo
        this.percentualCalibracao = Math.max(0, this.percentualCalibracao);

        System.out.println("Lote produzido com sucesso.");
    }
}