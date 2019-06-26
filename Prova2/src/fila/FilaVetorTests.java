package fila;

public class FilaVetorTests{

    /*
    * Criar uma fila de inteiros.
    * Ao invocar estaVazia() deve resultar em true.
    */
    public void caso1(){
        FilaVetor f = new FilaVetor(10);
        System.out.println(f.estaVazia());
    }

    /*
    * Criar fila de inteiros com capacidade de 5 elementos. Enfileirar o número 10.
    * Ao invocar estaVazia() deve resultar em false.
    */
    public void caso2(){
        FilaVetor f = new FilaVetor(5);
        f.inserir(10);
        System.out.println(f.estaVazia());
    }

    /*
    * Criar uma fila de inteiros com capacidade de 10 elementos.
    * Enfileirar os dados 10, 20 e 30, nesta ordem.
    * Desenfilerar um dado. Deve ser retornado 10.
    * Desenfilerar outro dado. Deve ser retornado 20.
    * Desenfilerar outro dado. Deve ser retornado 30.
    * O método estaVazia() deve resultar em true.
    */
    public void caso3(){
        FilaVetor f = new FilaVetor(10);
        f.inserir(10);
        f.inserir(20);
        f.inserir(30);

        System.out.println(f.retirar());
        System.out.println(f.retirar());
        System.out.println(f.retirar());

        System.out.println(f.estaVazia());
    }

    /*
    * Criar uma fila de inteiros com capacidade de 3 elementos.
    * Enfileirar os dados: 10, 20, 30 e 40.
    * A exceção FilaCheiaException deve ser lançada
    */
    public void caso4(){
        FilaVetor f = new FilaVetor(3);
        f.inserir(10);
        f.inserir(20);
        f.inserir(30);
        f.inserir(40);
    }

    /*
    * Criar uma fila de inteiros. Desenfileirar um dado.
    * A exceção FilaVaziaException deve ser lançada.
    */
    public void caso5(){
        FilaVetor f = new FilaVetor(10);
        f.retirar();
    }

    /*
    * Criar uma fila de inteiros com capacidade de 5 elementos.
    * Enfileirar os dados 10, 20 e 30 (nesta ordem). Conferir o início da fila.
    * Deve retornar 10.
    * Em seguida, retirar um elemento da fila. Deve resultar em 10 também.
    */
    public void caso6(){
        FilaVetor f = new FilaVetor(5);
        f.inserir(10);
        f.inserir(20);
        f.inserir(30);

        System.out.println(f.peek());
        System.out.println(f.retirar());
    }

    /*
    * Criar uma fila de inteiros com capacidade de 5 elementos.
    * Enfileirar os dados 10, 20, 30. Limpar a fila
    * O método estaVazia() deve resultar em true
    */
    public void caso7(){
        FilaVetor f = new FilaVetor(5);
        f.inserir(10);
        f.inserir(20);
        f.inserir(30);
        f.liberar();

        System.out.println(f.estaVazia());
    }

    /*
    * Criar uma fila de inteiros com capacidade de 5 elementos e
    * enfileirar os dados 10, 20 e 30 (nesta ordem).
    * Criar outra fila de inteiros com capacidade de
    * enfileirar 3 dados e adicionar os dados 40 e 50.
    * Concatenar as duas filas (1ª fila + 2ª fila)
    *
    * Ao utilizar toString() da fila resultante deve ser 10,20,30,40,50.
    * As filas originais, utilizadas na concatenação, não podem ser modificadas.
    * Validar, invocando toString() para a primeira fila. Deverá resultar em “10,20,30”.
    * Invocar toString() para a segunda fila, deverá resultar em “40,50”.
    * Validar que a capacidade de armazenamento da fila resultante seja de 8 elementos.
    */
    public void caso8(){
        FilaVetor f1 = new FilaVetor(5);
        f1.inserir(10);
        f1.inserir(20);
        f1.inserir(30);

        FilaVetor f2 = new FilaVetor(3);
        f2.inserir(40);
        f2.inserir(50);

        FilaVetor lista = f1.criarFilaConcatenada(f2);
        System.out.println(lista);

        System.out.println(f1);
        System.out.println(f2);
    }
}
