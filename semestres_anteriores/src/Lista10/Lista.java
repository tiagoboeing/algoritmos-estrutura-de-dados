package Lista10;

public class Lista<T> extends ListaAbstract<T> {

    @Override
    public void inserir(T valor) {

        // Adciona um dado na lista
        // Ordem de complexidade O(n) e no melhor caso O(1)
        T[] info = getInfo();
        if (getTamanho() == info.length) {
            redimensionar();
        }
        info[getTamanho()] = valor;
        setTamanho(getTamanho() + 1);
        ;
    }

    // Procura na lista o elemento solicitado.
    //Melhor caso: O(1)
    /*Pior caso:
    O valor de busca não existe ou está localizado no final do vetor.
    Se a quantidade de elementos é n, a quantidade necessária de comparações é n também
    Complexidade: O(n)
     */
    @Override
    public int buscar(T valor) {

        T[] info = getInfo();
        for (int i = 0; i < getTamanho(); i++) {
            if (info[i].equals(valor)) {
                return i;
            }
        }
        return -1;
    }
}
