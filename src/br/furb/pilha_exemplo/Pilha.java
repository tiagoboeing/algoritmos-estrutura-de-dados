package br.furb.pilha_exemplo;

public interface Pilha<T> {

    void push(T v);

    T pop();

    T peek();

    void liberar();

    boolean estaVazia();

}
