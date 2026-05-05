abstract class FuncionarioHospital{
    private String nome;
    private String matricula;
    private double salarioBase;
    private int horahorasTrabalhadasMensais;
    
    public FuncionarioHospital(String nome, String matricula, double salarioBase){
        this.nome = nome;
        this.matricula = matricula; 
        this.salarioBase = salarioBase;
        this.horahorasTrabalhadasMensais = 0;
    }

    //Getter de nome
    public String getNome(){
        return this.nome;
    }
    //Setter de nome
    public void setNome(String nome){
        this.nome = nome;
    }

    //Getter de matricula
    public String getMatricula(){
        return this.matricula;
    }
    //Setter de matricula
    public void setMatricula(String matricula){
        this.matricula = matricula;
    }

    //Getter de salarioBase
    public double getSalarioBase(){
        return this.salarioBase;
    }
    //Setter de salarioBase
    public void setSalarioBase(double salarioBase)throws ValorInvalidoException{
        if(salarioBase < 1412.00){
            throw new ValorInvalidoException("Salário base não pode ser inferior ao mínimo legal.");
        }
        this.salarioBase = salarioBase;
    }
    //Getter de horasTrabalhadasMensais
    public int getHorasTrabalhadasMensais(){
        return this.horahorasTrabalhadasMensais;
    }
    //Setter de horasTrabalhadasMensais
    public void setHorasTrabalhadasMensais(int horasTrabalhadasMensais)throws ValorInvalidoException{
        if(horasTrabalhadasMensais < 0 || horasTrabalhadasMensais > 300){
            throw new ValorInvalidoException("Carga horária inválida. O limite humano é 300 horas.");
        }
        this.horahorasTrabalhadasMensais = horasTrabalhadasMensais;
    }

    /**
     * Metodo abstrato para calcular o salário do funcionário, a ser implementado pelas subclasses
     * @return
     * @throws ValorInvalidoException
     */
    abstract double calcularSalario() throws ValorInvalidoException;

    /**
     * Metodo que exibe um resumo mensal do funcionário, incluindo seu nome, matrícula, salário base, horas trabalhadas e o salário final calculado. Caso haja algum erro no cálculo do salário, a mensagem de erro será exibida.
     */
    public void exibirResumoMensal(){
        System.out.println("Resumo Mensal do Funcionário:");
        System.out.println(this.toString());
        try{
            System.out.println("Salário Final: R$" + String.format("%.2f", this.calcularSalario()));
        }catch(ValorInvalidoException e){
            System.out.println("Erro ao calcular salário: " + e.getMessage());
        }
    }

    @Override
    public String toString(){
        return "Nome: " + this.nome + "\nMatricula: " + this.matricula + "\nSalário Base: R$" + String.format("%.2f", this.salarioBase) + "\nHoras Trabalhadas Mensais: " + this.horahorasTrabalhadasMensais;
    }

}