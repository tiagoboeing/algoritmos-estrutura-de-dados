package br.furb.pilha_lista;

public interface Pilha<T> {

    void push(T v);

    T pop();

    T peek();

    void liberar();

    boolean estaVazia();

}
