package Lista06;

public interface Pilha<T> {

    public void push(T valor);
    public T pop();
    public T peek();
    public boolean estaVazia();
    public void liberar();



}
