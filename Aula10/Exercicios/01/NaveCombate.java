public class NaveCombate extends NaveEspacial{
    int numeroArmas;
    boolean escudoAtivado;

    public NaveCombate(String identificador, double combustivelMaximo, double velocidadeBase,  int numeroArmas, boolean escudoAtivado){
        super(identificador, combustivelMaximo, velocidadeBase);
        this.numeroArmas = numeroArmas;
        this.escudoAtivado = false;
    }

    //getter de numeroArmas
    public int getNumeroArmas(){
        return this.numeroArmas;
    }
    //setter de numeroArmas
    public void setNumeroArmas(int numeroArmas){
        this.numeroArmas = numeroArmas;
    }

    //getter de escudoAtivado
    public boolean getEscudoAtivado(){
        return this.escudoAtivado;
    }
    //setter de escudoAtivado
    public void setEscudoAtivado(boolean escudoAtivado){
        this.escudoAtivado = escudoAtivado;
    }

    /**
     * Medoto que calcula o consumo de uma nave de combate em função da distancia e da ativação do escudo
     * @param distanciaEmAnosLuz Distancia em anos luz do trajeto
     * @return Consumo da nave de combate para o trajeto
     * @throws CapacidadeInsuficiente No caso do calculo de consumo ser maior que o combustivelAtual
     */
    @Override
    public double calcularConsumo(double distanciaEmAnosLuz) throws CapacidadeInsuficiente{
        double consumo = distanciaEmAnosLuz * 0.8;

        if(this.escudoAtivado){
            consumo *= 1.15;  
        }
        
        if(consumo > this.getCombustivelAtual()){
            throw new CapacidadeInsuficiente("Niveis de combustivel insuficientes para esta viagem!");
        }
        return consumo;
    }
}
