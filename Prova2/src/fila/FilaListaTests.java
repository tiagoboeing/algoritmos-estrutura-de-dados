package fila;

public class FilaListaTests {

    /*
    * Criar uma fila de inteiros.
    * Ao invocar estaVazia() deve resultar em true.
    */
    public void caso1(){
        FilaLista f = new FilaLista();
        System.out.println(f.estaVazia());
    }

    /*
    * Criar uma fila de inteiros. Enfilere o número 10.
    * Ao invocar estaVazia() deve resultar em false.
    */
    public void caso2(){
        FilaLista f = new FilaLista();
        f.inserir(10);
        System.out.println(f.estaVazia());
    }

    /* FIXME: não está retornando true
    * Criar uma fila de inteiros.
    * Empilhar os dados 10, 20 e 30, nesta ordem.
    *
    * Desenfileirar um dado. Deve ser retornado 10.
    * Desenfileirar outro dado. Deve ser retornado 20.
    * Desenfileirar outro dado. Deve ser retornado 30.
    * Após estas operações, o método estaVazia() deve resultar em true.
    */
    public void caso3(){
        FilaLista f = new FilaLista();
        f.inserir(10);
        f.inserir(20);
        f.inserir(30);

        System.out.println(f.retirar());
        System.out.println(f.retirar());
        System.out.println(f.retirar());
        System.out.println(f.estaVazia());
    }

    /*
    * Criar uma fila de inteiros. Enfileirar os dados 10, 20 e 30 (nesta ordem).
    * Conferir o início da fila. Deve retornar 10.
    * Em seguida, retirar um elemento da fila. Deve resultar em 10.
    */
    public void caso4(){
        FilaLista f = new FilaLista();
        f.inserir(10);
        f.inserir(20);
        f.inserir(30);

        System.out.println(f.peek());
        System.out.println(f.retirar());
    }

    /* FIXME: loop infinito
    * Criar uma fila de inteiros. Enfileirar os dados 10, 20, 30. Limpar a fila.
    * O método estaVazia() deve resultar em true
    */
    public void caso5(){
        FilaLista f = new FilaLista();
        f.inserir(10);
        f.inserir(20);
        f.inserir(30);

        f.liberar();
        System.out.println(f.estaVazia());
    }
}
