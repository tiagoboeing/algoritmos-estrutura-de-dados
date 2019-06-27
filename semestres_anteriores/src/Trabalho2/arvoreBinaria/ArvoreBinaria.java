package Trabalho2.arvoreBinaria;

import Trabalho2.lista.PesoCaractere;

public class ArvoreBinaria<T> extends ArvoreBinariaAbstract<T> {

    NoArvoreBinaria<T> raiz;

    /*
    Cria uma árvore vazia
     */
    public ArvoreBinaria() {
        raiz = null;
    }

    public void setRaiz(NoArvoreBinaria<T> raiz) {
        this.raiz = raiz;
    }

    public NoArvoreBinaria<T> getRaiz() {
        return raiz;
    }

    public NoArvoreBinaria<T> buscar(T info) {
        return buscar(getRaiz(), info);
    }

    private NoArvoreBinaria<T> buscar(NoArvoreBinaria<T> no, T info) {
        if (no == null) {
            return null;
        } else {
            if (no.getInfo().equals(info)) {
                return no;
            } else {
                NoArvoreBinaria<T> aux;
                aux = buscar(no.getEsquerda(), info);
                if (aux == null) {
                    aux = buscar(no.getDireita(), info);
                }
                return aux;
            }
        }
    }

    /*
    Avalia se a árvore está vazia
    @return True se a árvore estiver vazia, senão false
     */
    public boolean estaVazia() {
        return (raiz == null);
    }

    /*
    Avalia se um determinado dado está armazenado na árvore
    Inicia a busca, partindo da raiz da árvore
    @param indo valor a ser pesquisado
    @return True se o dados for localizado
     */
    public boolean pertence(T info) {
        return pertence(raiz, info);
    }

    /*
    Avalia se um dado pertence a árvore cuja raiz é fornecida como argumento
    @param no Nó raiz a ser pesquisado
    @param info Dado a ser procurado na árvore
    @return True se o dado foi localizado na árvore
    
    Percurso de visitação dos nós: pré ordem
    
    Ordem de Complexidade Linear: visita o nó uma vez só
    Melhor caso: nó a ser encontrado está na raiz
    Pior caso: nó a ser encontrado está na última posição, todos os nós são visitados
     */
    private boolean pertence(NoArvoreBinaria<T> no, T info) {
        if (no == null) {
            return false;
        } else {
            return (no.getInfo().equals(info))
                    || pertence(no.getEsquerda(), info)
                    || pertence(no.getDireita(), info);
        }

        /*            if (no == null) {
                return false;

            } else {
                if (no.getInfo().equals(info)) {
                    return true;
                } else {
                    if pertence(no.getEsquerda(), info)) {
                        return true;
                    } else {
                        return (pertence(no.getDireita(), info))
                    }
                }

            }
        }
         */
    }

    private String arvorePre(NoArvoreBinaria<T> no) {
        if (no == null) {
            return "<>";
        } else {
            return "<"
                    + no.getInfo()
                    + arvorePre(no.getEsquerda())
                    + arvorePre(no.getDireita())
                    + ">";
        }
    }

    @Override
    public String toString() {
        return arvorePre(raiz);
    }

    public int contarNos() {
        return contarNos(raiz);
    }

    private int contarNos(NoArvoreBinaria<T> no) {
        if (no == null) {
            return 0;
        } else {
            return 1 + contarNos(no.getEsquerda())
                    + contarNos(no.getDireita());
        }
    }

    public int contarFolhas() {
        return contarFolhas(raiz);
    }

    private int contarFolhas(NoArvoreBinaria<T> no) {
        int contador = 0;
        if (no == null) {
            return 0;
        } else if (no.getDireita() == null && no.getEsquerda() == null) {
            contador++;
        }

        return contador + contarFolhas(no.getEsquerda())
                + contarFolhas(no.getDireita());
    }

    public boolean ehFolha(NoArvoreBinaria<PesoCaractere> p) {
        if (p.getDireita() == null && p.getEsquerda() == null) {
            return true;
        } else {
            return false;
        }
    }

}
