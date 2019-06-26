package Lista05;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ListaDuplaTest {


    @Test
    void Case1(){
        ListaDupla<Integer> lista = new ListaDupla<Integer>();
        lista.inserir(5);
        lista.inserir(10);
        lista.inserir(15);
        lista.inserir(20);

        String retornoOrdem = lista.toString();
        assertEquals("20, 15, 10, 5", retornoOrdem);
        lista.exibirOrdemInversa();
//        assertEquals("5, 10, 15, 20", outContent.toString());

    }

    @Test
    void Case2(){
        ListaDupla<Integer> lista = new ListaDupla<Integer>();
        lista.inserir(5);
        lista.inserir(10);
        lista.inserir(15);
        lista.inserir(20);

        NoListaDupla obj = lista.buscar(20);
        assertEquals(20, obj.getInfo());
    }

    @Test
    void Case3(){
        ListaDupla<Integer> lista = new ListaDupla<Integer>();
        lista.inserir(5);
        lista.inserir(10);
        lista.inserir(15);
        lista.inserir(20);


        NoListaDupla obj = lista.buscar(10);
        assertEquals(10, obj.getInfo());
    }

    @Test
    void Case4(){
        ListaDupla<Integer> lista = new ListaDupla<Integer>();
        lista.inserir(5);
        lista.inserir(10);
        lista.inserir(15);
        lista.inserir(20);

        lista.retirar(20);

        String retornoOrdem = lista.toString();
        assertEquals("15, 10, 5", retornoOrdem);
        lista.exibirOrdemInversa();
        //assertEquals("5, 10, 15", outContent.toString());

    }

    @Test
    void Case5(){

        ListaDupla<Integer> lista = new ListaDupla<Integer>();
        lista.inserir(5);
        lista.inserir(10);
        lista.inserir(15);
        lista.inserir(20);

        lista.retirar(10);


        String retornoOrdem = lista.toString();
        assertEquals("20, 15, 5", retornoOrdem);
        lista.exibirOrdemInversa();
        //assertEquals("5, 15, 20", outContent.toString());

    }

    @Test
    void Case6(){

        ListaDupla<Integer> lista = new ListaDupla<Integer>();
        lista.inserir(5);
        lista.inserir(10);
        lista.inserir(15);
        lista.inserir(20);

        lista.retirar(5);

        String retornoOrdem = lista.toString();
        assertEquals("20, 15, 10", retornoOrdem);
        lista.exibirOrdemInversa();
        //assertEquals("10, 15, 20", outContent.toString());

    }

    @Test
    void Case7(){
        ListaDupla<Integer> lista = new ListaDupla<Integer>();
        lista.inserir(5);
        lista.inserir(10);
        lista.inserir(15);
        lista.inserir(20);


        NoListaDupla<Integer> n1 = lista.buscar(20);
        NoListaDupla<Integer> n2 = lista.buscar(15);
        NoListaDupla<Integer> n3 = lista.buscar(10);
        NoListaDupla<Integer> n4 = lista.buscar(5);


        lista.liberar();

        assertNull(n1.getAnterior());
        assertNull(n1.getProximo());

        assertNull(n2.getAnterior());
        assertNull(n2.getProximo());

        assertNull(n3.getAnterior());
        assertNull(n3.getProximo());

        assertNull(n4.getAnterior());
        assertNull(n4.getProximo());
    }

    @Test
    void Case08(){
        ListaDupla<Integer> lista = new ListaDupla<Integer>();
        lista.inserir(5);
        lista.inserir(10);
        lista.inserir(15);
        lista.inserir(20);


        ListaDupla<Integer> clone = lista.clonar();
        System.out.println("Teste");

    }

}