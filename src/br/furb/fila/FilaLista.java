package br.furb.fila;

import br.furb.fila.lista.ListaEncadeada;

public class FilaLista<T> implements Fila<T> {

    private ListaEncadeada<T> lista;

    public FilaLista() {
        lista = new ListaEncadeada<>();
    }

    public static void main(String[] args) {
        FilaListaTests tests = new FilaListaTests();

//        tests.caso1();
//        tests.caso2();
//        tests.caso3();
//        tests.caso4();
//        tests.caso5();
    }

    @Override
    public void inserir(T v) {
        lista.inserirNoFinal(v);
    }

    @Override
    public T peek() {
        if (estaVazia()) {
            throw new FilaVaziaException();
        }
        return lista.getPrimeiro().getInfo();
    }

    @Override
    public T retirar() {
        T valor = peek();
        lista.retirar(valor);

        return valor;
    }

    @Override
    public boolean estaVazia() {
        return lista.estaVazia();
    }

    @Override
    public void liberar() {
        while (!estaVazia()) {
            retirar();
        }

    }

    @Override
    public String toString() {
        return lista.toString();
    }
}
