public class Arvore<Integer> {

    NoArvore<Integer> raiz;

    public Arvore() {
        raiz = null;
    }

    public NoArvore<Integer> getRaiz() {
        return raiz;
    }

    public void setRaiz(NoArvore<Integer> raiz) {
        this.raiz = raiz;
    }

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

    public int contarNos() {
        if (raiz == null) {
            return 0;
        } else {
            return contarNos(getRaiz());
        }
    }

    private int contarNos(NoArvore<Integer> no) {
        int qtde = 1;

        NoArvore<Integer> p = no.getPrimeiro();

        while (p != null) {
            qtde = qtde + contarNos(p);
            p = p.getProximo();
        }

        return qtde;
    }

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

        p = no.getPrimeiro();

        while (p != null) {
            s = s + obterRepresentacaoTextual(p);
            p = p.getProximo();
        }

        s = s + ">";
        return s;
    }

}
