package Prova1;

public class ListaDupla<T> {

    private NoListaDupla<T> primeiro;
    private int qtdNos;

    public static void main(String[] args) {
        ListaDuplaTests tests = new ListaDuplaTests();

        tests.caso1();
    }

    public ListaDupla<T> clonar(){
        ListaDupla novaLista = new ListaDupla<>();

        NoListaDupla<T> no = this.primeiro;
        int idx = 0;

        while(no != null){
            if(idx >= 0 && idx <= this.getLength()){
                novaLista.inserir(no.getInfo());
            }

            no = no.getProximo();
            idx++;
        }

        return novaLista;
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

    public String exibir(){
        NoListaDupla p  = primeiro;
        String msg = "";

        while (p != null) {
            msg += p.getInfo().toString() + "\n";
            p = p.getProximo();
        }
        return msg;
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
