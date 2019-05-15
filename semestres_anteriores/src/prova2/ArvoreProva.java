package prova2;

public class ArvoreProva<Integer> extends Arvore<Integer> {

    public int somarPares() {
        // implementar aqui o método para calcular
        // a soma dos valores dos nós que armazenam
        // número par. 
        // ArvoreProva é uma árvore n-ária

        // outros métodos (privados) podem ser implementados
        if (raiz == null) {
            return 0;
        } else {
            return somarPares(getRaiz());
        }
    }

    private int somarPares(NoArvore<Integer> no) {
        int soma = 0;

        NoArvore<Integer> p = no.getPrimeiro();

        if (no.getInfo() % 2 == 0) {
            soma = soma + no.getInfo();
        }

        while (p != null) {

            soma = soma + somarPares(p);
            p = p.getProximo();
        }

        return soma;
    }

}
