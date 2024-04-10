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

  public String exibirLista(){
    String lista = "<" + tamanho + ">";
    No apontaPraAtual = inicio;
    while(apontaPraAtual != null){
      lista += apontaPraAtual.info;
      apontaPraAtual = apontaPraAtual.proximo;
    }
    return lista;
  }

  public static void main(String [] args){
    ListaSimples l = new ListaSimples();
    l.inserirInicio("a");
    System.out.println(l);
    l.inserirInicio("b");
    System.out.println(l);
    l.inserirInicio("c");
    System.out.println(l);
  }
}