package Lista03;

public class ListaEstatica<ClasseParametrizada> {

    private ClasseParametrizada[] info;
    private int tamanho;

    public ListaEstatica() {
        liberar();
    }

    public void inserir(ClasseParametrizada dado) {
        if (tamanho == info.length) {
            redimencionar();
        }
        info[tamanho] = dado;
        tamanho++;

    }

    private void redimencionar() {
        ClasseParametrizada[] novo = (ClasseParametrizada[]) new Object[info.length + 10];
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

    public int buscar(ClasseParametrizada dado) {
        for (int i = 0; i < info.length; i++) {
            if (info[i] == dado) {
                return i;
            }
        }
        return -1;
    }

    public void retirar(ClasseParametrizada valor) {
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
        info = (ClasseParametrizada[]) new Object[10];
        tamanho = 0;
    }

    public ClasseParametrizada obterElemento(int posicao) {
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
