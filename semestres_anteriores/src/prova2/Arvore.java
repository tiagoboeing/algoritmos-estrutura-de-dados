package prova2;

public class Arvore<Integer> {

    NoArvore<Integer> raiz;

    public Arvore() {
        raiz = null;
    }

    /*
    Retorna a raiz da árvore
    @return Raiz da árvore
     */
    public NoArvore<Integer> getRaiz() {
        return raiz;
    }

    /*
    Define a raiz da árvore
    @param raiz Nova raiz da árvore
     */
    public void setRaiz(NoArvore<Integer> raiz) {
        this.raiz = raiz;
    }

    /*
    Avalia se a árvore está vazia
    @return True se a árvore estiver vazia, senão false
     */
    public boolean estaVazia() {
        return (raiz == null);
    }

    public boolean pertence(int info) {
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
    private boolean pertence(NoArvore<Integer> no, int info) {
        if (no.getInfo() == (info)) {
            return true;
        } else {
            NoArvore<Integer> p;

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

    /*
    Conta a qtde de nós existentes na arvore
     */
    public int contarNos() {
        if (raiz == null) {
            return 0;
        } else {
            return contarNos(getRaiz());
        }
    }

    private int contarNos(NoArvore<Integer> no) {
        //o argumento para chamar esta função nunca será nulo, sempre terá a raiz
        int qtde = 1;

        NoArvore<Integer> p = no.getPrimeiro();

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
    public NoArvore<Integer> buscar(int info) {
        if (getRaiz() == null) {
            return null;
        } else {
            return buscar(getRaiz(), info);
        }
    }

    private NoArvore<Integer> buscar(NoArvore<Integer> no, int info) {
        if (no.getInfo() == info) {
            return no;
        } else {
            NoArvore<Integer> p = no.getPrimeiro();
            while (p != null) {
                NoArvore<Integer> noLocalizado = (buscar(p, info));

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

    private String obterRepresentacaoTextual(NoArvore<Integer> no) {
        NoArvore<Integer> p;

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

}
