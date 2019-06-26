package Lista06;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PilhaVetorTest {

    @Test
    void Case1() {
        PilhaVetor<Integer> pilha = new PilhaVetor<>(10);
        assertTrue(pilha.estaVazia());
    }

    @Test
    void Case2() {
        PilhaVetor<Integer> pilha = new PilhaVetor<>(5);
        pilha.push(10);
        assertFalse(pilha.estaVazia());
    }

    @Test
    void Case3(){
        PilhaVetor<Integer> pilha = new PilhaVetor<>(10);
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
        PilhaVetor<Integer> pilha = new PilhaVetor<>(3);
        pilha.push(10);
        pilha.push(20);
        pilha.push(30);

        assertThrows(PilhaCheiaException.class ,() -> {pilha.push(40);});
    }

    @Test
    void Case5() {
        PilhaVetor<Integer> pilha = new PilhaVetor<>(3);
        assertThrows(PilhaVaziaException.class, () -> {pilha.pop();});
    }

    @Test
    void Case6() {
        PilhaVetor<Integer> pilha = new PilhaVetor<>(5);
        pilha.push(10);
        pilha.push(20);
        pilha.push(30);

        assertEquals(30, pilha.peek());
    }

    @Test
    void Case7() {
        PilhaVetor<Integer> pilha = new PilhaVetor<>(5);
        pilha.push(10);
        pilha.push(20);
        pilha.push(30);

        pilha.liberar();

        assertTrue(pilha.estaVazia());

    }

    @Test
    void Case8() {
        PilhaVetor<Integer> pilha = new PilhaVetor<>(5);
        pilha.push(10);
        pilha.push(20);
        pilha.push(30);
        PilhaVetor<Integer> pilha2 = new PilhaVetor<>(3);
        pilha2.push(40);
        pilha2.push(50);

        pilha.concatenar(pilha2);

        assertEquals("50,40,30,20,10", pilha.toString());

    }



}