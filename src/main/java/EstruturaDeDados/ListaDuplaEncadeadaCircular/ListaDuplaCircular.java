package EstruturaDeDados.ListaDuplaEncadeadaCircular;

public class ListaDuplaCircular {

    int tamanho = 0;
    No fim = null;
    No inicio = null;

    public void inserirInicio(String info) {
        No no = new No();
        no.info = info;
        if (inicio == null) {
            inicio = no;
            fim = no;
            no.proximo = no;
            no.anterior = no;
        } else {
            no.proximo = inicio;
            no.anterior = fim;
            inicio.anterior = no;
            fim.proximo = no;
            inicio = no;
        }
        tamanho++;
    }

    public String retirarInicio() {
        if (inicio == null) {
            return null;
        } else {
            String info = inicio.info;
            if (inicio.proximo == inicio) {
                inicio = null;
                fim = null;
            } else {
                inicio = inicio.proximo;
                inicio.anterior = fim;
                fim.proximo = inicio;
            }
            tamanho--;
            return "Retirado: " + info;
        }
    }

    public void inserirFim(String info) {
        No no = new No();
        no.info = info;
        if (inicio == null) {
            inicio = no;
            fim = no;
            no.proximo = no;
            no.anterior = no;
        } else {
            no.proximo = inicio;
            no.anterior = fim;
            inicio.anterior = no;
            fim.proximo = no;
            fim = no;
        }
        tamanho++;
    }

    public String retirarFim() {
        if (inicio == null) {
            return null;
        } else {
            String info = fim.info;
            if (inicio.proximo == inicio) {
                inicio = null;
                fim = null;
            } else {
                fim = fim.anterior;
                fim.proximo = inicio;
                inicio.anterior = fim;
            }
            tamanho--;
            return "Retirado: " + info;
        }
    }

    public void inserirNoIndice(int indice, String info) {
        No no = new No();
        no.info = info;
        if (indice <= 0) {
            inserirInicio(info);
        } else if (indice >= tamanho) {
            inserirFim(info);
        } else {
            No apontaPraAtual = inicio;
            for (int i = 0; i < indice - 1; i++) {
                apontaPraAtual = apontaPraAtual.proximo;
            }
            no.proximo = apontaPraAtual.proximo;
            no.anterior = apontaPraAtual;
            apontaPraAtual.proximo.anterior = no;
            apontaPraAtual.proximo = no;
            tamanho++;
        }
    }

    public String retirarNoIndice(int indice) {
        if (indice < 0 || indice >= tamanho || inicio == null) {
            return null;
        } else if (indice == 0) {
            return retirarInicio();
        } else if (indice == tamanho - 1) {
            return retirarFim();
        } else {
            No apontaPraAtual = inicio;
            for (int i = 0; i < indice; i++) {
                apontaPraAtual = apontaPraAtual.proximo;
            }
            String info = apontaPraAtual.info;
            apontaPraAtual.anterior.proximo = apontaPraAtual.proximo;
            apontaPraAtual.proximo.anterior = apontaPraAtual.anterior;
            tamanho--;
            return "Retirado: " + info;
        }
    }

    public String exibirLista() {
        if (inicio == null) {
            return "Não há nada para exibir";
        }
        String lista = "(" + tamanho + ")" + " ";
        No apontaPraAtual = inicio;
        do {
            lista += apontaPraAtual.info + " ";
            apontaPraAtual = apontaPraAtual.proximo;
        } while (apontaPraAtual != inicio);
        return lista;
    }

    public static void main(String[] args) {
        ListaDuplaCircular l = new ListaDuplaCircular();

        l.inserirInicio("A");
        System.out.println(l.exibirLista());
        l.inserirInicio("B");
        System.out.println(l.exibirLista());
        l.inserirInicio("C");
        System.out.println(l.exibirLista());
        l.retirarInicio();
        System.out.println(l.exibirLista());
        l.retirarInicio();
        System.out.println(l.exibirLista());

        l.inserirFim("D");
        System.out.println(l.exibirLista());
        l.inserirFim("E");
        System.out.println(l.exibirLista());

        l.inserirNoIndice(1, "F");
        System.out.println(l.exibirLista());

        l.retirarNoIndice(1);
        System.out.println(l.exibirLista());
    }

}
