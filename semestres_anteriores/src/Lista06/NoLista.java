package Lista06;

public class NoLista <T> {
    
    private T info;
    private NoLista<T> proximo;

    public NoLista() {
        this.proximo = null;
    }
    
    public T getInfo(){
        return info;
    }
    
    public void setInfo(T info){
        this.info = info;
    }
    
    public NoLista<T> getProximo(){
        return proximo;
    }
    
    public void setProximo(NoLista<T> proximo){
        this.proximo = proximo;
    }    
    
}
