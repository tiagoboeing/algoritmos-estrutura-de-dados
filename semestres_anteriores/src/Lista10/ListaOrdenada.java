package Lista10;

public class ListaOrdenada<T extends Comparable<T>> extends ListaAbstract<T> {

    @Override
    public void inserir(T valor) {

        //Redimensiona caso faltas espaço
        if (getLimite() == getTamanho()) {
            redimensionar();
        }

        int posicao = procurarPosicaoInclusao(valor);

        if (posicao < getTamanho()) {
            //Adciona numa posição intermediaria
            deslocarDados(posicao);
        }
        //Armazena na posição localizada
        Object[] info = getInfo();
        info[posicao] = valor;

        //Incrementa a quantidade 
        setTamanho(getTamanho() + 1);
    }

    private int procurarPosicaoInclusao(T itemAdicionar) {
        Object[] info = getInfo();
        int i;//Posiçao aonde dever ser incerido o dado

        for (i = 0; i < getTamanho(); i++) {
            if (((Comparable) info[i]).compareTo(itemAdicionar) > 0) {
                break;
            }

        }
        return i;
    }

    private void deslocarDados(int posicao) {
        Object[] info = getInfo();
        for (int i = getTamanho() - 1; i >= posicao; i--) {
            info[i + 1] = info[i];

        }
    }

    //Caso o elemento procurado não pertença ao vetor, a busca linear com vetor ordenado apresenta um desempenho ligeiramente superior à busca linear
    //Complexidade: O(n)

    /* compareTo
    -1 quando a < b
    0 quando a == b
    1 quando a > b
     */
    @Override
    public int buscar(T valor) {
        Object[] info = getInfo();
        int inicio = 0;
        int fim = getTamanho() - 1;
        int meio;

        while (inicio <= fim) {
            System.out.println("rodou");
            meio = (inicio + fim) / 2;

            int comparacao = valor.compareTo((T) info[meio]);
            if (comparacao < 0) { //-1 quando a < b
                fim = meio - 1; //redefine posicao inicial
            } else {
                if (comparacao > 0) { //1 quando a > b
                    inicio = meio + 1; //redefine posicao inicial
                } else {
                    return meio; //achou
                }
            }
        }
        return -1;
    }

}
