abstract class NaveEspacial{
    private String identificador;
    private double combustivelMaximo;
    private double combustivelAtual;
    private double velocidadeBase;

    public NaveEspacial(String identificador, double combustivelMaximo, double velocidadeBase){
        this.identificador = identificador;
        this.combustivelMaximo = combustivelMaximo;
        this.combustivelAtual = combustivelMaximo;
        this.velocidadeBase = velocidadeBase;
    }

    //getter de identificador
    public String getIdentificador(){
        return this.identificador;
    }
    //setter de identificador
    public void setIdentificador(String identificador){
        this.identificador = identificador;
    }
    
    //getter de combustivelMaximo
    public double getCombustivelMaximo(){
        return this.combustivelMaximo;
    }
    //setter de combustivelMaximo
    public void setCombustivelMaximo(double combustivelMaximo){
        this.combustivelMaximo = combustivelMaximo;
    }

    //getter de combustivelAtual
    public double getCombustivelAtual(){
        return this.combustivelAtual;
    }
    //setter de combustivelAtual
    public void setCombustivelAtual(double combustivelAtual) throws CombustivelInvalidoException {
        //Garante que  combustivelAtual nunca seja maior que combustivelMaximo nem menor que 0
        if(combustivelAtual > this.combustivelMaximo || combustivelAtual < 0){
            throw new CombustivelInvalidoException("Valor de combustivel invalido!");
        }

        this.combustivelAtual = combustivelAtual;
    }
    
    //getter de velocidadeBase
    public double getVelocidadeBase(){
        return this.velocidadeBase;
    }
    //setter de velocidadeBase
    public void setVelocidadeBase(double velocidadeBase){
        this.velocidadeBase = velocidadeBase;
    }

    /**
     * Metodo que calcula o consumo de um trajeto
     * @param distanciaEmAnosLuz: Distância em anos luz do trajeto
     * @return: Consumo necessário para efetuar o trajeto 
     */
    public abstract double calcularConsumo(double distanciaEmAnosLuz);

    /**
     * Metodo que verifica a possibilidade de uma naveEspacial viajar em função do seu consumo e de seu combustivelAtual
     * @param distancia: Distância da viagem
     */
    public void viajar(double distancia){
        double consumo = calcularConsumo(distancia);
        if(combustivelAtual >= consumo){
            combustivelAtual -= consumo;
            System.out.println("A nave "+this.identificador+" viajou "+distancia+" anos-luz. Combustível restante: "+this.combustivelAtual+".");
        }
    }

}