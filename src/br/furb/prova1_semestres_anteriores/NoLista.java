package br.furb.prova1_semestres_anteriores;

public class NoLista <E> {
    E info;
    private NoLista proximo;
    private NoLista anterior;

    public NoLista() {

    }

    public E getInfo() {
        return info;
    }

    public void setInfo(E info) {
        this.info = info;
    }

    public NoLista <E> getProximo() {
        return proximo;
    }

    public void setProximo(NoLista<E> proximo) {
        this.proximo = proximo;
    }

    public NoLista <E> getAnterior() {
        return anterior;
    }

    public void setAnterior(NoLista<E> anterior) {
        this.anterior = anterior;
    }

}
