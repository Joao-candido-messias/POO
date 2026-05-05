public class Administrativo extends FuncionarioHospital{
    private String departamento;
    private boolean cargoDeGestao;

    public Administrativo(String nome, String matricula, double salarioBase, String departamento, boolean cargoDeGestao){
        super(nome, matricula, salarioBase);
        this.departamento = departamento;
        this.cargoDeGestao = cargoDeGestao;
    }

    //Getter de departamento
    public String getDepartamento(){
        return this.departamento;
    }
    //Setter de departamento
    public void setDepartamento(String departamento){
        this.departamento = departamento;
    }

    //Getter de cargoDeGestao
    public boolean getCargoDeGestao(){
        return this.cargoDeGestao;
    }
    //Setter de cargoDeGestao
    public void setCargoDeGestao(boolean cargoDeGestao){
        this.cargoDeGestao = cargoDeGestao;                                                    
    }

     /**
     * Calcula o salário total do funcionario administrativo. Considerando seu salario base e sua hierarquia
     * @return O salário total do funcionario administrativo.
     */
    @Override
    public double calcularSalario(){
        double salarioBase = getSalarioBase();
        double salarioTotal;
        if(this.getCargoDeGestao()){
            salarioTotal = salarioBase + 1500;
            return salarioTotal;
        }
        return salarioBase;
    }
}