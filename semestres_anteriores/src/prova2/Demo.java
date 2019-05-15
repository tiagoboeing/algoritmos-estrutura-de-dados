package prova2;

public class Demo {

    public static void main(String[] args) {

        NoArvoreBinaria<Integer> no4 = new NoArvoreBinaria<>(4);

        NoArvoreBinaria<Integer> no5 = new NoArvoreBinaria<>(5);

        NoArvoreBinaria<Integer> no2 = new NoArvoreBinaria<>(2, no4, no5);

        NoArvoreBinaria<Integer> no7 = new NoArvoreBinaria<>(7);

        NoArvoreBinaria<Integer> no6 = new NoArvoreBinaria<>(6, no7, null);

        NoArvoreBinaria<Integer> no3 = new NoArvoreBinaria<>(3, null, no6);

        NoArvoreBinaria<Integer> no1 = new NoArvoreBinaria<>(1, no2, no3);

        ArvoreBinaria<Integer> aB = new ArvoreBinaria<>();

        aB.setRaiz(no1);

        System.out.println("Árvore Binária");
        System.out.println("Nós: " + aB.contarNos());
        System.out.println("Folhas: " + aB.contarFolhas());

        ArvoreProva<Integer> a = new ArvoreProva<>();

        NoArvore<Integer> n4 = new NoArvore<>(4);
        NoArvore<Integer> n3 = new NoArvore<>(3);
        n3.inserirFilho(n4);

        NoArvore<Integer> n5 = new NoArvore<>(5);

        NoArvore<Integer> n2 = new NoArvore<>(2);
        n2.inserirFilho(n5);
        n2.inserirFilho(n3);

        NoArvore<Integer> n10 = new NoArvore<>(10);
        NoArvore<Integer> n9 = new NoArvore<>(9);
        n9.inserirFilho(n10);

        NoArvore<Integer> n8 = new NoArvore<>(8);
        NoArvore<Integer> n7 = new NoArvore<>(7);
        n7.inserirFilho(n9);
        n7.inserirFilho(n8);

        NoArvore<Integer> n6 = new NoArvore<>(6);

        NoArvore<Integer> n1 = new NoArvore<>(1);
        n1.inserirFilho(n7);
        n1.inserirFilho(n6);
        n1.inserirFilho(n2);

        Arvore<Integer> arvore = new Arvore<>();
        arvore.setRaiz(n1);

        a.setRaiz(n1);

        System.out.println("Árvore Prova");
        System.out.println("Somar Pares: " + a.somarPares());
        
    }

}
