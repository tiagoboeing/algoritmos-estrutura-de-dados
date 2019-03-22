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


}
