package br.furb.arvore_n_arias;

public class NoArvore<T> {

    private T info;
    private NoArvore<T> primeiro; //primeiro filho
    private NoArvore<T> proximo; //proximo irmao

    public NoArvore(T info) {
        this.info = info;
        primeiro = null;
        proximo = null;
    }

    public T getInfo() {
        return info;
    }

    public void setInfo(T info) {
        this.info = info;
    }

    //inserção é logo após o primeiro nó filho.
    //depois disso, aponta o nó pai para o nó filho criado
    public void inserirFilho(NoArvore<T> sa){
        sa.setProximo(primeiro);
        setPrimeiro(sa);
    }

    public NoArvore<T> getPrimeiro() {
        return primeiro;
    }

    public void setPrimeiro(NoArvore<T> primeiro) {
        this.primeiro = primeiro;
    }

    public NoArvore<T> getProximo() {
        return proximo;
    }

    public void setProximo(NoArvore<T> proximo) {
        this.proximo = proximo;
    }

}
