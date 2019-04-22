package br.furb.fila.lista;

/*
Vagão
 */
public class NoLista<T> {

    private T info;
    //variavel de instancia
    private NoLista<T> proximo;

    public T getInfo() {
        return info;
    }

    public void setInfo(T info) {
        this.info = info;
    }

    public NoLista<T> getProximo() {
        return proximo;
    }

    public void setProximo(NoLista<T> proximo) {
        this.proximo = proximo;
    }

}
