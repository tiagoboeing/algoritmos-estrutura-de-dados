package br.furb.arvore_n_arias;

public class AvoreNAriasTests {

    public static void main(String[] args) {
        Arvore<Integer> a = new Arvore();

        NoArvore<Integer> n9 = new NoArvore<>(9);
        NoArvore<Integer> n10 = new NoArvore<>(10);
        NoArvore<Integer> n4 = new NoArvore<>(4);
        n4.inserirFilho(n10);
        n4.inserirFilho(n9);

        NoArvore<Integer> n8 = new NoArvore<>(8);
        NoArvore<Integer> n3 = new NoArvore<>(3);
        n3.inserirFilho(n8);

        NoArvore<Integer> n5 = new NoArvore<>(5);
        NoArvore<Integer> n6 = new NoArvore<>(6);
        NoArvore<Integer> n7 = new NoArvore<>(7);
        NoArvore<Integer> n2 = new NoArvore<>(2);
        n2.inserirFilho(n7);
        n2.inserirFilho(n6);
        n2.inserirFilho(n5);

        NoArvore<Integer> n1 = new NoArvore<>(1);
        n1.inserirFilho(n4);
        n1.inserirFilho(n3);
        n1.inserirFilho(n2);

        a.setRaiz(n1);

        System.out.println(a.toString());
    }

}
