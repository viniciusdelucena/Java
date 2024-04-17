package EstruturaDeDados.ListaSimplesEncadeadaCircular;

public class ListaSimplesCircular{
  No inicio = null;
  int tamanho = 0;

  public void inserirInicio(String info){
    No no = new No();
    no.info = info;
    no.proximo = inicio;
    inicio = no;
    if(no.proximo == null){
      no.proximo = no;
    } else{
      No apontaPraAtual = inicio;
      while(apontaPraAtual.proximo != null){
        apontaPraAtual = apontaPraAtual.proximo;
      }
      apontaPraAtual.proximo = inicio;
    }
    tamanho++;
  }

  public String retirarInicio(){
    if(inicio == null){
      return null;
    }
    return null;
  }
}