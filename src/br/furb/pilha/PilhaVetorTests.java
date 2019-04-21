package br.furb.pilha;

public class PilhaVetorTests extends PilhaVetor {

    public PilhaVetorTests(int lim) {
        super(lim);
    }

    public void caso1(){
        PilhaVetor p = new PilhaVetor(10);
        System.out.println(p.estaVazia());
    }

    public void caso2(){
        PilhaVetor p = new PilhaVetor(5);
        p.push(10);
        System.out.println(p.estaVazia());
    }

    public void caso3(){
        PilhaVetor p = new PilhaVetor(10);
        p.push(10);
        p.push(20);
        p.push(30);

        System.out.println(p.pop());
        System.out.println(p.pop());
        System.out.println(p.pop());

        System.out.println(p.estaVazia());
    }

    public void caso4(){
        PilhaVetor p = new PilhaVetor(3);
        p.push(10);
        p.push(20);
        p.push(30);
        p.push(40);
    }

    public void caso5(){
        PilhaVetor p = new PilhaVetor(10);
        p.pop();
    }

    public void caso6(){
        PilhaVetor p = new PilhaVetor(5);
        p.push(10);
        p.push(20);
        p.push(30);
        System.out.println(p.peek());

        System.out.println(p.pop());
    }

    public void caso7(){
        PilhaVetor p = new PilhaVetor(5);
        p.push(10);
        p.push(20);
        p.push(30);
        p.liberar();

        System.out.println(p.estaVazia());
    }

    public void caso8(){
        PilhaVetor p1 = new PilhaVetor(5);
        p1.push(10);
        p1.push(20);
        p1.push(30);

        PilhaVetor p2 = new PilhaVetor(5);
        p2.push(40);
        p2.push(50);

        p1.concatenar(p2);
        System.out.println(p1.toString());
    }

}
