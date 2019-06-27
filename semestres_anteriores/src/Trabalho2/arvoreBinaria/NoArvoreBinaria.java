package Trabalho2.arvoreBinaria;

public class NoArvoreBinaria<T> {

    private T info;
    private NoArvoreBinaria<T> esquerda;
    private NoArvoreBinaria<T> direita;

    public NoArvoreBinaria(T info) {
        this.info = info;
        esquerda = null;
        direita = null;
    }

    /*
    Cria um novo nó com sub-árvores pré estabelecidas
    @param info Valor armazenado pelo nó
    @param esq Sub-arvore à esquerda
    @param dir Sub-arvore à direita
     */
    public NoArvoreBinaria(T info, NoArvoreBinaria<T> esq, NoArvoreBinaria<T> dir) {
        this.info = info;
        esquerda = esq;
        direita = dir;
    }

    /*
    Valor armazenado pelo nó
     */
    public T getInfo() {
        return info;
    }

    public void setInfo(T info) {
        this.info = info;
    }

    /*
    Sub árvore à esquerda
     */
    public NoArvoreBinaria<T> getEsquerda() {
        return esquerda;
    }

    public void setEsquerda(NoArvoreBinaria<T> esquerda) {
        this.esquerda = esquerda;
    }

    /*
    Sub árvore à direita
     */
    public NoArvoreBinaria<T> getDireita() {
        return direita;
    }

    public void setDireita(NoArvoreBinaria<T> direita) {
        this.direita = direita;
    }

}
