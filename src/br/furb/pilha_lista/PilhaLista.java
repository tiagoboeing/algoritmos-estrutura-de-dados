package br.furb.pilha_lista;

import br.furb.pilha.PilhaVaziaException;

public class PilhaLista<T> implements Pilha<T> {

    private ListaEncadeada<T> lista = new ListaEncadeada<>();

    public static void main(String[] args) {
        PilhaListaTests tests = new PilhaListaTests();
//        tests.caso1();
//        tests.caso2();
//        tests.caso3();
//        tests.caso4();
//        tests.caso5();
    }

    @Override
    public void push(T info) {
        lista.inserir(info);
    }

    @Override
    public T pop() {
        T valor;
        valor = peek();
        lista.retirar(valor);

        return valor;
    }

    @Override
    public T peek() {
        if (lista.estaVazia()) {
            throw new PilhaVaziaException();
        }
        return lista.getPrimeiro().getInfo();

    }

    @Override
    public void liberar() {
        while (lista.estaVazia()) {
            pop();
        }
    }

    @Override
    public String toString() {
        return lista.toString();
    }

    @Override
    public boolean estaVazia() {
        return lista.estaVazia();
    }

}
