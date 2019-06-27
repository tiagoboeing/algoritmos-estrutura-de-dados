package Trabalho2.lista;

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

    @Override
    public int buscar(T valor) {
        // Procura na lista o elemento solicitado.
        // Ordem de complexidade O(n) e no melhor caso O(1)

        T[] info = getInfo();
        for (int i = 0; i < getTamanho(); i++) {
            if (info[i].equals(valor)) {
                return i;
            }
        }
        return -1;
    }
}
