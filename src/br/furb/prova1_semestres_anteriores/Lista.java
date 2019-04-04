package br.furb.prova1_semestres_anteriores;

public class Lista <T extends Comparable <T>>{
    private NoLista primeiro;
    private int qtdNos;

    public Lista(){
        primeiro = null;
        qtdNos = 0;
    }

    public boolean estaVazia() {
        return (qtdNos == 0);
    }

    protected NoLista consultaInterno(int p){
        if (p >= 0 && p < this.qtdNos){  // posição procurada é válida
            NoLista proximo = primeiro;

            for (int i=0; i < p; i++){
                proximo = proximo.getProximo();
            }
            return proximo;
        } else {
            return null;
        }

    }

    public String exibir() {
        // Imprimi na ordem inversa da ordem que foram adicionados

        NoLista p  = primeiro;
        String str = "";

        while (p != null) {
            str += p.getInfo().toString();
            str += '\n';

            p = p.getProximo();
        }

        return str;
    }

    public void inserir(T objInfo) {

        NoLista objNovo = new NoLista();

        objNovo.setInfo(objInfo);

        if (this.estaVazia()){
            primeiro = objNovo;
        } else {
            objNovo.setProximo(primeiro);
            this.primeiro = objNovo;
        }

        qtdNos++;
    }

    public void retirar(Object objInfo) {

        NoLista anterior = null;
        NoLista p = primeiro;

        while ( (p != null) && (!p.getInfo().equals(objInfo)) ) {
            anterior = p;
            p = p.getProximo();
        }

        if (p != null) {
            if (anterior == null){
                this.primeiro = p.getProximo();
            }else{
                anterior.setProximo(p.getProximo());
            }

            qtdNos--;
        }
    }

    // -------------------------------------------
    public void inserir(int indice, T info){

        if (indice >= 0 && indice <= this.qtdNos){
            if (indice == this.qtdNos) {// ultima posicao
                this.inserir(info);
            }
            else {
                NoLista novo = new NoLista();
                novo.setInfo(info);

                NoLista elemE;

                if (indice == 0){ // primeira posicao
                    novo.setProximo(primeiro);
                    primeiro.setAnterior(novo);
                    primeiro = novo;
                } else { // posicao intermediaria
                    elemE = this.consultaInterno(indice-1);
                    novo.setProximo(elemE.getProximo());
                    novo.setAnterior(elemE);
                    novo.getProximo().setAnterior(novo);
                    elemE.setProximo(novo);
                }
                qtdNos++;
            }
        }
    }


    public void retirarTodos(T valor){
        NoLista anterior = null;
        NoLista p = primeiro;

        while (p != null) {

            if(p.getInfo().equals(valor)){

                if(anterior == null){
                    this.primeiro = p.getProximo();
                }else{
                    anterior.setProximo(p.getProximo());
                }

            }else{
                anterior = p;
            }

            p = p.getProximo();
        }
    }


    public Lista<T> criarListaSubLista(int inicio, int fim){

        if( (inicio < 0) || (fim > this.qtdNos) ){
            throw new IndexOutOfBoundsException();
        }

        Lista novaLista = new Lista<>();

        NoLista<T> no = this.primeiro;
        int idx = 0;

        while(no != null){

            if(idx >= inicio && idx <= fim){
                novaLista.inserir(no.getInfo());
            }

            no = no.getProximo();
            idx++;
        }


        /*
        for(int i = inicio; i <= fim; i++){
          novaLista.inserir((Comparable) this.consultaInterno(i).getInfo());
        } */

        return novaLista;
    }
}
