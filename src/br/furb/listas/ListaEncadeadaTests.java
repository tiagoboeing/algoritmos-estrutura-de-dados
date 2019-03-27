package br.furb.listas;

public class ListaEncadeadaTests extends ListaEncadeada{

    public ListaEncadeadaTests() {
        super();
    }

    /* Verificar se é reconhecida lista vazia
    * saída esperada: estaVazia() = true
    */
    public void caso1(){
        ListaEncadeada le = new ListaEncadeada();
        System.out.println("CASO 1");
        System.out.println(le.isEmpty());
    }

    public void caso2(){
        ListaEncadeada le = new ListaEncadeada();
        le.insert(5);
        System.out.println("CASO 2");
        System.out.println(le.isEmpty());
    }

    public void caso3(){
        ListaEncadeada le = new ListaEncadeada();
        le.insert(5);
        System.out.println("CASO 3");
        System.out.println("First: " + le.getFirst());
        System.out.println("Length: " + le.getLength());
    }

    public void caso4(){
        ListaEncadeada le = new ListaEncadeada();
        le.insert(5);
        le.insert(10);
        le.insert(15);
        System.out.println("CASO 4");
        System.out.println("Length: " + le.getLength());
        System.out.println(le.toString());
    }

    public void caso5(){
        ListaEncadeada le = new ListaEncadeada();
        le.insert(5);
        le.insert(10);
        le.insert(15);
        le.insert(20);
        System.out.println("CASO 5");
        System.out.println(le.search(20).getInfo());
    }


    public void caso6(){
        ListaEncadeada le = new ListaEncadeada();
        le.insert(5);
        le.insert(10);
        le.insert(15);
        le.insert(20);
        System.out.println("CASO 6");
        System.out.println(le.search(15).getInfo());
    }

    public void caso7(){
        ListaEncadeada le = new ListaEncadeada();
        le.insert(5);
        le.insert(10);
        le.insert(15);
        le.insert(20);
        System.out.println("CASO 7");
        System.out.println(le.search(99));
    }

    public void caso8(){
        ListaEncadeada le = new ListaEncadeada();
        le.insert(5);
        le.insert(10);
        le.insert(15);
        le.insert(20);

        le.remove(20);
        System.out.println("CASO 8");
        System.out.println(le.toString());
    }

    public void caso9(){
        ListaEncadeada le = new ListaEncadeada();
        le.insert(5);
        le.insert(10);
        le.insert(15);
        le.insert(20);

        le.remove(15);
        System.out.println("CASO 9");
        System.out.println(le.toString());
    }

    public void caso10(){
        ListaEncadeada le = new ListaEncadeada();
        le.insert(5);
        le.insert(10);
        le.insert(15);
        le.insert(20);

        System.out.println("CASO 10");
        System.out.println(le.getNode(0).getInfo());
    }

    public void caso11(){
        ListaEncadeada le = new ListaEncadeada();
        le.insert(5);
        le.insert(10);
        le.insert(15);
        le.insert(20);

        System.out.println("CASO 11");
        System.out.println(le.getNode(3).getInfo());
    }

    public void caso12(){
        ListaEncadeada le = new ListaEncadeada();
        le.insert(5);
        le.insert(10);
        le.insert(15);
        le.insert(20);

        System.out.println("CASO 12");
        System.out.println(le.getNode(10).getInfo());
    }

    public void caso13(){
        ListaEncadeada le = new ListaEncadeada();

        System.out.println("CASO 13");
        System.out.println(le.getLength());
    }

    public void caso14(){
        ListaEncadeada le = new ListaEncadeada();
        le.insert(5);
        le.insert(10);
        le.insert(15);
        le.insert(20);

        System.out.println("CASO 14");
        System.out.println(le.getLength());
    }

}
