package Lista07;

public class FilaLista<T> implements Fila<T> {

    ListaEncadeada<T> lista;

    public FilaLista (){
        lista = new ListaEncadeada<T>();
    }

    @Override
    public void inserir(T valor) {
        lista.inserirNoFinal(valor);
    }

    @Override
    public boolean estaVazia() {
        return lista.estaVazia();
    }

    @Override
    public T peek() {
        return lista.getPrimeiro().getInfo();
    }

    @Override
    public T retirar() {
        T valor = this.peek();
        lista.retirar(valor);
        return valor;
    }

    @Override
    public void liberar() {
        while(!estaVazia()){
            retirar();
        }
    }
}
