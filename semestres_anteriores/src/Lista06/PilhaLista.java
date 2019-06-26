package Lista06;

public class PilhaLista<T> implements Pilha<T> {

    private ListaEncadeada<T> lista;

    public PilhaLista() {
        lista = new ListaEncadeada<T>();
    }

    @Override
    public void push(T valor) {
        lista.inserir(valor);
    }

    @Override
    public T pop() {
        if(estaVazia())throw new PilhaVaziaException();

        T valor = peek();
        lista.retirar(valor);

        return valor;
    }

    @Override
    public T peek() {
        return lista.getPrimeiro().getInfo();
    }

    @Override
    public boolean estaVazia() {
        return lista.estaVazia();
    }

    @Override
    public void liberar() {
        while(!estaVazia()){
            pop();
        }
    }

    @Override
    public String toString() {
        return lista.toString();
    }
}
