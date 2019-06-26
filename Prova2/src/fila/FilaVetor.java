package fila;

import fila.pilha.PilhaVetor;

public class FilaVetor<T> implements Fila<T> {

    private T[] info;
    private int limite;
    private int tamanho;
    private int inicio;

    public FilaVetor(int tam) {
        info = (T[]) new Object[tam];
        this.tamanho = 0;
        this.inicio = 0;
        limite = tam;
    }

    @Override
    public void inserir(T v) {
        if (tamanho == limite) {
            throw new FilaCheiaException();
        }
        //fim = posicao inserir
        int fim;
        fim = (inicio + tamanho) % limite;
        info[fim] = v;
        tamanho++;
    }

    public boolean estaVazia() {
        return (tamanho == 0);
    }

    public T peek() {
        if (estaVazia()) {
            throw new FilaVaziaException();
        }
        return info[inicio];
    }

    public T retirar() {
        T valor = peek();
        info[inicio] = null;
        inicio = (inicio + 1) % limite;
        tamanho--;

        return valor;
    }

    public void liberar() {
        while (!estaVazia()) {
            retirar();
        }
    }

    public FilaVetor<T> criarFilaConcatenada(FilaVetor<T> f2) {
        FilaVetor<T> novo = new FilaVetor<T>(this.limite + f2.limite);
        copiarValoresFila(this, novo);
        copiarValoresFila(f2, novo);

        return novo;
    }

    private void copiarValoresFila(FilaVetor<T> origem, FilaVetor<T> destino) {
        int indiceCopiar = origem.inicio;
        for (int i = 0; i < origem.tamanho; i++) {
            destino.inserir(origem.info[indiceCopiar]);
            indiceCopiar = (indiceCopiar + 1) % origem.limite;
        }
    }

    public void empilhar(FilaVetor<T> fila) {
        PilhaVetor pilha = new PilhaVetor(fila.getTamanho());

        int tamanhoInicialFila = fila.getTamanho();

        while (!fila.estaVazia()) {
            pilha.push(fila.retirar());
        }

        System.out.println("Conteúdo da pilha: " + pilha.toString());
        System.out.println("Conteúdo da fila: " + fila.toString());
    }

    public void encolher() {
        T[] novo = (T[]) new Object[tamanho];
        int posicao = inicio;

        for (int i = 0; i < tamanho; i++) {
            novo[i] = info[posicao];
            posicao = (posicao + 1) % limite;
        }
        this.inicio = 0;
        this.info = novo;
        this.limite = tamanho;
    }

    public String toString() {
        String retorno = "";
        int indice = inicio;

        for (int i = 0; i < tamanho; i++) {
            if (i > 0) {
                retorno += ",";
            }
            retorno = retorno + info[indice];
            indice = (indice + 1) % limite;
        }
        return retorno;
    }

    public T[] getInfo() {
        return info;
    }

    public void setInfo(T[] info) {
        this.info = info;
    }

    public int getLimite() {
        return limite;
    }

    public void setLimite(int limite) {
        this.limite = limite;
    }

    public int getTamanho() {
        return tamanho;
    }

    public void setTamanho(int tamanho) {
        this.tamanho = tamanho;
    }

    public int getInicio() {
        return inicio;
    }

    public void setInicio(int inicio) {
        this.inicio = inicio;
    }

}
