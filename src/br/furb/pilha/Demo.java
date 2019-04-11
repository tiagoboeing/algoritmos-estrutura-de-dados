package br.furb.pilha;

public class Demo {

    public static void main(String[] args) {
           Pilha p = new PilhaVetor(10);
           p.push(10);
           p.push(20);
           p.push(30);
           p.push(40);
           p.pop();
           p.pop();
           p.push(p.peek());
           p.push(50);
           System.out.println(p.toString());
    }

}
