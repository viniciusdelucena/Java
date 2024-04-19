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
    String info = inicio.info;
    inicio = inicio.proximo;
    No apontaPraAtual = inicio;
    while(apontaPraAtual.proximo != null){
      apontaPraAtual = apontaPraAtual.proximo;
    }
    apontaPraAtual.proximo = inicio;
    tamanho--;
    
    return "Retirado" + info;
  }

  public void inserirFim(String info){
    No no = new No();
    no.info = info;
    if(inicio == null){
      inicio = no;
    } else{
      No apontaPraAtual = inicio;
      while(apontaPraAtual.proximo != null){
        apontaPraAtual = apontaPraAtual.proximo;
      }
      apontaPraAtual.proximo = no;
    }
    no.proximo = inicio;
    tamanho++;
  }

  public String retirarFim(){
    if(inicio == null){
      return null;
    }
    No apontaPraAtual = inicio;
    while(apontaPraAtual.proximo != null){
      No aux = apontaPraAtual;
      apontaPraAtual = apontaPraAtual.proximo;
      if(apontaPraAtual.proximo == null){
        aux.proximo = inicio;
        tamanho--;
        return apontaPraAtual.info;
      }
    }
    inicio = null;
    tamanho--;
    return apontaPraAtual.info;
  }
  
}