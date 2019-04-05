package Prova1;

public class ListaDuplaTests extends ListaDupla{

    public void caso1(){
        ListaDupla<String> ld = new ListaDupla<>();

        ld.inserir("D");
        ld.inserir("C");
        ld.inserir("B");
        ld.inserir("A");

        System.out.println(ld.exibir());
        System.out.println("");
        System.out.println(ld.clonar().exibir());
    }
}
