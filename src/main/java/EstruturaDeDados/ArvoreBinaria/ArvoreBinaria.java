package EstruturaDeDados.ArvoreBinaria;

public class ArvoreBinaria {
    private Node raiz;
    
    public ArvoreBinaria(){
        this.raiz = null;
    }

    public void adicionar(int i) {
        if (estaVazio()) {
            this.raiz = new Node(i);
        } else {
            adicionarRecursivamente(this.raiz, i);
        }
    }

    public void removerUltimo() {
        if (this.raiz == null) { return; }

        raiz = removerUltimoRecursivamente(this.raiz);
    }

    public void removerPrimeiro() {
        if (this.raiz == null) { return; }
        raiz = removerPrimeiroRecursivamente(this.raiz);
    }


    public Node getRaiz() {
        return raiz;
    }

    private void adicionarRecursivamente(Node current, int i) {
        if (i < current.getValor()) {
            if (current.getEsquerda() == null) {
                current.setEsquerda(new Node(i));
            }else {
                adicionarRecursivamente(current.getEsquerda(), i);
            }
        } else {
            if (current.getDireita() == null) {
                current.setDireita(new Node(i));
            } else  {
                adicionarRecursivamente(current.getDireita(), i);
            }
        }
    }

    private Node removerPrimeiroRecursivamente(Node node) {
        if (node == null) { return null; }

        if (node.getDireita() == null && node.getEsquerda() == null) { return null; }

        if (node.getEsquerda() == null) { return node.getDireita(); }

        if (node.getDireita() == null) { return node.getEsquerda(); }

        Node successor = acharMenorValorNode(node.getDireita());
        node.setValor(successor.getValor());
        node.setDireita(removeMinValueNode(node.getDireita()));
        return node;
    }

    private Node acharMenorValorNode(Node node) {
        while (node.getEsquerda() != null) {
            node = node.getEsquerda();
        }
        return node;
    }

    private Node removeMinValueNode(Node node) {
        if (node.getEsquerda() == null) {
            return node.getDireita();
        }
        node.setEsquerda(removeMinValueNode(node.getEsquerda()));
        return node;
    }

    private Node removerUltimoRecursivamente(Node node) {
        if (node == null) { return null; }

        if (node.getDireita() == null && node.getEsquerda() == null) { return null; }

        if (node.getDireita() != null) {
            node.setDireita(removerUltimoRecursivamente(node.getDireita()));
            return node;
        }

        if (node.getEsquerda() != null) {
            node.setEsquerda(removerUltimoRecursivamente(node.getEsquerda()));
            return node;
        }

        return node;
    }

    private boolean estaVazio() { return getRaiz() == null; }

}
