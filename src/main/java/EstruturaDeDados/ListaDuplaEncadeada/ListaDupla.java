package EstruturaDeDados.ListaDuplaEncadeada;

public class ListaDupla{
  No inicio = null;
  No fim = null;
  int tamanho = 0;

  public void inserirInicio(String info){
    No no = new No();
    no.info = info;
    no.anterior = null;
    no.proximo = inicio;
    if(inicio != null){
      inicio.anterior = no;
    }
    inicio = no;
    if(tamanho == 0){
      fim = inicio;
    }
    tamanho++;
  }

  public String retirarInicio(){
    if(inicio == null){
      return null;
    }
    String out = inicio.info;
    inicio = inicio.proximo;
    if(inicio != null){
      inicio.anterior = null;
    } else{
      fim = null;
    }
    tamanho--;  
    return out;
  }

  public void inserirFim(String info){
    No no = new No();
    no.info = info;
    no.proximo = null;
    no.anterior = fim;
    if(fim != null){
      fim.proximo = no;
    }
    fim = no;
    if (tamanho == 0){
      inicio = fim;
    }
    tamanho++;
  }

  public String retirarFim(){
    if(fim == null){
      return null;
    }
    String out = fim.info;
    fim = fim.anterior;
    if(fim != null){
      fim.proximo = null;
    } else{
      inicio = null;
    }
    tamanho--;
    return out;
  }

  public void inserirNoIndice(int indice, String info){
    
    if(indice <= 0 || inicio == null){
      inserirInicio(info);
    } else if(indice >= tamanho){
        inserirFim(info);
    } else{
      No apontaPraAtual = inicio;
      for(int i = 0; i < indice - 1; i++){
        apontaPraAtual = apontaPraAtual.proximo;
      }
      No no = new No();
      no.info = info;
      no.proximo = apontaPraAtual.proximo;
      no.anterior = apontaPraAtual;
      apontaPraAtual.proximo.anterior = no;
      apontaPraAtual.proximo = no;
      tamanho++;
    } 
  }

  public String retirarNoIndice(int indice){
    if(indice < 0 || indice >= tamanho || inicio == null){
      return null;
    } else if(indice == 0){
      return (retirarInicio());
    } else if(indice == tamanho - 1){
      return (retirarFim());
    } else{
      No apontaPraAtual = inicio;
      for(int i = 0; i < indice - 1; i++){
        apontaPraAtual = apontaPraAtual.proximo;
      }
      String info = apontaPraAtual.proximo.info;
      apontaPraAtual.proximo = apontaPraAtual.proximo.proximo;
      if (apontaPraAtual.proximo != null) {
          apontaPraAtual.proximo.anterior = apontaPraAtual;
      } else {
          fim = apontaPraAtual;
      }
      tamanho--;
      return info;
    }
  }

  public String exibirLista(){
    String lista = "(" + tamanho + ")" + " ";
    No apontaPraAtual = inicio;
    while(apontaPraAtual != null){
      lista += apontaPraAtual.info;
      apontaPraAtual = apontaPraAtual.proximo;
    }
    return lista;
  }

  public static void main(String [] args){
    
    ListaDupla l = new ListaDupla();
    l.inserirInicio("a");
    l.inserirFim("b");
    l.inserirInicio("c");
    System.out.println(l.exibirLista());
    l.retirarFim();
    System.out.println(l.exibirLista());
    l.retirarInicio();
    System.out.println(l.exibirLista());
    l.inserirNoIndice(1, "info");
    System.out.println(l.exibirLista());
    l.inserirNoIndice(1, "/");
    System.out.println(l.exibirLista());
    l.inserirNoIndice(3, "//");
    l.inserirNoIndice(-1, "Lista: ");
    System.out.println(l.exibirLista());
    l.retirarNoIndice(3);
    l.retirarNoIndice(1);
    System.out.println(l.exibirLista());
    l.retirarNoIndice(0);
    System.out.println(l.exibirLista());
  }
  
}