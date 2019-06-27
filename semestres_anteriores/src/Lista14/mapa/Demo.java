package Lista14.mapa;

import Lista14.lista.Lista;
import java.time.LocalDate;

public class Demo {

    public static void main(String[] args) {
        //new Demo().demo1();
        new Demo().demoRealocarMapa();
    }

    public void demo1() {
        MapaDispersao<Lista<Aluno>> mapa = new MapaDispersao(51);
        Lista<Aluno> listaAluno = new Lista();
        Lista<Aluno> listaAluno2 = new Lista();
        Lista<Aluno> listaAluno3 = new Lista();

        Aluno aluno1 = new Aluno(120000, "Jean", LocalDate.of(2000, 8, 01));
        Aluno aluno2 = new Aluno(120000, "Maria", LocalDate.of(2000, 8, 01));
        Aluno aluno3 = new Aluno(130000, "Joao", LocalDate.of(2000, 8, 01));

        listaAluno.inserir(aluno1);

        listaAluno2.inserir(aluno2);

        listaAluno3.inserir(aluno3);

        mapa.inserir(
                12000, listaAluno);
        mapa.inserir(
                12000, listaAluno2);
        mapa.inserir(
                130000, listaAluno3);

        System.out.println(mapa.calcularQtdeObjetos());
        System.out.println(mapa.calcularFatorCarga());

    }

    public void demoRealocarMapa() {
        MapaDispersao<Lista<Aluno>> mapa = new MapaDispersao(10);
        
        Lista<Aluno> listaAluno = new Lista();
        Lista<Aluno> listaAluno2 = new Lista();
        Lista<Aluno> listaAluno3 = new Lista();

        Aluno aluno1 = new Aluno(120000, "Jean", LocalDate.of(2000, 8, 01));
        Aluno aluno2 = new Aluno(120000, "Maria", LocalDate.of(2000, 8, 01));
        Aluno aluno3 = new Aluno(130000, "Joao", LocalDate.of(2000, 8, 01));

        listaAluno.inserir(aluno1);

        listaAluno2.inserir(aluno2);

        listaAluno3.inserir(aluno3);

        mapa.inserir(12000, listaAluno);
        mapa.inserir(12000, listaAluno2);
        mapa.inserir(130000, listaAluno3);
        
        MapaDispersao<Lista<Aluno>> mapaNovo = mapa.realocarMapa(17);
        
        System.out.println("Quantidade de objetos no mapa: " + mapaNovo.calcularQtdeObjetos());
        System.out.println("Tamanho do mapa: " + mapaNovo.getInfo().length);
    }
}
