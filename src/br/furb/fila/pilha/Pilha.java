package br.furb.fila.pilha;

public interface Pilha<T> {

    void push(T v);

    T pop();

    T peek();

    void liberar();

    boolean estaVazia();

}
