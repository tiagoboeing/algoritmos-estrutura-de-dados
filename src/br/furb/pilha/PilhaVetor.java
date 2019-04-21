package br.furb.pilha;

public class PilhaVetor<T> implements Pilha<T> {

    private T[] info;
    private int limite;
    private int tamanho;

    public PilhaVetor(int lim) {
        info = (T[]) new Object[lim];
        this.limite = lim;
        this.tamanho = 0;
    }

    public static void main(String[] args) {
        PilhaVetorTests tests = new PilhaVetorTests(10);

//        tests.caso1();
//        tests.caso2();
//        tests.caso3();
//        tests.caso4();
//        tests.caso5();
//        tests.caso6();
//        tests.caso7();
//        tests.caso8();
    }

    @Override
    public void push(T valor) {
        if(tamanho == limite){
            throw new PilhaCheiaException();
        } else {
            this.info[tamanho] = valor;
            tamanho++;
        }
    }

    /*
        Retirar um dado do topo da pilha
        @return dado que foi desempilhado (do topo)
    */
    @Override
    public T pop() {
        if(estaVazia()){
            throw new PilhaVaziaException();
        }
        T save;
        save = peek();

        T valor = info[tamanho - 1];
        this.tamanho = tamanho - 1;

        return valor;
    }


    // Retorna o conteúdo do topo da pilha
    @Override
    public T peek() {
        if(estaVazia()){
            throw new PilhaVaziaException();
        }
        return info[tamanho-1];
    }

    @Override
    public boolean estaVazia() {
        return (tamanho == 0);
    }

    // Desempilha todos os dados
    @Override
    public void liberar() {
        while (tamanho != 0) {
            pop();
        }
    }

    /*
        Concatena a pilha com outra
        @param pilha a ser concatenada à pilha atual
    */
    public void concatenar(PilhaVetor<T> p) {
        for (int i = 0; i < p.tamanho; i++) {
            this.push(p.info[i]);
        }

    }

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
}
