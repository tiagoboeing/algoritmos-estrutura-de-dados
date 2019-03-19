package listas;

public class ListaEstaticaGenerica<T> {

    private T info[];
    private int size;
    private final byte TAMANHO_INICIAL = 10;


    public static void main(String[] args) {

        ListaEstaticaGenericaTests tests = new ListaEstaticaGenericaTests();

//        tests.caso1();
//        tests.caso2();
//        tests.caso3();
//        tests.caso4();
//        tests.caso5();
//        tests.caso6();
//        tests.caso7();
//        tests.caso8();
//        tests.caso9();

    }

    public ListaEstaticaGenerica() {
        size = 0;
        info = (T[]) new Object[TAMANHO_INICIAL];
    }

    
    public void redimensionar() {
        T[] novo = (T[]) new Object[size + 10];
        for (int i = 0; i < size; i++) {
            novo[i] = info[i];
        }
        info = novo;
    }

    public void inserir(T dado) {
        if (size == info.length) {
            redimensionar();
        }
        info[size] = dado;
        size++;
    }

    public void exibir() {
        for (int i = 0; i < size; i++) {
            System.out.println(info[i]);
        }
    }

    /* 
        Procura na lista um determinado dado
        @param dado a ser pesquisado
        @return posição do dado na lista. Caso não seja encontrado retorna -1
     */
    public int buscar(T dado) {
        for (int i = 0; i < size; i++) {
            if (info[i].equals(dado)) {
                return i;
            }
        }
        return -1;
    }

    public void retirar(T dado) {
        int posicao = buscar(dado);
        if (posicao > -1) {
            for (int i = posicao; i < size - 1; i++) {
                info[i] = info[i + 1];
            }
            size--;
            info[size] = null;
        }
    }

    public void liberar() {
        info = (T[]) new Object[TAMANHO_INICIAL];
        size = 0;
    }

    public T obterElemento(int posicao) {
        if (posicao >= 0 && (posicao < size)) {
            return info[posicao];
        } else {
            throw new IndexOutOfBoundsException();
        }
    }

    public boolean estaVazia() {
        return size == 0;
    }

    public int getTamanho() {
        return size;
    }

    @Override
    public String toString() {
        String result = "";
        for (int i = 0; i < size; i++) {
            if (i > 0) {
                result += ",";
            }
            result += info[i];
        }
        return result;
    }

}
