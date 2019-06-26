package Lista06;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PilhaListaTest {

    @Test
    void Case1() {
        PilhaLista<Integer> pilha = new PilhaLista<>();

        assertTrue(pilha.estaVazia());
    }

    @Test
    void Case2(){
        PilhaLista<Integer> pilha = new PilhaLista<>();
        pilha.push(10);

        assertFalse(pilha.estaVazia());
    }

    @Test
    void Case3() {
        PilhaLista<Integer> pilha = new PilhaLista<>();
        pilha.push(10);
        pilha.push(20);
        pilha.push(30);

        assertEquals(30, pilha.pop());
        assertEquals(20, pilha.pop());
        assertEquals(10, pilha.pop());

        assertTrue(pilha.estaVazia());
    }

    @Test
    void Case4() {
        PilhaLista<Integer> pilha = new PilhaLista<>();
        pilha.push(10);
        pilha.push(20);
        pilha.push(30);

        assertEquals(30, pilha.peek());
        assertEquals(30, pilha.pop());
    }

    @Test
    void Case5() {
        PilhaLista<Integer> pilha = new PilhaLista<>();
        pilha.push(10);
        pilha.push(20);
        pilha.push(30);

        pilha.liberar();

        assertTrue(pilha.estaVazia());
    }


}