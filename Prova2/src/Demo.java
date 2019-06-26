import fila.FilaVetor;

public class Demo {

    public static void main(String[] args) {
        System.out.println("Questão 1 - FilaVetor");
        questao1();

        System.out.println("---------------------");
        System.out.println("");

        questao2();
    }

    // PARCIAL
    public static void questao1(){
        FilaVetor<String> fila = new FilaVetor<String>(9);

        fila.setInicio(3);
        fila.setTamanho(4);

        fila.inserir("A");
        fila.inserir("B");
        fila.inserir("C");
        fila.inserir("D");

        fila.encolher();
        System.out.println(fila.toString());
    }


    public static void questao2(){

        // <1<2<><3<><>>><4<5<><>><6<><>>>>
        System.out.println("Questão 2 - Árvore Binária");

        NoArvoreBinaria<Integer> no3 = new NoArvoreBinaria<>(3);
        NoArvoreBinaria<Integer> no2 = new NoArvoreBinaria<>(2, null, no3);

        NoArvoreBinaria<Integer> no5 = new NoArvoreBinaria<>(5);
        NoArvoreBinaria<Integer> no6 = new NoArvoreBinaria<>(6);

        NoArvoreBinaria<Integer> no4 = new NoArvoreBinaria<>(4, no5, no6);

        NoArvoreBinaria<Integer> raiz = new NoArvoreBinaria<>(1, no2, no4);

        ArvoreBinaria<Integer> arvore = new ArvoreBinaria<>();
        arvore.setRaiz(raiz);

        System.out.println(arvore.toString());
        System.out.println(arvore.contarFolhas() + " folhas");
    }

}
