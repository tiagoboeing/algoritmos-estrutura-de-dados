package Lista07;

public class FilaVetor<T> implements Fila<T> {

    private T info[];
    private int limite;
    private int tamanho;
    private int inicio;


    public FilaVetor(int limite){
        info = (T[]) new Object[limite] ;
        this.limite = limite;
        this.inicio = 0;
        this.tamanho = 0;
    }


    @Override
    public void inserir(T valor) {
        if(tamanho == limite){
            throw new FilaCheiaException();
        }

        int posInsert = (inicio + tamanho) % limite;
        info[posInsert] = valor;
        tamanho++;
    }

    @Override
    public boolean estaVazia() {
        if(tamanho > 0){
            return false;
        } else {
            return true;
        }
    }

    @Override
    public T peek() {
        if(estaVazia()){
            throw new FilaVaziaException();
        }
        return info[inicio];
    }

    @Override
    public T retirar() {
        T topo = peek();

        inicio = (inicio + 1) % limite;
        tamanho--;
        return topo;
    }

    @Override
    public void liberar() {
        info = (T[]) new Object[this.limite] ;
        this.inicio = 0;
        this.tamanho = 0;
    }

    public FilaVetor criarFilaConcatenada(FilaVetor<T> fila){
        FilaVetor<T> filaFinal = new FilaVetor<>(this.limite + fila.limite);

        int tamanhoInicial = this.tamanho;
        for (int i = 0; i < tamanhoInicial; i++) {
            T obj = retirar();
            filaFinal.inserir(obj);
            inserir(obj);
        }

        tamanhoInicial = fila.tamanho;
        for (int i = 0; i < tamanhoInicial; i++) {
            T obj = fila.retirar();
            filaFinal.inserir(obj);
            fila.inserir(obj);
        }

        return filaFinal;
    }


}
