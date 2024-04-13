package EstruturaDeDados;

public class ListaSimples{
  No inicio = null;
  int tamanho = 0;

  public void inserirInicio(String info){
    No no = new No();
    no.info = info;
    no.proximo = inicio;
    inicio = no;
    tamanho++;
  }
  
  public String retirarInicio(){
    if (inicio == null){
      return null;
    } 
    String info = inicio.info;
    inicio = inicio.proximo;
    tamanho--;
    return "Retirado: " + info;
  }

  public void inserirFim(String info){
    No no = new No();
    no.info = info;
    if(inicio == null){
      no.proximo = null; 
      inicio = no;
    } else{
      No apontaPraAtual = inicio;
      while(apontaPraAtual.proximo != null){
        apontaPraAtual = apontaPraAtual.proximo;
      }
      apontaPraAtual.proximo = no;
      no.proximo = null;
    }
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
        aux.proximo = null;
        tamanho--;
        return apontaPraAtual.info;
      }
    }
    inicio = null;
    tamanho--;
    return apontaPraAtual.info;
  }

  public void inserirNoIndice(int indice, String info){
    if(indice <= 0){
      inserirInicio(info);
    } else if(indice >= tamanho){
      inserirFim(info);
    }
    No apontaPraAtual = inicio;
    for(int i = 0; i < indice; i++){
      
    }
    
  }

  public String exibirLista(){
    String lista = "(" + tamanho + ")" + " ";
    No apontaPraAtual = inicio;
    while(apontaPraAtual != null){
      lista += apontaPraAtual.info + " ";
      apontaPraAtual = apontaPraAtual.proximo;
    }
    return lista;
  }

  public static void main(String [] args){
    ListaSimples l = new ListaSimples();
    l.inserirInicio("a");
    l.inserirInicio("b");
    l.inserirInicio("c");
    System.out.println(l.exibirLista());
    System.out.println(l.retirarInicio());
    System.out.println(l.exibirLista());
    l.inserirFim("7");
    System.out.println(l.exibirLista());
    l.retirarFim();
    System.out.println(l.exibirLista());
  }
}