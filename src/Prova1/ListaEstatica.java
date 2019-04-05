package Prova1;

public class ListaEstatica {

    private int info[];
    private int tamanho;
    private final byte TAMANHO_INICIAL = 10;


    public static void main(String[] args) {

        ListaEstaticaTests tests = new ListaEstaticaTests();

        tests.caso1();
    }

    public ListaEstatica() {
        tamanho = 0;
        info = new int[TAMANHO_INICIAL];
    }


    public void redimensionar() {
        int[] novo = new int[tamanho + 10];
        for (int i = 0; i < tamanho; i++) {
            novo[i] = info[i];
        }
        info = novo;
    }

    public void inserir(int valor) {
        if (tamanho == info.length) {
            redimensionar();
        }

        int posicao = 0;

        while ((posicao < tamanho) && (info[posicao] < valor)) {
            posicao++;
        }

        for (int i=tamanho; i > posicao; i--){
            info[i] = info[i-1];
        }
        info [posicao] = valor;
        tamanho++;

    }

    public void exibir() {
        for (int i = 0; i < tamanho; i++) {
            System.out.println(info[i]);
        }
    }

    public int buscar(int dado) {
        for (int i = 0; i < tamanho; i++) {
            if (info[i] == dado) {
                return i;
            }
        }

        return -1;
    }

    public void retirar(int dado) {
        int posicao = buscar(dado);
        if (posicao > -1) {
            for (int i = posicao; i < tamanho - 1; i++) {
                info[i] = info[i + 1];
            }
            tamanho--;
        }
    }


    public void liberar() {
        info = new int[TAMANHO_INICIAL];
        tamanho = 0;
    }

    public int obterElemento(int posicao) {
        if (posicao >= 0 && (posicao < tamanho)) {
            return info[posicao];
        } else {
            throw new IndexOutOfBoundsException();
        }
    }

    public boolean estaVazia() {
        return tamanho == 0;
    }

    public int getTamanho() {
        return tamanho;
    }

    @Override
    public String toString() {
        String resultado = "";

        for (int i = 0; i < tamanho; i++) {
            if (i > 0) {
                resultado += ",";
            }
            resultado += info[i];
        }

        return resultado;
    }

}
