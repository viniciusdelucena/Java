package EstruturaDeDados.ListaDuplaEncadeadaCircular;

public class ListaDuplaCircular{

  int tamanho = 0;
  No fim = null;
  No inicio = null;

  public void inserirInicio(String info){
    No no = new No();
    no.info = info;
    no.proximo = inicio;
    if(no.proximo == null){
      inicio = no;
      no.proximo = no;
      fim = no;
    } else{
      No apontaPraAtual = inicio;
      while(apontaPraAtual.proximo != inicio){
        apontaPraAtual = apontaPraAtual.proximo;
      }
      apontaPraAtual.proximo = no;
      inicio = no;
      no.proximo.anterior = no;
      fim = apontaPraAtual;
    }
    tamanho++;
  }

  public String exibirLista(){
    if(inicio == null){
      return "Não há nada para retirar";
    }
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

  public static void main(String[] args){
    ListaDuplaCircular l = new ListaDuplaCircular();

    l.inserirInicio("A");
    System.out.println(l.exibirLista());
    l.inserirInicio("B");
    System.out.println(l.exibirLista());
    l.inserirInicio("C");
    System.out.println(l.exibirLista());
  }
  
}