package br.furb.fila.pilha;

public class PilhaVetor<T> implements Pilha<T> {

    private T[] info;
    private int limite;
    private int tamanho;

    /*
    Construtor - Cria uma pilha com o tamanho especificado
    @param lim capacidade maxima de empilhamento
     */
    public PilhaVetor(int lim) {
        info = (T[]) new Object[lim];
        this.limite = lim;
        this.tamanho = 0;

    }

    /*
    Empilha um dado
    @param v Dado a ser empilhado
    tamanho = quantidade de elementos que foram empilhados
     */
    @Override
    public void push(T v) {
        if (tamanho == limite) {
            throw new PilhaCheiaException();
        } else {
            this.info[tamanho] = v;
            tamanho++;
        }
    }

    /*
    Retirar o dado do topo da pilha
    @return dado desempilhado
     */
    @Override
    public T pop() {

        if (estaVazia()) {
            throw new PilhaVaziaException();
        }

        T backup;

        backup = peek();

        T valor = info[tamanho - 1];
        this.tamanho = tamanho - 1;

        return valor;
    }

    /*
    Na segunda implementação, a validação da pilha vazia é feita no peek
     */
    public T pop2() {
        T valor = peek();
        info[tamanho - 1] = null;
        tamanho--;

        return valor;
    }

    /*
    Retorna o conteúdo do topo da pilha
    @return topo da pilha
     */
    @Override
    public T peek() {
        if (estaVazia()) {
            throw new PilhaVaziaException();
        }
        return info[tamanho - 1];
    }

    /*
    Retorna true se a pilha estiver vazia ou false se tiver algum conteúdo
     */
    @Override
    public boolean estaVazia() {
        return (tamanho == 0);
    }

    /*
    Desempilha todos os dados da pilha
     */
    @Override
    public void liberar() {
        while (tamanho != 0) {
            pop();
        }
    }

    public void liberar2() {
        info = (T[]) new Object[limite];
        this.tamanho = 0;

    }

    public void liberar3() {
        while (!estaVazia()) {
            pop();
        }
    }

    public void liberar4() {
        try {
            while (true) {
                pop();
            }

        } catch (PilhaVaziaException e) {

        }
    }

    /*
    Retorna o conteúdo da pilha, do topo até a base
     */
    @Override
    public String toString() {
        String resultado = "";

        for (int i = tamanho - 1; i >= 0; i--) {
            resultado += info[i];
            if (i > 0) {
                resultado = resultado + ",";
            }
        }
        return resultado;
    }
    /*
    Concatena a pilha corrente com a outra pilha
    @param p Pilha a ser concatenada à pilha atual
    */
    public void concatenar(PilhaVetor<T> p) {
        for (int i = 0; i < p.tamanho; i++) {
            this.push(p.info[i]);
        }

    }

}
