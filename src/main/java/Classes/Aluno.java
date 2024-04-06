package Classes;

public class Aluno{
  private String nome;
  private int matricula;
  private static int idadeMaxima = 130;

  Aluno(String nome, int matricula){
    this.nome = nome;
    this.matricula = matricula;
  }  

  public void imprimeInformacoes(){
    System.out.println("Nome do aluno: " + this.nome);
    System.out.println("Matricula do aluno: " + this.matricula);
    System.out.println("Idade máxima do aluno: " + Aluno.idadeMaxima);
  }
  
  public String getNome(){
    return nome;
  } 
  
  public void setNome(String nome){
    this.nome = nome;
  }  
  
  public int getMatricula(){
    return matricula;
  }  
  
  public void setMatricula(int matricula){
    this.matricula = matricula;
  }

  public int getIdadeMaxima(){
    return idadeMaxima;
  }
  
  public void setIdadeMaxima(int idadeMaxima){
    Aluno.idadeMaxima = idadeMaxima;
  }
}