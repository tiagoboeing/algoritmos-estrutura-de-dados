package br.furb.listas;

import br.furb.model.NoListaDupla;

public class ListaDupla<T> {

    private NoListaDupla<T> primeiro;

    // constructor
    public ListaDupla() {
        primeiro = null;
    }

    public static void main(String[] args) {
        ListaDuplaTests tests = new ListaDuplaTests();

//        tests.caso1();
//        tests.caso2();
//        tests.caso3();
//        tests.caso4();
//        tests.caso5();
//        tests.caso6();
//        tests.caso7();
        tests.inserirPosicao();
    }

    public void inserir(T info){
        NoListaDupla<T> novo = new NoListaDupla<>();
        novo.setInfo(info);
        novo.setProximo(primeiro);
        novo.setAnterior(null);

        if(primeiro != null){
            primeiro.setAnterior(novo);
        }

        primeiro = novo;
    }

    public void inserirIndex(int indice, T info){
        int qtdeNos = this.getLength();

        if (indice >= 0 && indice <= qtdeNos){
            if (indice == qtdeNos) {// ultima posicao
                this.inserir(info);
            }
            else {
                NoListaDupla novo = new NoListaDupla();
                novo.setInfo(info);

                NoListaDupla elemE;

                if (indice == 0){ // primeira posicao
                    novo.setProximo(primeiro);
                    primeiro.setAnterior(novo);
                    primeiro = novo;
                } else { // posicao intermediaria
                    elemE = this.obterNo(indice);
                    novo.setProximo(elemE.getProximo());
                    novo.setAnterior(elemE);
                    novo.getProximo().setAnterior(novo);
                    elemE.setProximo(novo);
                }
            }
        }
    }

    public void exibir(){
        NoListaDupla<T> p = primeiro;

        while(p != null){
            System.out.println(p.getInfo());

            p = p.getProximo();
        }
    }

    public boolean estaVazia(){
        return primeiro == null;
    }

    public NoListaDupla<T> buscar(T info){
        NoListaDupla<T> p = primeiro;

        while(p != null){
            if(p.getInfo().equals(info)){
                return p;
            }
            p = p.getProximo();
        }
        return null;
    }

    public void retirar(T info){
        /*
        NoListaDupla<T> anterior = null;
        NoListaDupla<T> p = primeiro;

        while((p != null) && (!p.getInfo().equals(info))){
            anterior = p;
            p = p.getProximo();
        }

        if(p != null){
            if(anterior == null){ // é o primeiro caso?
                this.primeiro = p.getProximo();
            } else {
                anterior.setProximo(p.getProximo());
            }
        }
        */

        // Com algoritmo de busca
        NoListaDupla<T> p = buscar(info);

        if(p != null){
            // é o primeiro nó?
            if(primeiro == p){
                primeiro = p.getProximo();
            } else {
                p.getAnterior().setProximo(p.getProximo());
            }
        }
        // caso não seja último nó da lista
        if(p.getProximo() != null){
            p.getProximo().setAnterior(p.getAnterior());
        }
    }

    public NoListaDupla<T> obterUltimo(){
        NoListaDupla<T> ultimo = primeiro;
        NoListaDupla<T> p = primeiro;

        while (p != null){
            ultimo = p;
            p = p.getProximo();
        }
        return ultimo;
    }

    public void ordemInversa(){
        NoListaDupla<T> p = obterUltimo();

        while(p != null){
            System.out.println(p.getInfo());
            p = p.getAnterior();
        }
    }

    public int getLength(){
        int qtdeNos = 0;

        NoListaDupla<T> p = primeiro;
        while(p != null){
            qtdeNos++;
            p = p.getProximo();
        }
        return qtdeNos;
    }

    public NoListaDupla<T> obterNo(int index){
        if(index < 0){
            throw new IndexOutOfBoundsException();
        }

        NoListaDupla<T> p = getPrimeiro();
        for(int i = 0; (p != null) && (i < index); i++){
            p = p.getProximo();
        }

        if(p == null){
            throw new IndexOutOfBoundsException();
        }
        return p;
    }

    public void liberar(){
        NoListaDupla<T> p = primeiro;
        NoListaDupla<T> save;

        while(p != null){
            save = p.getProximo();
            p.setAnterior(null);
            p.setProximo(null);
            p = save;
        }
        primeiro = null;


        /*
        NoListaDupla<T> p = primeiro;

        while(p != null){
            p.setAnterior(null);
            p = p.getProximo();

            // se não for final da lista e nem o primeiro
            // atualiza a referência 'próximo' do nó anterior
            if((p != null) && (p.getAnterior() != null)){
                p.getAnterior().setProximo(null);
            }
        }
        primeiro = null;
        */
    }

    @Override
    public String toString(){
        NoListaDupla<T> p = primeiro;
        String msg = "";

        while (p != null){
            msg = msg != "" ? (msg + ", " + p.getInfo()) : (msg + p.getInfo());
            p = p.getProximo();
        }
        return msg;
    }

    public NoListaDupla<T> getPrimeiro() {
        return primeiro;
    }
}
