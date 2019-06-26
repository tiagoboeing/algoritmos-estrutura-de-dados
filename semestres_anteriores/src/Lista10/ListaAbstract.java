package Lista10;

public abstract class ListaAbstract<T> {

    private T[] info;
    private int tamanho;
    private final byte TAMANHO_INICIAL = 10;

    public ListaAbstract() {
        // Cria a lista vazia
        info = (T[]) new Object[TAMANHO_INICIAL];
        tamanho = 0;
    }

    public int getTamanho() {
        // Retorna o tamanho atua da lista, a quantidade de dados armazenados
        return tamanho;
    }

    public abstract void inserir(T valor);

    protected void redimensionar() {
        // Cria um pseudo redimensionamento do vetor info
        // Ordem de complexidade O(n) e no melhor caso O(n)

        if (getTamanho() == info.length) {
            redimensionar();
        }

        info = getInfo();

        T[] novo = (T[]) new Object[tamanho + 10];
        for (int i = 0; i < tamanho; i++) {
            novo[i] = info[i];
        }
        info = novo;
    }

    public void retirar(T valor) {
        // Retirar um dado da lista
        // Ordem de complexidade O(n) e no melhor caso O(n)
        // Se o dado estiver no primeiro a retirada vai ser devagar e o buscar
        // rapido.
        // Se o dado estiver na ultia o buscar é lento e a retirada rapida

        int posicao = buscar(valor);
        if (posicao > -1) {
            for (int i = posicao; i < tamanho - 1; i++) {
                info[i] = info[i + 1];
            }

            // limpa ultima posição
            info[tamanho - 1] = null;
            tamanho--;
        }
    }

    public abstract int buscar(T valor);

    public void exibir() {
        // Exibe o contéudo da lista
        // Ordem de complexidade O(n) e no melhor caso O(n)
        for (int i = 0; i < tamanho; i++) {
            System.out.println(info[i]);
        }
    }

    public T obterElemento(int posicao) {
        // Retorna o dado armazenado numa determinada posição

        if (posicao >= 0 && (posicao < tamanho)) {
            return info[posicao];
        } else {
            throw new IndexOutOfBoundsException("Posição Invalida");
        }
    }

    public boolean estaVazia() {
        return (tamanho == 0);
    }

    public void liberar() {
        // limpa a estrutura de dados
        // Ordem de complexidade O(1) e melhor caso O(1)

        info = (T[]) new Object[TAMANHO_INICIAL];
        tamanho = 0;
    }

    @Override
    public String toString() {
        String resultado = "";

        for (int i = 0; i < tamanho; i++) {
            if (i > 0) {
                resultado += ", ";
            }
            resultado += "" + info[i];

        }
        return resultado;
    }

    @Override
    public boolean equals(Object objeto) {
        //Melhor caso listas com tamanhos diiferentes O(1)
        //Pior caso as duas listas serem iguais O(n)

        if (objeto == null) {
            return false;
        }
        if (objeto == this) {
            return true;
        }
        if (this.getClass() != objeto.getClass()) {
            return false;
        }

        ListaAbstract outraLista = (ListaAbstract) objeto;

        if (this.getTamanho() != outraLista.getTamanho()) {
            return false;
        }

        for (int i = 0; i < this.getTamanho(); i++) {
            //Comparação de dados das duas listas
            if (!this.info[i].equals(outraLista.info[i])) {
                return false;
            }

        }
        return true;
    }

    protected T[] getInfo() {
        return info;
    }

    protected void setTamanho(int tamanho) {
        this.tamanho = tamanho;
    }

    public int getLimite() {
        return info.length;
    }

}
