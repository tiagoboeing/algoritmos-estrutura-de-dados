package br.furb.listas;

import br.furb.model.NoListaDupla;

public class ListaDuplaTests extends ListaDupla {

    public ListaDuplaTests() {
        super();
    }

    public void caso1(){
        ListaDupla<Integer> ld = new ListaDupla<>();

        ld.inserir(5);
        ld.inserir(10);
        ld.inserir(15);
        ld.inserir(20);

        System.out.println("CASO 1");
        ld.exibir();

      /*  System.out.println("============");
        ld.ordemInversa();*/
    }

    public void caso2(){
        ListaDupla<Integer> ld = new ListaDupla<>();

        ld.inserir(5);
        ld.inserir(10);
        ld.inserir(15);
        ld.inserir(20);

        System.out.println(ld.buscar(20).getInfo());
    }

    public void caso3(){
        ListaDupla<Integer> ld = new ListaDupla<>();

        ld.inserir(5);
        ld.inserir(10);
        ld.inserir(15);
        ld.inserir(20);

        System.out.println(ld.buscar(10).getInfo());
    }

    public void caso4(){
        ListaDupla<Integer> ld = new ListaDupla<>();

        ld.inserir(5);
        ld.inserir(10);
        ld.inserir(15);
        ld.inserir(20);

        ld.retirar(20);

        ld.exibir();
        System.out.println("=========");
        ld.ordemInversa();
    }

    public void caso5(){
        ListaDupla<Integer> ld = new ListaDupla<>();

        ld.inserir(5);
        ld.inserir(10);
        ld.inserir(15);
        ld.inserir(20);

        ld.retirar(10);

        ld.exibir();
        System.out.println("=========");
        ld.ordemInversa();
    }

    public void caso6(){
        ListaDupla<Integer> ld = new ListaDupla<>();

        ld.inserir(5);
        ld.inserir(10);
        ld.inserir(15);
        ld.inserir(20);

        ld.retirar(5);

        ld.exibir();
        System.out.println("=========");
        ld.ordemInversa();
    }

    public void caso7(){
        ListaDupla<Integer> ld = new ListaDupla<>();

        ld.inserir(5);
        ld.inserir(10);
        ld.inserir(15);
        ld.inserir(20);

        NoListaDupla<Integer> no5 = ld.buscar(5);
        NoListaDupla<Integer> no10 = ld.buscar(10);
        NoListaDupla<Integer> no15 = ld.buscar(15);
        NoListaDupla<Integer> no20 = ld.buscar(20);

        ld.liberar();

        System.out.println("5");
        System.out.println(no5.getAnterior());
        System.out.println(no5.getProximo());

        System.out.println("\n10");
        System.out.println(no10.getAnterior());
        System.out.println(no10.getProximo());

        System.out.println("\n15");
        System.out.println(no15.getAnterior());
        System.out.println(no15.getProximo());

        System.out.println("\n20");
        System.out.println(no20.getAnterior());
        System.out.println(no20.getProximo());

    }

    public void inserirPosicao(){
        ListaDupla<Integer> ld = new ListaDupla<>();

        ld.inserirIndex(0,5);
        ld.inserirIndex(1,10);
        ld.inserirIndex(2,15);
        ld.inserirIndex(3,20);

        System.out.println(ld.toString());
    }
}
