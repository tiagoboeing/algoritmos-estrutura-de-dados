package Lista08;

public class ArvoreBinaria<T> {

    NoArvoreBinaria<T> raiz;


    public ArvoreBinaria() {
        this.raiz = null;
    }

    public void setRaiz(NoArvoreBinaria<T> raiz) {
        this.raiz = raiz;
    }

    public boolean estaVazia() {
        if(raiz == null){
            return true;
        } else {
            return false;
        }
    }

    public boolean pertence(T info) {
        return pertence(raiz, info);
    }

    private boolean pertence(NoArvoreBinaria<T> no, T info) {

        if(no == null){
            return false;
        } else {
            return (no.info == info) || pertence(no.esquerda, info) || pertence(no.direita, info);
        }

    }

    private String arvorePre(NoArvoreBinaria<T> no) {
        if(no == null){
            return "";
        }

        return no.info + "<" + arvorePre(no.esquerda) + ">" + "<" + arvorePre(no.direita) + ">";
    }

    public int contarNos() {
        return 0;
    }

    private int contarNos(NoArvoreBinaria<T> no) {
        return 0;
    }

    @Override
    public String toString() {
        return "<"+ arvorePre(raiz) + ">";
    }


}

