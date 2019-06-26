package Lista11;

public abstract class ArvoreBinariaAbstract<T> {

    private NoArvoreBinaria<T> raiz;

    public NoArvoreBinaria<T> getRaiz() {
        return raiz;
    }

    public ArvoreBinariaAbstract() {
        raiz = null;
    }

    protected void setRaiz(NoArvoreBinaria<T> raiz) {
        this.raiz = raiz;

    }

    public boolean estaVazia() {

        return (raiz == null);

    }

    public boolean pertence(T info) {

        return pertence(raiz, info);
    }

    private boolean pertence(NoArvoreBinaria<T> no, T info) {

        if (no == null) {
            return false;
        } else if (no.getInfo().equals(info)) {
            return true;
        } else if (pertence(no.getEsquerda(), info)) {
            return true;
        } else {
            return pertence(no.getDireita(), info);
        }

    }

    @Override
    public String toString() {

        return arvorePre(raiz);
    }

    private String arvorePre(NoArvoreBinaria<T> no) {

        if (no == null) {
            return "<>";
        } else {
            return "<" + no.getInfo() + arvorePre(no.getEsquerda())
                    + arvorePre(no.getDireita()) + ">";
        }

    }

    public int contarQtdeNos() {
        return contaNos(raiz);
    }

    private int contaNos(NoArvoreBinaria no) {
        int qtd = 0;
        if (no != null) {
            qtd += contaNos(no.getDireita());
            qtd += contaNos(no.getEsquerda());
            qtd++;
        }
        return qtd;
    }

    public boolean isDegenerada() {

        NoArvoreBinaria<T> no = getRaiz();

        while (no != null) {

            if (no.getEsquerda() != null && no.getDireita() != null) {
                return false;
            } else if (no.getEsquerda() != null) {
                no = no.getEsquerda();

            }
            if (no.getDireita() != null) {
                no = no.getEsquerda();
            }
        }

        return true;
    }

    public int contarFilhos(NoArvoreBinaria no) {
        return numeroFilhos(no);
    }

    private int numeroFilhos(NoArvoreBinaria no) {
        return no == null ? 0 : 1 + contarFilhos(no.getEsquerda()) + contarFilhos(no.getDireita());
    }

}
