package Lista02;

public class ListaEstaticaTests {

    public static void main(String[] args) {
        ListaEstaticaTests test = new ListaEstaticaTests();
        test.case1();
    }

    public void case1(){
        ListaEstatica lista = new ListaEstatica();

        lista.inserir(20);
        lista.inserir(25);
        lista.inserir(30);
        lista.inserir(22);

        System.out.println("teste");

    }

}
