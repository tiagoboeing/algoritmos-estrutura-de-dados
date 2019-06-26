package Lista12;

public class OrdenacaoQuickSort<T extends Comparable<T>> extends
        OrdenacaoAbstract<T> {

    //pior caso: ordenacao quadratica
    public void ordenar() {
        T[] info = getInfo();
        quickSort(0, info.length - 1);

    }

    private void quickSort(int inicio, int fim) {
        if (inicio < fim) {
            for (int i = 0; i < info.length; i++) {
                System.out.print(info[i] + " ");
            }
            int indicePivo = particionar(inicio, fim);
            System.out.println("Pivo: " + info[indicePivo]);

            quickSort(inicio, indicePivo - 1);
            quickSort(indicePivo + 1, fim);
        }
    }

    private int particionar(int inicio, int fim) {
        T[] info = getInfo();
        int a = inicio;
        int b = fim + 1;

        T pivo = info[inicio];

        while (true) {
            do {
                a++;
            } while (a <= fim && info[a].compareTo(pivo) < 0);
            do {
                b--;
            } while (b >= inicio && info[b].compareTo(pivo) > 0);

            if (a >= b) {
                break;
            }
            trocar(a, b);
        }
        trocar(b, inicio);
        return b;
    }
}
