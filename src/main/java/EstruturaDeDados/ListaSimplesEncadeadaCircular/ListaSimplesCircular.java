package EstruturaDeDados.ListaSimplesEncadeadaCircular;

public class ListaSimplesCircular{
  No inicio = null;
  int tamanho = 0;

  //Corrigido
  public void inserirInicio(String info){
    No no = new No();
    no.info = info;
    no.proximo = inicio;
    if(no.proximo == null){
      inicio = no;
      no.proximo = no;
    } else{
      No apontaPraAtual = inicio;
      while(apontaPraAtual.proximo != inicio){
        apontaPraAtual = apontaPraAtual.proximo;
      }
      apontaPraAtual.proximo = no;
      inicio = no;
    }
    tamanho++;
  }

  //Corrigido
  public String retirarInicio(){
    if(inicio == null){
      return null;
    } else{
      String info = inicio.info;
      if(inicio.proximo == inicio){
        inicio = null;
      } else{
        No apontaPraAtual = inicio;
        while(apontaPraAtual.proximo != inicio){
          apontaPraAtual = apontaPraAtual.proximo;
        }
        apontaPraAtual.proximo = inicio.proximo; 
        inicio = apontaPraAtual.proximo;
      }
      tamanho--;
      return "Retirado" + info;
    }
  }

  //Corrigido
  public void inserirFim(String info){
    No no = new No();
    no.info = info;
    if(inicio == null){
      inicio = no;
    } else{
      No apontaPraAtual = inicio;
      while(apontaPraAtual.proximo != inicio){
        apontaPraAtual = apontaPraAtual.proximo;
      }
      apontaPraAtual.proximo = no;
    }
    no.proximo = inicio;
    tamanho++;
  }

  //Corrigido
  public String retirarFim(){
    if(inicio == null){
      return null;
    } else if(inicio.proximo == inicio){
      String info = inicio.info;
      inicio = null;
      return "Retirado: " + info;
    } else{
        No apontaPraAtual = inicio;
        No aux = apontaPraAtual;
        while(apontaPraAtual.proximo != inicio){
          aux = apontaPraAtual;
          apontaPraAtual = apontaPraAtual.proximo;
        }
        String info = apontaPraAtual.info;
        aux.proximo = apontaPraAtual.proximo;
        tamanho--;
        return "Retirado: " + info;
      }
  }

  //Aparantemente funcionando sem problemas(checar)
  public void inserirNoIndice(int indice, String info){
    No no = new No();
    no.info = info;
    if(indice <= 0){
      inserirInicio(info);
    } else if(indice >= tamanho){
      inserirFim(info);
    } else{
      No apontaPraAtual = inicio;
      for(int i = 0; i < indice - 1; i++){
        apontaPraAtual = apontaPraAtual.proximo;
      }
      no.proximo = apontaPraAtual.proximo;
      apontaPraAtual.proximo = no;
    }
  }

  public String retirarNoIndice(){
    return null;
  }

  public String exibirLista(){
    String lista = "(" + tamanho + ")" + " ";
    No apontaPraAtual = inicio;
    while(apontaPraAtual.proximo != null){
      lista += apontaPraAtual.info + " ";
      apontaPraAtual = apontaPraAtual.proximo;
      if(apontaPraAtual == inicio){
        break;
      }
    }
    return lista;
  }

  public static void main(String [] args){
    ListaSimplesCircular l = new ListaSimplesCircular();
    l.inserirInicio("A");
    System.out.println(l.exibirLista());
    l.inserirInicio("B");
    System.out.println(l.exibirLista());
    l.inserirInicio("C");
    System.out.println(l.exibirLista());
    l.inserirInicio("D");
    System.out.println(l.exibirLista());
    l.retirarInicio();
    System.out.println(l.exibirLista());
    l.retirarInicio();
    System.out.println(l.exibirLista());
    l.retirarInicio();
    System.out.println(l.exibirLista());
    l.inserirFim("B");
    System.out.println(l.exibirLista());
    l.inserirFim("C");
    System.out.println(l.exibirLista());
    l.inserirFim("D");
    System.out.println(l.exibirLista());
    l.inserirFim("E");
    System.out.println(l.exibirLista());
    System.out.println(l.retirarFim());
    System.out.println(l.retirarFim());
    System.out.println(l.retirarFim());
    System.out.println(l.retirarFim());
    System.out.println(l.exibirLista());
    l.inserirNoIndice(2, "B");
    l.inserirNoIndice(2, "C");
    l.retirarInicio();
    l.inserirNoIndice(0, "A");
    System.out.println(l.exibirLista());
    /*l.inserirFim("B");
    l.inserirFim("C");
    System.out.println(l.exibirLista());
    l.retirarInicio();
    System.out.println(l.exibirLista());
    l.retirarFim();
    System.out.println(l.exibirLista());
    l.inserirInicio("A");
    l.inserirFim("D");
    l.inserirNoIndice(2, "C");
    System.out.println(l.exibirLista());*/
  }
  
}