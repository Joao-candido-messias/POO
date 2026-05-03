public class NaveCargueiro extends NaveEspacial{
    private double pesoCargaAtual;
    private double capacidadeMaximaCarga;

    public NaveCargueiro(String identificador, double combustivelMaximo, double velocidadeBase, double pesoCargaAtual, double capacidadeMaximaCarga)
            throws CargaIncompativelException {

        super(identificador, combustivelMaximo, velocidadeBase);

        if(capacidadeMaximaCarga < 0){
            throw new CargaIncompativelException("Capacidade de carga invcalida!");
        }

        this.capacidadeMaximaCarga = capacidadeMaximaCarga;

        validarCarga(pesoCargaAtual);
    }

    /**
     * Função que valida a carga para que pesoCargaAtual nunca seja negativo ou maior que a capacidadeMaximaCarga
     * @param pesoCarga Peso de carga a ser validado
     * @throws CargaIncompativelException caso algum valor seja inválido
     */
    public void validarCarga(double pesoCarga) throws CargaIncompativelException{
        //Garante que pesoCargaAtual nunca seja negativo
        if(pesoCarga < 0){
            throw new CargaIncompativelException("Peso de carga invalido!");
        }

        //Garante que pesoCarga nunca seja maior que capacidadeMaximCarga
        if(pesoCarga > this.capacidadeMaximaCarga){
            throw new CargaIncompativelException("Peso execede a capacidade de carga da nave");
        }

        System.out.println("Carga validada!");
        this.pesoCargaAtual = pesoCarga;
    }

    //getter de capacidadeMaximaCarga
    public double getCapacidadeMaximaCarga(){
        return this.capacidadeMaximaCarga;
    }

    //setter de capacidadeMaximaCarga
    public void setCapacidadeMaximaCarga(double capacidadeMaximaCarga)
            throws CargaIncompativelException{

        if(capacidadeMaximaCarga < 0){
            throw new CargaIncompativelException("Capacidade de carga invalida!");
        }

        this.capacidadeMaximaCarga = capacidadeMaximaCarga;

        if(this.pesoCargaAtual > capacidadeMaximaCarga){
            this.pesoCargaAtual = capacidadeMaximaCarga;
        }
    }

    //getter de pesoCargaAtual
    public double getPesoCargaAtual(){
        return this.pesoCargaAtual;
    }

    //setter de pesoCargaAtual
    public void setPesoCargaAtual(double pesoCargaAtual)
            throws CargaIncompativelException{

        validarCarga(pesoCargaAtual);
    }

    /**
     * Metodo que calcula o consumo de uma nave cargueiro em função da distancia e do peso da carga
     * @param distanciaEmAnosLuz Distancia em anos luz do trajeto
     * @throws CombustivelInsuficienteException No caso do calculo de consumo ser maior que o combustivelAtual
     */
    @Override
    public double calcularConsumo(double distanciaEmAnosLuz)throws CombustivelInsuficienteException{

        double consumo = (distanciaEmAnosLuz * 0.5) + (this.pesoCargaAtual * 0.8);

        if(consumo > this.getCombustivelAtual()){
            throw new CombustivelInsuficienteException("Niveis de combustivel insuficientes para esta viagem!");
        }

        return consumo;
    }
}