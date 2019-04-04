package br.furb.prova1_semestres_anteriores;

public class Prova_01 {
    public static void main(String[] args) {


        Lista<Aluno> lista = new Lista();

        Aluno obj0 = new Aluno(20000);
        lista.inserir(0, obj0);

        Aluno obj1 = new Aluno(11123453);
        lista.inserir(1, obj1);

        Aluno obj2 = new Aluno(2226754);
        lista.inserir(2, obj2);

        Aluno obj3 = new Aluno(333555);
        lista.inserir(3, obj3);

        Aluno obj4 = new Aluno(4446675);
        lista.inserir(4, obj4);

        Aluno obj5 = new Aluno(555342);
        lista.inserir(5, obj5);



        //lista.retirarTodos(obj2);

        // lista.retirarTodos(obj4);


        System.out.println( lista.exibir() );

        System.out.println( "\n\n" );

        System.out.println( lista.criarListaSubLista(2, 4).exibir() );



    }
}
