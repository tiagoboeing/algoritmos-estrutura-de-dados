package Lista07;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FilaVetorTest {

    @Test
    void Case1() {
        FilaVetor<Integer> fila = new FilaVetor<>(5);
        assertTrue(fila.estaVazia());
    }

    @Test
    void Case2() {
        FilaVetor<Integer> fila = new FilaVetor<>(5);
        fila.inserir(10);

        assertFalse(fila.estaVazia());
    }

    @Test
    void Case3() {
        FilaVetor<Integer> fila = new FilaVetor<>(10);
        fila.inserir(10);
        fila.inserir(20);
        fila.inserir(30);

        assertEquals(10, fila.retirar());
        assertEquals(20, fila.retirar());
        assertEquals(30, fila.retirar());
        assertTrue(fila.estaVazia());
    }

    @Test
    void Case4() {
        FilaVetor<Integer> fila = new FilaVetor<>(3);
        fila.inserir(10);
        fila.inserir(20);
        fila.inserir(30);

        assertThrows(FilaCheiaException.class, () -> {fila.inserir(40);});

    }

    @Test
    void Case5() {
        FilaVetor<Integer> fila = new FilaVetor<>(3);

        assertThrows(FilaVaziaException.class, () -> {fila.retirar();});
    }

    @Test
    void Case6() {
        FilaVetor<Integer> fila = new FilaVetor<>(5);
        fila.inserir(10);
        fila.inserir(20);
        fila.inserir(30);

        assertEquals(10, fila.peek());
        assertEquals(10, fila.retirar());
    }

    @Test
    void Case7() {
        FilaVetor<Integer> fila = new FilaVetor<>(5);
        fila.inserir(10);
        fila.inserir(20);
        fila.inserir(30);

        fila.liberar();
        assertTrue(fila.estaVazia());
    }

    @Test
    void Case8() {
        FilaVetor<Integer> fila = new FilaVetor<>(5);
        fila.inserir(10);
        fila.inserir(20);
        fila.inserir(30);

        FilaVetor<Integer> fila2 = new FilaVetor<>(3);
        fila2.inserir(40);
        fila2.inserir(50);

        FilaVetor<Integer> fila3 = fila.criarFilaConcatenada(fila2);

        assertEquals("10,20,30,40,50", fila3.toString());
    }


}