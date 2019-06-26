package Lista13;

public class Demo {

    public static void main(String[] args) {
        new Demo().demoMergeSort();
    }



    public void demoMergeSort() {
        Integer[] vetor = {70, 2, 88, 15, 90, 30};
        OrdenacaoMergeSort mergesort = new OrdenacaoMergeSort();
        mergesort.setInfo(vetor);

        mergesort.ordenar();
        System.out.println("Teste");

    }
}
