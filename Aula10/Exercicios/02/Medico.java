public class Medico extends FuncionarioHospital{
    private String especialidade;
    private double valorPorPlantao;
    private int quantidadePlantoes;

    public Medico(String nome, String matricula, double salarioBase, String especialidade, double valorPorPlantao){
        super(nome, matricula, salarioBase);
        this.especialidade = especialidade;
        this.valorPorPlantao = valorPorPlantao;
        this.quantidadePlantoes = 0;
    }

    //Getter de especialidade
    public String getEspecialidade(){
        return this.especialidade;
    }
    //Setter de especialidade
    public void setEspecialidade(String especialidade){
        this.especialidade = especialidade;
    }

    //Getter de valorPorPlantao
    public double getValorPorPlantao(){
        return this.valorPorPlantao;
    }
    //Setter de valorPorPlantao
    public void setValorPorPlantao(double valorPorPlantao)throws ValorInvalidoException{
        if(valorPorPlantao < 0){
            throw new ValorInvalidoException("Valor por plantão não pode ser negativo.");
        }
        this.valorPorPlantao = valorPorPlantao;
    }

    //Getter de quantidadePlantoes
    public int getQuantidadePlantoes(){
        return this.quantidadePlantoes;
    }
    //Setter de quantidadePlantoes
    public void setQuantidadePlantoes(int quantidadePlantoes)throws ValorInvalidoException{
        if(quantidadePlantoes < 0 || quantidadePlantoes > 31){
            throw new ValorInvalidoException("Quantidade de plantões inválida. O limite é 31 por mês.");
        }
        this.quantidadePlantoes = quantidadePlantoes;
    }

    /**
     * Calcula o salário total do médico, considerando o salário base e os plantões trabalhados.
     * @return O salário total do médico.
     * @throws ValorInvalidoException Se houver valores inválidos.
     */
    public double calcularSalario(){
        double salarioBase = getSalarioBase();
        double salarioTotal = salarioBase + (valorPorPlantao * quantidadePlantoes);
        return salarioTotal;
    }
}