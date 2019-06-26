package Lista09;

public class Arvore<T> {

    private NoArvore<T> raiz;


    public Arvore() {
        raiz = null;
    }

    public void setRaiz(NoArvore raiz) {
        this.raiz = raiz;
    }

    public NoArvore getRaiz() {
        return raiz;
    }

    private String obterRepresentacaoTextual(NoArvore<T> no) {
        String retorno = "<";
        retorno += no.getInfo();
        NoArvore<T> cursor = no.getPrimeiro();

        while(cursor != null) {
            retorno += obterRepresentacaoTextual(cursor);
            cursor = cursor.getProximo();
        }

        retorno += ">";


        return retorno;
    }

    public NoArvore<T> buscar(T info) {
        if(raiz != null){
            return buscar(raiz, info);
        } else {
            return null;
        }
    }

    private NoArvore<T> buscar(NoArvore<T> no, T info) {
        if(no.getInfo().equals(info))
            return no;
        else {
            NoArvore<T> p = no.getPrimeiro();
            while (p != null){
                NoArvore<T> noLocalizado = buscar(p, info);
                if(noLocalizado != null) {
                    return noLocalizado;
                } else {
                    p = p.getProximo();
                }

            }
            return null;
        }
    }


//    private NoArvore<T> buscar(NoArvore<T> no, T info) {
//        NoArvore<T> cursor = no.getPrimeiro();
//
//        while(cursor != null) {
//            if(cursor.getInfo() == info){
//                return cursor;
//            } else {
//                cursor = cursor.getProximo();
//                return buscar(cursor, info);
//            }
//        }
//
//        return null;
//
//    }

    public boolean pertence(T info) {
        if(raiz==null){
            return false;
        } else {
            return pertence(raiz, info);
        }
    }

    private boolean pertence(NoArvore<T> no, T info){
        if(no.getInfo().equals(info)){
            return true;
        } else {
            NoArvore<T> p;
            p = no.getPrimeiro();
            while(p != null) {
                if(pertence(p, info)){
                    return true;
                }
                p = p.getProximo();
            }
            return false;
        }
    }

    public int contarNos() {
        if(raiz == null) {
            return 0;
        } else {
            return contarNos(raiz);
        }
    }

    private int contarNos(NoArvore<T> no) {
        int retorno = 1;

        NoArvore<T> cursor = no.getPrimeiro();

        while(cursor != null) {
            retorno = retorno + contarNos(cursor);
            cursor = cursor.getProximo();
        }

        return retorno;
    }




    @Override
    public String toString() {
        if(raiz == null) {
            return "";
        } else {
            return obterRepresentacaoTextual(raiz);
        }

    }
}
