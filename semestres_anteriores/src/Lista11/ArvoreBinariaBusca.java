package Lista11;

public class ArvoreBinariaBusca<T extends Comparable<T>> extends
        ArvoreBinariaAbstract<T> {

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

        NoArvoreBinaria<T> p;

        p = getRaiz();

        //while ((p != null) && (!p.getInfo().equals(info))) {
        while ((p != null) && (!p.getInfo().equals(info))) {
            if (info.compareTo(p.getInfo()) < 0) {
                p = p.getEsquerda();
            } else {
                p = p.getDireita();
            }
        }
        return p;
    }

    public NoArvoreBinaria<T> buscarRecursivo(T info) {
        return buscarRecursivo(getRaiz(), info);
    }

    private NoArvoreBinaria<T> buscarRecursivo(NoArvoreBinaria<T> p, T info) {

        if (p == null) {
            return null;
        }
        if (info == p.getInfo()) {
            return p;
        } else {
            if (info.compareTo(p.getInfo()) < 0) {
                return buscarRecursivo(p.getEsquerda(), info);
            } else {
                return buscarRecursivo(p.getDireita(), info);
            }
        }
    }

    @Override
    public boolean equals(Object obj) {
        // TODO Auto-generated method stub
        return super.equals(obj);
    }

    public void retirar(T info) {
        NoArvoreBinaria<T> p = getRaiz();
        NoArvoreBinaria<T> pai = null;
        boolean filhoEsquerda = false;

        // localizar o nó a ser removido
        while ((p != null) && (!p.getInfo().equals(info))) {
            // while ((p != null) && (p.getInfo().equals(info))) {
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
                // 1* caso
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
                    // nó com apenas um filho a esquerda
                    // 2*caso
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
                        // nó com apenas um filho a direita
                        // 2* caso
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
                        // 3* caso
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
        NoArvoreBinaria<T> sucessor = excluir;//p

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
