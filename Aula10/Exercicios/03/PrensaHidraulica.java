public class PrensaHidraulica extends MaquinaIndustrial{
    private double temperaturaAtual;

    public PrensaHidraulica(String numeroSerie) {
        super(numeroSerie);
        this.temperaturaAtual = 25.0;
    }

    // Getter de temperaturaAtual
    public double getTemperaturaAtual(){
        return this.temperaturaAtual;
    }
    //Setter de temperaturaAtual
    public void setTemperaturaAtual(double temperaturaAtual) throws IllegalArgumentException{
        this.temperaturaAtual = temperaturaAtual;
    }

    /**
     * Metodo que aciona o sistema de refrigeração da prensa hidráulica. Caso a temperatura atual seja menor ou igual a 90 graus, exibe uma mensagem informando que a temperatura está dentro do limite seguro. Caso contrário, aciona o sistema de refrigeração e reseta a temperatura para 25 graus
     */
    public void acionarRefrigeracao(){
        if(this.temperaturaAtual <= 90){
            System.out.println("A temperatura dentro do limite seguro.");
            return;
        }
        System.out.println("Acionando sistema de refrigeração...");
        this.temperaturaAtual = 25;
    }

    /**
     * Metodo que produz um lote de peças em uma prensa hidráulica. Caso a temperatura atual seja maior ou igual a 90 graus, lança uma exceção do tipo SuperaquecimentoException. Caso contrário, incrementa a temperatura atual em função da quantidade de peças produzidas e registra a produção utilizando o método registrarProducao da classe MaquinaIndustrial
     * @throws SuperaquecimentoException: Para quando a temperatura atual é maior ou igual a 90 graus
     */
    @Override
    public void produzirLote(int quantidade) throws SuperaquecimentoException {
        if (!getLigada()) {
            System.out.println("Máquina desligada.");
            return;
        }

        if (quantidade <= 0) {
            throw new IllegalArgumentException("Quantidade inválida.");
        }

        if (this.temperaturaAtual >= 90) {
            throw new SuperaquecimentoException(
                "Temperatura acima do limite seguro."
            );
        }

        this.temperaturaAtual += quantidade * 1.5;
        double energiaTotal = quantidade * 2.0;

        registrarProducao(quantidade, energiaTotal);

        System.out.println("Lote produzido com sucesso.");
    }
}