package br.furb.fila;
//(inicio + tamanho) % limite
//peek - return lista.getPrimeiro().getInfo(); 

public interface Fila<T> {

    void inserir(T v);

    T retirar();

    T peek();

    boolean estaVazia();

    void liberar();
}
