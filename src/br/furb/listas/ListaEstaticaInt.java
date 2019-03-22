package br.furb.listas;

public class ListaEstaticaInt {

    private int info[];
    private int tamanho;
    private final byte TAMANHO_INICIAL = 10;


    public static void main(String[] args) {

        ListaEstaticaIntTests tests = new ListaEstaticaIntTests();

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

    public ListaEstaticaInt() {
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

    public void inserir(int dado) {
        if (tamanho == info.length) {
            redimensionar();
        }
        info[tamanho] = dado;
        tamanho++;
    }

    public void inserirOrdenado(int valor) {
        if (tamanho == info.length) {
            redimensionar();
        }

        if (tamanho == 0) {
            info[0] = valor;
            tamanho++;
        }

        for (int i = 1; i < tamanho; i++) {
            if (valor < info[i]) {
                info[i] = info[i + 1];
                tamanho++;
            } else {
                info[i] = valor;
                tamanho++;
            }
        }
    }

    public void inserirOrdenado2(int valor) {
        if (tamanho == info.length) {
            redimensionar();
        }

        if (tamanho == 0) {
            info[0] = valor;
            tamanho++;
        }
        int temp;
        for (int i = 0; i < tamanho; i++) {
            for (int j = i; j > 0; j--) {
                if (info[j] < info[j - 1]) {
                    temp = info[j];
                    info[j] = info[j - 1];
                    info[j - 1] = temp;
                    info[tamanho] = valor;
                    tamanho++;
                }
            }
        }
    }

    public void inserirOrdenado4(int valor) {
        if (tamanho == info.length) {
            redimensionar();
        }

        int posicao = 0;

        while ((posicao < tamanho) && (info[posicao] < valor)) {
            posicao++;
        }
        
        for (int i=tamanho; i>posicao; i--){
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

    /* 
        Procura na lista um determinado dado
        @param dado a ser pesquisado
        @return posição do dado na lista. Caso não seja encontrado retorna -1
     */
    public int buscar(int dado) {
        for (int i = 0; i < tamanho; i++) {
            if (info[i] == dado) {
                return i;
            }
        }

        return -1;
    }

    /*
Retira um dado da lista
@param dado a ser removido
     */
    public void retirar(int dado) {
        int posicao = buscar(dado);
        if (posicao > -1) {
            for (int i = posicao; i < tamanho - 1; i++) {
                info[i] = info[i + 1];
            }
            tamanho--;
        }
    }

    /*
limpa a estrutura de dados, de forma que a lista esteja vazia
     */
    public void liberar() {
        info = new int[TAMANHO_INICIAL];
        tamanho = 0;
    }

    /*
Retorna o dado armazenado numa determinada posição da lista
@param posicao Posição do dados
@return dado localizado
     */
    public int obterElemento(int posicao) {
        if (posicao >= 0 && (posicao < tamanho)) {
            return info[posicao];
        } else {
            throw new IndexOutOfBoundsException();
        }
    }

    /*
Avalia se a lista está vazia ou contém dados armazenados
@return true se a lista estiver vazia, senão false
     */
    public boolean estaVazia() {
        return tamanho == 0;
    }

    public int getTamanho() {
        return tamanho;
    }

    /*
Retorna string contendo os dados armazenados na lista
     */
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
