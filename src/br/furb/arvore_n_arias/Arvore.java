package br.furb.arvore_n_arias;

public class Arvore<T> {

    NoArvore<T> raiz;

    public Arvore() {
        raiz = null;
    }

    /*
        Avalia se a árvore está vazia
        @return True se a árvore estiver vazia, senão false
    */
    public boolean estaVazia() {
        return (raiz == null);
    }

    public boolean pertence(T info) {
        if (raiz == null) {
            return false;
        } else {
            return pertence(raiz, info);
        }
    }

    /*
        Avalia se um determinado dado está armazenado na árvore
        @param info Dado a ser pesquisado
        @return True se o dado constar na árvore
    */
    private boolean pertence(NoArvore<T> no, T info) {
        if (no.getInfo().equals(info)) {
            return true;
        } else {
            NoArvore<T> p;

            p = no.getPrimeiro();
            while (p != null) {
                if (pertence(p.getInfo())) {
                    return true;
                }
                p = p.getProximo();
            }
        }
        return false;
    }

    public int contarNos() {
        if (raiz == null) {
            return 0;
        } else {
            return contarNos(getRaiz());
        }
    }

    private int contarNos(NoArvore<T> no) {
        //o argumento para chamar esta função nunca será nulo, sempre terá a raiz
        int qtde = 1;

        NoArvore<T> p = no.getPrimeiro();

        while (p != null) {
            qtde = qtde + contarNos(p);
            p = p.getProximo();
        }

        return qtde;
    }

    /*
        Localiza o nó que armazena um determinado dado
        @param info Dado a ser pesquisado
        @return Nó que contém o dado pesquisado
    */
    public NoArvore<T> buscar(T info) {
        if (getRaiz() == null) {
            return null;
        } else {
            return buscar(getRaiz(), info);
        }
    }

    private NoArvore<T> buscar(NoArvore<T> no, T info) {
        if (no.getInfo().equals(info)) {
            return no;
        } else {
            NoArvore<T> p = no.getPrimeiro();
            while (p != null) {
                NoArvore<T> noLocalizado = (buscar(p, info));

                if (noLocalizado != null) {
                    return noLocalizado;
                } else {
                    p = p.getProximo();
                }
            }
            return null;
        }
    }

    /*
        Devolve a representação textual da árvore
    */
    @Override
    public String toString() {
        if (raiz == null) {
            return "";
        } else {
            return obterRepresentacaoTextual(raiz);
        }
    }

    private String obterRepresentacaoTextual(NoArvore<T> no) {
        NoArvore<T> p;

        String s = "<";
        s = s + no.getInfo();

        //p começa no primeiro
        p = no.getPrimeiro();

        while (p != null) {
            s = s + obterRepresentacaoTextual(p);
            p = p.getProximo();
        }

        s = s + ">";
        return s;
    }

    /*
        Retorna a raiz da árvore
        @return Raiz da árvore
    */
    public NoArvore<T> getRaiz() {
        return raiz;
    }

    /*
        Define a raiz da árvore
        @param raiz Nova raiz da árvore
    */
    public void setRaiz(NoArvore<T> raiz) {
        this.raiz = raiz;
    }

}
