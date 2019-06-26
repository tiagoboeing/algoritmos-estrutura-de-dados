package Lista07;


public class ListaEncadeada<T> {

    private NoLista<T> primeiro;
    private NoLista<T> ultimo;

    public ListaEncadeada() {
        primeiro = null;
        ultimo = null;
    }

    public NoLista<T> getPrimeiro() {
        return primeiro;
    }

    public void inserir(T info) {


        NoLista<T> nl = new NoLista<T>();
        nl.setInfo(info);

        if (estaVazia()) {
            primeiro = nl;
        } else {
            nl.setProximo(primeiro);
            primeiro = nl;
        }

    }

    public void inserirNoFinal(T info) {
        NoLista<T> nl = new NoLista<T>();
        nl.setInfo(info);
        nl.setProximo(null);

        if(estaVazia()){
            primeiro = nl;
        } else {
            ultimo.setProximo(nl);
        }

        ultimo = nl;

    }

    public boolean estaVazia() {
        if (primeiro == null) {
            return true;
        }
        return false;
    }

    public NoLista<T> buscar(T info) {

        if (!estaVazia()) {
            NoLista<T> cursor = primeiro;

            while (cursor != null) {
                if(cursor.getInfo()== info){
                    return cursor;
                } else {
                    cursor = cursor.getProximo();
                }
                
            }
        } 
        
        return null;
    }
    
    public void retirar(T info){
        
        if(!estaVazia()){
            NoLista<T> cursor = primeiro;
            NoLista<T> anterior = null;
            
            while(cursor != null && cursor.getInfo() != info){
                anterior = cursor;
                cursor = cursor.getProximo();
            }
            
            
            if(cursor != null){
                if(anterior == null){
                    this.primeiro = cursor.getProximo();
                } else {
                    anterior.setProximo(cursor.getProximo());
                }
            }
            
        }
    }
    
    public int obterComprimento(){
        if(!estaVazia()){
            int total = 0;
            NoLista<T> cursor = primeiro;
            while(cursor != null){
                total++;
                cursor = cursor.getProximo();
            }
            return total;
        }
        
        return 0;
    }
    
    public NoLista<T> obterNo(int idx){
        
        if(idx < 0) throw new IndexOutOfBoundsException();
        
        NoLista<T> cursor = primeiro;

        for (int i = 0; i < idx; i++) {
            if(cursor == null){
                throw new IndexOutOfBoundsException();
            }

            cursor = cursor.getProximo();
        }

        return cursor;
        
    }

    @Override
    public String toString(){
        NoLista<T> cursor = primeiro;
        String retorno = "";
        while(cursor != null){
            retorno += cursor.getInfo();
            cursor = cursor.getProximo();
            if(cursor != null) retorno += ", ";
        }
        return retorno;
    }
    
    
}
