public class NaveExploracao extends NaveEspacial{
    private boolean possuiSensoresAvancados;

    public NaveExploracao(String identificador, double combustivelMaximo, double velocidadeBase, boolean possuiSensoresAvancados){
        super(identificador, combustivelMaximo, velocidadeBase);
        this.possuiSensoresAvancados = possuiSensoresAvancados;
    }

    //getter de possuiSensoresAvancados
    public boolean getPossuiSensoresAvancados(){
        return this.possuiSensoresAvancados;
    }
    //setter de possuiSensoresAvancados
    public void setPossuiSensoresAvancados(boolean possuiSensoresAvancados){
        this.possuiSensoresAvancados = possuiSensoresAvancados;
    }

    @Override
    public double calcularConsumo(double distanciaEmAnosLuz) throws CombustivelInsuficienteException{
        double consumo = distanciaEmAnosLuz * 0.3;
        if(this.getPossuiSensoresAvancados()){
            consumo += 50;
        }
        if(consumo > this.getCombustivelAtual()){
            throw new CombustivelInsuficienteException("Niveis de combustivel insuficientes para esta viagem!");
        }
        return consumo;    
    }
}