package br.furb.fila;

import br.furb.fila.pilha.PilhaVetor;

public class FilaVetor<T> implements Fila<T> {

    private T[] info;
    private int limite;
    private int tamanho;
    private int inicio;

    /*
    construtor
    Cria uma fila com determinada capacidade de armazenamento
    @tam = quantidade máxima de dados que poderão ser enfileirados
     */
    public FilaVetor(int tam) {
        info = (T[]) new Object[tam];
        this.tamanho = 0;
        this.inicio = 0;
        limite = tam;

    }

    public static void main(String[] args) {
        FilaVetorTests tests = new FilaVetorTests();

//        tests.caso1();
//        tests.caso2();
//        tests.caso3();
//        tests.caso4();
//        tests.caso5();
//        tests.caso6();
//        tests.caso7();
        tests.caso8();
    }

    /*
    Inserir um novo dado na fila (final)
     */
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

    /*
    Verifica se a fila está vazia
    Retorna dado armazenado na posição início
     */
    public T peek() {
        if (estaVazia()) {
            throw new FilaVaziaException();
        }

        return info[inicio];

    }

    public T retirar() {
        //guardar um backup
        T valor = peek();
        info[inicio] = null;

        inicio = (inicio + 1) % limite;
        tamanho--;

        return valor;

    }

    /*
    Desinfilera todos os itens da fila
     */
    public void liberar() {
        //1a Implementação
        while (!estaVazia()) {
            retirar();
        }
    }

    public void liberar2() {
        try {
            while (true) {
                retirar();
            }
        } catch (FilaVaziaException e) {

        }
    }

    /*
    Retorna representação textual da fila, partindo do início até o final
    dados são separados por vírgula
    @return conteúdo da fila
     */
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

    /*
    Criauma nova fila, tomando como base uma fila pré existente
    @param f2
    Fila a ser concatenada à atual
     */
    public FilaVetor<T> criarFilaConcatenada(FilaVetor<T> f2) {
        FilaVetor<T> novo = new FilaVetor<T>(this.limite + f2.limite);

        copiarValoresFila(this, novo);
        copiarValoresFila(f2, novo);

        return novo;

        /*int indiceCopiar;

        indiceCopiar = this.inicio;
        for (int i = 0; i < this.tamanho; i++) {
            novo.inserir(this.info[indiceCopiar]);
            indiceCopiar = (indiceCopiar + 1) % this.limite;
        }

        //copia dados da fila atual
        indiceCopiar = f2.inicio;

        for (int i = 0; i < f2.tamanho; i++) {
            novo.inserir(f2.info[indiceCopiar]);
        }
        return null;        
         */
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

        //System.out.println(fila.getTamanho());
        //System.out.println(fila.getInicio());
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

        this.info = novo;
        this.limite = tamanho;
        this.inicio = 0;
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
