package listas;

public class ListaEstaticaGenericaTests extends ListaEstaticaGenerica{

    public ListaEstaticaGenericaTests(){
        super();

        this.inserir(5);
        this.inserir(10);
        this.inserir(15);
        this.inserir(20);
    }


    /*
     * Testar método de inclusão de dados na lista
     * toString() deve resultar em “5,10,15,20”
     */
    public void caso1(){
        System.out.println(this.toString());
    }

    /*
     * Testar método de obtenção de tamanho da lista
     * getTamanho() deve resultar em 4
     */
    public void caso2(){
        System.out.println(this.getTamanho());
    }

    /*
     * Testar método buscar() com elemento existente
     * buscar(15) deve resultar em 2.
     */
    public void caso3(){
        System.out.println(this.buscar(15));
    }

    /*
     * Testar método buscar() com elemento inexistente
     * buscar(30) deve resultar em -1.
     */
    public void caso4(){
        System.out.println(this.buscar(30));
    }

    /*
     * Testar método retirar()
     * Criar uma lista. Adicionar os dados 5, 10, 15 e 20, nesta ordem.
     * Em seguida, retirar o elemento 10 – retirar(10).
     *
     * toString() deve resultar em “5 15 20”.
     * getTamanho() deve resultar em 3.
     */
    public void caso5(){
        this.liberar();
        this.inserir(5);
        this.inserir(15);
        this.inserir(20);

        System.out.println(this.toString());

        this.retirar(10);
        System.out.println(this.getTamanho());
    }

    /*
     * Testar inclusão que provoque redimensionamento
     * Criar uma lista. Adicionar 15 números na lista (de 1 à 15).
     *
     * toString() deve resultar em “1 2 3 4 5 6 7 8 9 10 11 12 13 14 15”.
     * getTamanho() deve resultar em 15.
     */
    public void caso6(){
        this.liberar();
        for (int i = 1; i <= 15; i++){
            this.inserir(i);
        }
        System.out.println(this.toString());
        System.out.println(this.getTamanho());
    }


    /*
    * Testar método obterElemento()
    * obterElemento(3) deverá resultar em 20.
    */
    public void caso7(){
        System.out.println(this.obterElemento(3));
    }

    /*
    * Testar lançamento de exceção no método getElemento()
    * obterElemento(5) deverá lançar uma exceção.
    */
    public void caso8(){
        System.out.println(this.obterElemento(5));
    }

    /*
    * Certificar que liberar() remove todos os elementos
    * Criar uma lista. Adicionar os dados 5, 10, 15 e 20. Invocar o método liberar().
    * estaVazia() deverá resultar em true.
    */
    public void caso9(){
        this.liberar();
        System.out.println(this.estaVazia());
    }

}
