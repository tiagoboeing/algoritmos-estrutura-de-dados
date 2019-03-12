package br.furb;

import java.util.Arrays;

public class ListaEstatica {

    private static int[] valor;
    private Integer tamanho = 10;

    public ListaEstatica(){
        this.valor = new int[tamanho];
    }

    public void redimensionar(){}

    public void inserir(int valor){
//        this.info += valor;
    }

    public void exibir(){}

    public int buscar(int valor){
        return 2;
    }

    public void retirar(){}

    public void liberar(){}

    public int obterElemento(int posicao){
        return 0;
    }

    public boolean estaVazia(){
        return false;
    }

    public int getTamanho(){
        return 0;
    }


    @Override
    public String toString() {
        return "teste";
//        return Arrays.toString(this.valor) + ", ";
    }
}
