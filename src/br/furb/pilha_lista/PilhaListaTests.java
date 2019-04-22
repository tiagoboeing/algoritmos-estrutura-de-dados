package br.furb.pilha_lista;

public class PilhaListaTests extends PilhaLista{
    public PilhaListaTests() {
        super();
    }

    /*
    * Criar uma pilha de inteiros
    * Ao invocar estaVazia() deve resultar em true
    */
    public void caso1(){
        PilhaLista p = new PilhaLista();
        System.out.println(p.estaVazia());
    }

    /*
    * Criar uma pilha de inteiros. Empilhar o número 10.
    * Ao invocar estaVazia() deve resultar em false
    */
    public void caso2(){
        PilhaLista p = new PilhaLista();
        p.push(10);
        System.out.println(p.estaVazia());
    }

    /*
    * Criar uma pilha de inteiros. Empilhar os dados 10, 20 e 30, nesta ordem.
    * Desempilhar um dado. Deve ser retornado 30.
    * Desempilhar outro dado. Deve ser retornado 20.
    * Desempilhar outro dado. Deve ser retornado 10.
    * O método estaVazia() deve resultar em true.
    */
    public void caso3(){
        PilhaLista p = new PilhaLista();
        p.push(10);
        p.push(20);
        p.push(30);

        System.out.println(p.pop());
        System.out.println(p.pop());
        System.out.println(p.pop());

        System.out.println(p.estaVazia());
    }

    public void caso4(){
        PilhaLista p = new PilhaLista<Integer>();
        p.push(10);
        p.push(20);
        p.push(30);

        System.out.println(p.peek());

        System.out.println(p.pop());
    }

    public void caso5(){
        PilhaLista p = new PilhaLista<Integer>();
        p.push(10);
        p.push(20);
        p.push(30);

        p.liberar();
        System.out.println(p.estaVazia());
    }

}
