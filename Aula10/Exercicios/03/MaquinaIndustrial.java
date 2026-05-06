abstract class MaquinaIndustrial{
    private String numeroDeserie;
    private boolean ligada;
    private int pecasProduzidasTotais;
    private double energiaConsumidaKWh;

    public MaquinaIndustrial(String numeroDeserie){
        this.numeroDeserie = numeroDeserie;
        this.ligada = false;
        this.pecasProduzidasTotais = 0;
        this.energiaConsumidaKWh = 0;
    }

    //Getter de numeroDeSerie
    public String getNumeroDeSerie(){
        return this.numeroDeserie;
    }

    //Getter de ligada
    public boolean getLigada(){
        return this.ligada;
    }

    //Getter de pecasProduzidasTotais
    public int getPecasProduzidasTotais(){
        return this.pecasProduzidasTotais;
    }

    //Getter de energiaConsumidaKWh
    public double getEnergiaConsumidaKWh(){
        return this.energiaConsumidaKWh;
    }

    /**
     * Metodo que liga uma maquina
     */
    public void ligar() throws  IllegalStateException{
        if(this.ligada){
            throw  new IllegalStateException("A maquina já está ligada");
        }
        System.out.println("Ligando maquina...");
        this.ligada = true;
    }

    /**
     * Metodo que desliga uma maquina
     */
    public void desligar() throws IllegalStateException{
        if(!this.ligada){
            throw  new IllegalStateException("A maquina já está desligada");
        }
        System.out.println("Desligando maquina...");
        this.ligada = false;
    }

    /**
     * Metodo que registra producao de pecas em uma maquina. Encrementando pecasProduzidasTotais e energiaConsumidaKWh
     */
    protected void registrarProducao(int pecas, double energia){
        this.pecasProduzidasTotais += pecas;
        this.energiaConsumidaKWh += energia;
    }

    public abstract void produzirLote(int quantidade) throws Exception;

}