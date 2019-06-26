package Lista12;

public class Demo {

    public static void main(String[] args) {

        //new Demo().demoBolha();
        //new Demo().demoQuickSort();
        //new Demo().demoMergeSort();
        new Demo().demoBolhaDecrescente();

    }

    public void demoBolha() {

        Integer[] vetor = {30, 15, 90, 51, 28, 42};
        OrdenacaoBolha bolha = new OrdenacaoBolha();
        bolha.setInfo(vetor);

        bolha.ordenar();

    }

    public void demoBolhaDecrescente() {

        Integer[] vetor = {30, 15, 90, 51, 28, 42};
        OrdenacaoBolha bolha = new OrdenacaoBolha();
        bolha.setInfo(vetor);

        bolha.ordenarDecrescente();

    }

    public void demoQuickSort() {
        Integer[] vetor = {2, 5, 1, 7, 9, 12, 11, 10};
        Integer[] vetor2 = {25, 48, 37, 12, 57, 4, 86, 33, 92};
        OrdenacaoQuickSort quicksort = new OrdenacaoQuickSort();
        quicksort.setInfo(vetor2);

        quicksort.ordenar();

    }

}
