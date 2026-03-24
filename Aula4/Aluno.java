package Aula4;

public class Aluno{

    public String nome;
    private Double nota1;
    private Double nota2;
    
    public Aluno(String nome, Double nota1, Double nota2){
        this.nome = nome;
        this.nota1 = nota1;
        this.nota2 = nota2;
    }

    //Getter para nome
    public String getNome(){
        return this.nome;
    }

    //Setter para nome
    public void setNome(String nome){
        this.nome = nome;
    }

    //Getter para nota1
    public Double getNota1(){   
        return this.nota1;
    }

    //Setter para nota1
    public void setNota1(Double nota1){
        this.nota1 = nota1;
    }

    //Getter para nota2
    public Double getNota2(){
        return this.nota2;
    }

    //Setter para nota2
    public void setNota2(Double nota2){
        this.nota2 = nota2;
    }


    //Função que calcula a média do aluno
    public String calcularMedia(){
        return "A média das duas notas do aluno "+ this.nome+ " é: "+(this.nota1+this.nota2)/2+".";
    }
}