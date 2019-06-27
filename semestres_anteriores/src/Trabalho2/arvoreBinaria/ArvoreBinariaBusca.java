package Trabalho2.arvoreBinaria;

public class ArvoreBinariaBusca<T extends Comparable<T>>
        extends ArvoreBinariaAbstract<T> {

    /*
    compareTo: cair na prova
    Insere um novo nó na árvore binária
    @param info
     */
    public void inserir(T info) {
        NoArvoreBinaria<T> novo = new NoArvoreBinaria<T>(info);

        if (estaVazia()) {
            setRaiz(novo);
        } else {
            NoArvoreBinaria<T> p = getRaiz();
            NoArvoreBinaria<T> pai;

            while (true) {
                pai = p;

                if (info.compareTo(p.getInfo()) < 0) {
                    p = pai.getEsquerda();
                    if (p == null) {
                        pai.setEsquerda(novo);
                        return;
                    }
                } else {
                    p = p.getDireita();
                    if (p == null) {
                        pai.setDireita(novo);
                        return;
                    }
                }
            }
        }
    }

    /*
    Retorna o nó que contém o dado fornecido como argumento
    @param info dado a ser pesquisado
    @return nó localizado
     */
    public NoArvoreBinaria<T> buscar(T info) {
        NoArvoreBinaria<T> novo = new NoArvoreBinaria<T>(info);

        NoArvoreBinaria<T> p = getRaiz();
        
        while (p != null && !p.getInfo().equals(info)) {
            if (info.compareTo(p.getInfo()) < 0) {
                p = p.getEsquerda();
            } else {
                p = p.getDireita();
            }
        }
        return p;
    }

    @Override
    public boolean equals(Object obj) {
        // TODO Auto-generated method stub
        return super.equals(obj);
    }

    public void retirar(T info) {
        NoArvoreBinaria<T> novo = new NoArvoreBinaria<T>(info);

        NoArvoreBinaria<T> p = getRaiz();

        NoArvoreBinaria<T> pai = null;
        boolean filhoEsquerda = false;

        // localiza o nó a ser removido
        //além de rodar o método buscar, queremos atribuir conteúdo à variável pai,
        //e saber se o filho está na direita ou na esquerda.
        while ((p != null) && (p.getInfo().equals(info))) {
            pai = p;

            if (info.compareTo(p.getInfo()) < 0) {
                filhoEsquerda = true;
                p = p.getEsquerda();
            } else {
                filhoEsquerda = false;
                p = p.getDireita();
            }
        }

        if (p != null) {// acha o dado a ser removido?
            // avalia se é nó folha
            if ((p.getEsquerda() == null) && (p.getDireita() == null)) {
                // 1o caso
                if (p == getRaiz()) {
                    setRaiz(null);
                } else {
                    if (filhoEsquerda) {
                        pai.setEsquerda(null);
                    } else {
                        pai.setDireita(null);
                    }
                }
            } else {
                if (p.getDireita() == null) {
                    // nó com apenas um filho à esquerda
                    // 2o caso
                    if (p == getRaiz()) {
                        setRaiz(p.getEsquerda());
                    } else {
                        if (filhoEsquerda) {
                            pai.setEsquerda(p.getEsquerda());
                        } else {
                            pai.setDireita(p.getEsquerda());
                        }
                    }
                } else {
                    if (p.getEsquerda() == null) {
                        // nó com apenas um filho à direita
                        // 2o caso
                        if (p == getRaiz()) {
                            setRaiz(p.getDireita());
                        } else {
                            if (filhoEsquerda) {
                                pai.setEsquerda(p.getDireita());
                            } else {
                                pai.setDireita(p.getDireita());
                            }
                        }
                    } else {
                        // nó com filho a esquerda e a direita
                        // 3o caso
                        NoArvoreBinaria<T> sucessor = extrairSucessor(p);
                        if (p == getRaiz()) {
                            setRaiz(sucessor);
                        } else {
                            if (filhoEsquerda) {
                                pai.setEsquerda(sucessor);
                            } else {
                                pai.setDireita(sucessor);
                            }
                        }
                        sucessor.setEsquerda(p.getEsquerda());
                    }
                }
            }
        }
    }

    private NoArvoreBinaria<T> extrairSucessor(NoArvoreBinaria<T> excluir) {
        NoArvoreBinaria<T> p = excluir.getDireita();
        NoArvoreBinaria<T> paiSucessor = excluir;
        NoArvoreBinaria<T> sucessor = p;

        while (p != null) {
            paiSucessor = sucessor;
            sucessor = p;
            p = p.getEsquerda();

        }

        if (sucessor != excluir.getDireita()) {
            paiSucessor.setEsquerda(sucessor.getDireita());
            sucessor.setDireita(excluir.getDireita());
        }
        return sucessor;

    }

}
