public class NaveCargueiro extends NaveEspacial{
    private double pesoCargaAtual;
    private double capacidadeMaximaCarga;

    public NaveCargueiro(String identificador, double combustivelMaximo, double velocidadeBase, double pesoCargaAtual, double capacidadeMaximaCarga)throws CargaImcompativelException{
        super(identificador, combustivelMaximo, velocidadeBase);
        if(capacidadeMaximaCarga<0){
            throw new CargaImcompativelException("Capacidade de carga invcalida!");
        }
        this.capacidadeMaximaCarga = capacidadeMaximaCarga;
        validarCarga(pesoCargaAtual);
    }

    /**
     * Função que valida a carga para que pesoCargaAtual nunca seja negativo ou maior que a capacidadeMaximaCarga
     * @oaram pesoCarga Peso de carga a ser validado
     * @throws CargaImcompativelException caso algum valor seja inválido
     */
    public void validarCarga(double pesoCarga)throws CargaImcompativelException{
        //Garante que pesoCargaAtual nunca seja negativo
        if(pesoCarga < 0){
            throw new CargaImcompativelException("Peso de carga invalido!");
        }
        //Garante que pesoCarga nunca seja maior que capacidadeMaximCarga
        if(pesoCarga > this.capacidadeMaximaCarga){
            throw new CargaImcompativelException("Peso execede a capacidade de carga da nave");
        }
        System.out.println("Carga validada!");
        this.pesoCargaAtual = pesoCarga;
    }

    //getter de capacidadeMaximaCarga
    public double getCapacidadeMaximaCarga(){
        return this.capacidadeMaximaCarga;
    }
    //setter de capacidadeMaximaCarga
    public void setCapacidadeMaximaCarga(double capacidadeMaximaCarga)throws CargaImcompativelException{
        if(capacidadeMaximaCarga<0){
            throw new CargaImcompativelException("Capacidade de carga invalida!");
        }
        this.capacidadeMaximaCarga = capacidadeMaximaCarga;
    }

    //getter de pesoCargaAtual
    public double getPesoCargaAtual(){
        return this.pesoCargaAtual;
    }
    //setter de pesoCargaAtual
    public void setPesoCargaAtual(double pesoCargaAtual){
        validarCarga(pesoCargaAtual);
    }


    /**
     * Metodo que calcula o consumo de uma nave cargueiro em função da distancia e do peso da carga
     * @param distanciaEmAnosLuz Distancia em anos luz do trajeto
     * @throws CapacidadeInsuficiente No caso do calculo de consumo ser maior que o combustivelAtual
     */
    @Override
    public double calcularConsumo(double distanciaEmAnosLuz) throws CapacidadeInsuficiente{
        if((distanciaEmAnosLuz * 0.5)+(this.pesoCargaAtual * 0.8) > this.getCombustivelAtual()){
            throw new CapacidadeInsuficiente("Niveis de combustivel insuficientes para esta viagem!");
        }
        return (distanciaEmAnosLuz * 0.5)+(this.pesoCargaAtual * 0.8);
    }
}