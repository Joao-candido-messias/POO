public class NaveCombate extends NaveEspacial{
    private int numeroArmas;
    private boolean escudoAtivado;

    public NaveCombate(String identificador, double combustivelMaximo, double velocidadeBase,  int numeroArmas, boolean escudoAtivado){
        super(identificador, combustivelMaximo, velocidadeBase);
        this.numeroArmas = numeroArmas;
        this.escudoAtivado = escudoAtivado;
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
     * @throws CombustivelInsuficienteException No caso do calculo de consumo ser maior que o combustivelAtual
     */
    @Override
    public double calcularConsumo(double distanciaEmAnosLuz)throws CombustivelInsuficienteException{
        double consumo = distanciaEmAnosLuz * 0.8;

        if(this.escudoAtivado){
            consumo *= 1.15;  
        }
        
        if(consumo > this.getCombustivelAtual()){
            throw new CombustivelInsuficienteException("Niveis de combustivel insuficientes para esta viagem!");
        }
        return consumo;
    }
        
}
