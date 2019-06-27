package Trabalho2.lista;

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

    private int procurarPosicaoInclusao(T itemAdcionar) {
        Object[] info = getInfo();
        int i;//Posiçao aonde dever ser incerido o dado

        for (i = 0; i < getTamanho(); i++) {
            if (((Comparable) info[i]).compareTo(itemAdcionar) > 0) {
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

    @Override
    public int buscar(T valor) {
        Object[] info = getInfo();
        int inicio = 0;
        int fim = getTamanho() - 1;
        int meio;

        while (inicio <= fim) {
            meio = (inicio + fim) / 2;

            int comparacao = valor.compareTo((T) info[meio]);
            if (comparacao < 0) {
                fim = meio - 1;
            } else {
                if (comparacao > 0) {
                    inicio = meio + 1;
                } else {
                    return meio;
                }
            }
        }
        return -1;
    }

}
