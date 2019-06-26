package Lista05;

public class ListaDupla<T> {

    private NoListaDupla<T> primeiro;

    public void ListaDupla(){

    }

    public NoListaDupla<T> getPrimeiro(){
        return primeiro;
    }

    public ListaDupla<T> clonar() {
        ListaDupla<T> listaClone = new ListaDupla<T>();
        //percorrer a lista, chegar no final, adicionar os nos conforme for passando a lista de volta

        NoListaDupla<T> cursor = primeiro;
        if(cursor != null) {
            while(cursor.getProximo() != null) {
                cursor = cursor.getProximo();
            }

            while(cursor != null){
                listaClone.inserir(cursor.getInfo());
                cursor = cursor.getAnterior();
            }
        }

        return listaClone;
    }

    public void inserir(T valor){
        NoListaDupla<T> novo = new NoListaDupla<T>();
        novo.setInfo(valor);
        novo.setProximo(primeiro);
        novo.setAnterior(null);

        if(primeiro != null){
            primeiro.setAnterior(novo);
        }

        primeiro = novo;

    }

    public NoListaDupla<T> buscar(T valor){

        NoListaDupla<T> cursor = primeiro;
        while (cursor != null) {

            if(cursor.getInfo()== valor){
                return cursor;
            } else {
                cursor = cursor.getProximo();
            }
        }

        return null;
    }

    public void retirar(T valor){

        NoListaDupla<T> cursor = buscar(valor);

        if(cursor != null){
            if(cursor == primeiro){
                primeiro = cursor.getProximo();
            } else {
                cursor.getAnterior().setProximo(cursor.getProximo());
            }

            if(cursor.getProximo() != null){
                cursor.getProximo().setAnterior(cursor.getAnterior());
            }
        }
    }

    public void exibirOrdemInversa(){
        String retorno = "";
        NoListaDupla<T> cursor = primeiro;
        if(cursor != null){
            while (cursor.getProximo() != null){
                cursor = cursor.getProximo();
            }

            while(cursor != null){
                retorno += cursor.getInfo();
                if(cursor.getAnterior() != null){
                    retorno += ", ";
                }
                cursor = cursor.getAnterior();
            }
            System.out.println(retorno);
        } else {
            System.out.println("Lista vazia");
        }
    }

    public void liberar(){
        NoListaDupla<T> cursor = primeiro;

        while(cursor != null){
            NoListaDupla<T> atual = cursor;
            cursor = cursor.getProximo();
            atual.setAnterior(null);
            atual.setProximo(null);
        }
        primeiro = null;

    }

    @Override
    public String toString(){
        String retorno = "";
        NoListaDupla<T> cursor = primeiro;
        if(cursor != null){
            while(cursor != null){
                retorno += cursor.getInfo();
                if(cursor.getProximo() != null){
                    retorno += ", ";
                }
                cursor = cursor.getProximo();
            }
            return retorno;
        }
        return "Lista vazia";
    }

}
