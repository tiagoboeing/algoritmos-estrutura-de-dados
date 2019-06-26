package Lista09;

public class NoArvore<T> {

    private T info;
    private NoArvore<T> primeiro;
    private NoArvore<T> proximo;


    public NoArvore(T info){
        this.info = info;
        primeiro = null;
        proximo = null;
    }

    public void inserirFilho(NoArvore<T> sa){
        sa.setProximo(primeiro);
        primeiro = sa;
    }

    public NoArvore<T> getPrimeiro(){
        return primeiro;
    }

    public NoArvore<T> getProximo() {
        return proximo;
    }

    public void setProximo(NoArvore<T> proximo) {
        this.proximo = proximo;
    }

    public void setPrimeiro(NoArvore<T> primeiro) {
        this.primeiro = primeiro;
    }

    public T getInfo() {
        return info;
    }

    public void setInfo(T info) {
        this.info = info;
    }
}
