package Lista12;
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

    public T[] ordenarTeste() {
        int i, j;
        T[] info = getInfo();
        int n = info.length;
        //System.out.println(info.length);

        for (i = n - 1; i >= 1; i--) {
            for (j = 0; j <= i - 1; j++) {
                if (info[j].compareTo(info[j + 1]) > 0) {
                    trocar(i, j + i);
                }
            }

        }
        return info;
    }

    public T[] ordenarMelhorado() {
        int i, j;
        T[] info = getInfo();
        int n = info.length;
        boolean trocou;

        for (i = n - 1; i >= 1; i--) {
            trocou = false;

            for (j = 0; j <= i - 1; j++) {
                if (info[j].compareTo(info[j + 1]) > 0) {
                    trocar(i, j + 1);
                    trocou = true;
                }
            }
            if (!trocou) {
                break;
            }
        }
        return info;
    }
    
        public void ordenarDecrescente() {
        int i, j;
        T[] info = getInfo();
        int n = info.length;
        for (i = n - 1; i >= 1; i--) {
            for (j = 0; j <= i - 1; j++) {
                if (info[j].compareTo(info[j + 1]) < 0) {
                    trocar(j, j + 1);
                }
            }
        }
        for(int d = 0; d < info.length; d++){
            System.out.println(info[d]);
        }
        
    }
}
