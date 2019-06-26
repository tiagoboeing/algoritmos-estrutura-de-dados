package Lista06;

public class PilhaVetor<T> implements Pilha<T> {

    private T info[];
    private int limite;
    private int tamanho;

    public PilhaVetor(int limite){
        info = (T[]) new Object[limite];
        this.limite = limite;
        tamanho = 0;
    }

    @Override
    public void push(T valor) {
        if(tamanho == limite){
            throw new PilhaCheiaException();
        }
        info[tamanho] = valor;
        tamanho++;
    }

    @Override
    public T pop() {
        if(estaVazia()) throw new PilhaVaziaException();

        T valor = peek();
        tamanho--;
        return valor;
    }

    @Override
    public T peek() {
        if(estaVazia()) throw new PilhaVaziaException();

        return info[tamanho-1];
    }

    @Override
    public boolean estaVazia() {
        if(tamanho > 0) return false;
        else return true;
    }

    @Override
    public void liberar() {
        int tamanhoInicial = tamanho;
        for (int i = 0; i < tamanhoInicial; i++) {
            pop();
        }
    }

    @Override
    public String toString(){
        String retorno = "";
        for (int i = tamanho-1; i >= 0; i--) {
            retorno += info[i];

            if(i != 0){
                retorno += ",";
            }
        }

        return retorno;
    }

    public void concatenar(PilhaVetor<T> p){
        for (int i = 0; i < p.tamanho; i++) {
            push(p.info[i]);
        }
    }


}
