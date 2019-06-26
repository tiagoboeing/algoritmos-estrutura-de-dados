package prova3.ordenacao;
//ordem de complexidade pior caso: ordem quadratica

public class OrdenacaoBolha<T extends Comparable<T>> extends
        OrdenacaoAbstract<T> {

    public void ordenar() {
        int i, j;
        T[] info = getInfo();
        int n = info.length;
        //System.out.println(info.length);
        int qtdTrocas = 1;
        for (i = n - 1; i >= 1; i--) {
            for (j = 0; j <= i - 1; j++) {
                if (info[j].compareTo(info[j + 1]) > 0) {

                    trocar(j, j + 1);
                    System.out.println("Troca " + qtdTrocas);
                    for (int u = 0; u < info.length; u++) {

                        System.out.println(info[u]);

                    }
                    qtdTrocas++;
                }
            }
        }
    }

    public T[] ordenarDecrescente() {
        int i, j;
        T[] info = getInfo();
        int n = info.length;
        boolean trocou;

        for (i = n - 1; i >= 1; i--) {
            trocou = false;

            for (j = 0; j <= i - 1; j++) {
                if (info[j].compareTo(info[j + 1]) < 0) {
                    trocar(j, j + 1);
                    trocou = true;
                }
            }
            if (!trocou) {
                break;
            }
        }
        for (int d = 0; d < info.length; d++) {
            System.out.println(info[d]);
        }
        return info;
    }
}
