package Prova1;

public class ListaEstaticaTests extends ListaEstatica {

    public void caso1(){
        this.inserir(20);
        this.inserir(25);
        this.inserir(30);

        // adiciona novo dado de forma desordenada
        this.inserir(22);

        this.exibir();
    }

}
