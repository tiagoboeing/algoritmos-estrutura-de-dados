package Lista02;

public class ListaEstatica {

    private int[] info;
    private int tamanho;

    public ListaEstatica() {
        liberar();
    }

    public void inserir(int dado) {
        if (tamanho == info.length) {
            redimencionar();
        }

        if(tamanho == 0){
            info[0] = dado;
            tamanho++;
            return;
        }


        int valorAnterior = 0;
        int valor2 = 0;
        boolean valorFoiAlterado = false;
        for (int i = 0; i < tamanho+1; i++) {
            if(valorFoiAlterado){
                valor2 = info[i];
                info[i] = valorAnterior;
                valorAnterior = valor2;
            }
            if(info[i] > dado){
                //inserir antes inicio
                valorAnterior = info[i];
                info[i] = dado;
                valorFoiAlterado = true;
            }

        }

        tamanho++;

    }

    private void redimencionar() {
        int[] novo = new int[info.length + 10];
        for (int i = 0; i < info.length; i++) {
            novo[i] = info[i];
        }
        info = novo;
    }

    public void exibir() {
        for (int i = 0; i < info.length; i++) {
            System.out.println(info[i]);
        }
    }

    public int buscar(int dado) {
        for (int i = 0; i < info.length; i++) {
            if (info[i] == dado) {
                return i;
            }
        }
        return -1;
    }

    public void retirar(int valor) {
        int pos = buscar(valor);
        if (pos > -1) {
            return;
        }
        for (int i = pos; i < info.length - 1; i++) {
            info[i] = info[i + 1];
        }
        tamanho--;

    }

    public void liberar() {
        info = new int[10];
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
        if (tamanho == 0) {
            return true;
        }
        return false;
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
