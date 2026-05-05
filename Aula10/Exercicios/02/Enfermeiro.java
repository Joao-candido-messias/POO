public class Enfermeiro extends FuncionarioHospital{
    private String setor;
    private double percentualInsalubridade;

    public Enfermeiro(String nome, String matricula, double salarioBase, String setor, double percentualInsalubridade)throws ValorInvalidoException{
        super(nome, matricula, salarioBase);
        this.setor = setor;
        if(percentualInsalubridade != 0.1 && percentualInsalubridade != 0.2  && percentualInsalubridade != 0.4){
            throw new ValorInvalidoException("Percentual de insalubridade não reconhecido pelo sindicato.");
        }
        this.percentualInsalubridade = percentualInsalubridade;
    }

    //Getter de setor
    public String getSetor(){
        return this.setor;
    }
    //Setter de setor
    public void setSetor(String setor){
        this.setor = setor;
    }

    //Getter de percentualInsalubridade
    public double getPercentualInsalubridade(){
        return this.percentualInsalubridade;
    }
    //Setter de percentualInsalubridade
    public void setPercentualInsalubridade(double percentualInsalubridade)throws ValorInvalidoException{
        if(percentualInsalubridade != 0.1 && percentualInsalubridade != 0.2  && percentualInsalubridade != 0.4){
            throw new ValorInvalidoException("Percentual de insalubridade não reconhecido pelo sindicato.");
        }
        this.percentualInsalubridade = percentualInsalubridade;
    }
        
    /**
     * Calcula o salário total do enfermeiro. Considerando seu salario base seu percentualInsalubridade e suas horas extras
     * @return O salário total do médico.
     * @throws ValorInvalidoException Se houver valores inválidos.
     */
    @Override
    public double calcularSalario(){
        double salarioBase = getSalarioBase();
        double bonus = salarioBase * this.getPercentualInsalubridade();
        double salarioTotal;
        if(this.getHorasTrabalhadasMensais() >160){
            salarioTotal = salarioBase + bonus + ( (this.getHorasTrabalhadasMensais() - 160)* 50);
            return salarioTotal;
        }
        salarioTotal = salarioBase + bonus;
        return salarioTotal;
    }
}