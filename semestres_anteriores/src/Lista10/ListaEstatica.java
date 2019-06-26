package Lista10;

public class ListaEstatica<T> extends ListaAbstract<T> {



    //gilvan
    public void inserir(T dado) {
        if(getTamanho() == getLimite()){
           // redimencionar();
        }

        T[] info = getInfo();
        info[getTamanho()] = dado;
        setTamanho(getTamanho()+1);

    }
//    meu
//    public void inserir(T dado) {
//        if (getTamanho() == getInfo().length) {
//            redimencionar();
//        }
//
//        getInfo()[getTamanho()] = dado;
//        setTamanho(getTamanho() + 1);
//
//    }


//    gilvan
    public int buscar(T dado){
        T[] info = getInfo();

        for (int i =0;  i< getTamanho(); i++){
            if(info[i].equals(dado)){
                return i;
            }
        }

        return -1;
    }

//    meu
//    public int buscar(T dado) {
//        for (int i = 0; i < getInfo().length; i++) {
//            if (getInfo()[i] == dado) {
//                return i;
//            }
//        }
//        return -1;
//    }


}
