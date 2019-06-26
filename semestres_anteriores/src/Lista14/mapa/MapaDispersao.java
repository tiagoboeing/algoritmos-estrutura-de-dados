package Lista14.mapa;

import java.time.LocalDate;
import lista.*;

public class MapaDispersao<T> {

    private Lista<NoMapa<T>>[] info;

    public Lista<NoMapa<T>>[] getInfo() {
        return info;
    }

    public void setInfo(Lista<NoMapa<T>>[] info) {
        this.info = info;
    }

    public MapaDispersao(int tamanho) {
        info = new Lista[tamanho];
    }

    /*
    Implmenta a função do hash, que é responsavel por identificar
    em que posição do vetor o objeto deve constar ou ser armazenado
    @param dado Objeto a se calcular o hash
    @return Hash calculado
     */
    private int calcularHash(int chave) {
        //compacta
        return (chave % info.length);
    }

    public void inserir(int chave, T dado) {
        int indice = calcularHash(chave);

        //a posicao está vaga? se sim, cria lista
        if (info[indice] == null) {
            info[indice] = new Lista<>();
        }
        NoMapa<T> no = new NoMapa<>();
        no.setChave(chave);
        no.setInfo(dado);

        info[indice].inserir(no);
    }

    /*
    Remove um objeto do mapa. O objeto fornecido como argumento
    deve ter a chave de busca informada
    @param dado Objeto que contém a chave de busca do objeto a ser retirado
     */
    public void retirar(int chave) {
        int indice = calcularHash(chave);

        if (info[indice] != null) {
            NoMapa<T> no = new NoMapa<>();
            no.setChave(chave);
            info[indice].retirar(no);
        }
    }

    /*
    Busca um objeto na memória. O objeto deve conter a chave de
    e o objeto armazenado com a mesma chave será buscada
    @param dado Objeto que contém a chave de busca do objeto
     */
    public T buscar(int chave) {
        // Ordem de complexidade O(1)
        // No pior caso O(n)
        int indice = calcularHash(chave);

        if (info[indice] != null) {
            NoMapa<T> noMapa = new NoMapa<>();
            noMapa.setChave(chave);

            NoLista<NoMapa<T>> no;
            no = info[indice].buscar(noMapa);
            if (no != null) {
                return no.getInfo().getInfo();
            }
        }
        return null;
    }

    /*
    Este método deve calcular quantos objetos foram armazenados no mapa de
    dispersão. Lembre-se que não é aceitável incluir novos atributos na classe
    MapaDispersao.
     */
    public int calcularQtdeObjetos() {

        int qtdeObjetos = 0;

        for (int i = 0; i < getInfo().length; i++) {
            if (info[i] != null) {
                qtdeObjetos += this.info[i].obterComprimento();
            }

        }

        return qtdeObjetos;
    }

    /*
    Este método deverá redimensionar a tabela para que tenha um novo tamanho
    (fornecido como argumento para o método). O método deve realocar um novo
    vetor como o tamanho especificado e transferir os objetos armazenados no
    vetor original para o novo vetor. Observar que os objetos poderão ocupar uma
    nova posição no vetor novo, pois você precisará recalcular o novo hash para
    cada objeto e armazenar na posição correspondente. Ao final do processo, o
    atributo info da classe MapaDispersao deve referenciar o novo vetor
     */
    public MapaDispersao<Lista<Aluno>> realocarMapa(int novoTamanho) {
        MapaDispersao<Lista<Aluno>> novo = new MapaDispersao(novoTamanho);
        int hashTemp;
        String nomeTemp;
        LocalDate dataTemp;

        for (int i = 0; i < getInfo().length; i++) {
            if (info[i] != null) {
                for (int j = 0; j < info[i].obterComprimento(); j++) {

                    System.out.println(info[i].getNo(j).getInfo().getChave());
                    //System.out.println(info[i].getNo(j).getInfo().getInfo());
                    
                    //busca a chave dos objetos do mapa e calcula o hash novo
                    hashTemp = ((info[i].getNo(j).getInfo().getChave()) % novo.info.length);

                    Lista<Aluno> listaAluno = new Lista();
                    Aluno aluno = new Aluno();
                    NoMapa<T> no = new NoMapa<>();

                    //seta a matricula do aluno conforme chave buscada
                    aluno.setMatricula(info[i].getNo(j).getInfo().getChave());
                    
                    //busca campos do aluno pela chave
                    //System.out.println(this.buscar(info[i].getNo(j).getInfo().getChave()));
                    
                    //nomeTemp = listaAluno.buscar(aluno).getInfo().getNome();
                    //dataTemp = listaAluno.buscar(aluno).getInfo().getDataNascimento();

                    listaAluno.inserir(aluno);

                    novo.inserir(hashTemp, listaAluno);
                }
            }
        }

        return novo;
    }

    public double calcularFatorCarga() {
        int tamanho = this.info.length;
        int contador = 0;

        for (int i = 0; i < getInfo().length; i++) {
            if (this.info[i] != null) {
                contador += this.info[i].obterComprimento();
            }
        }
        double calcularFatorCarga = (double) contador / tamanho;

        return calcularFatorCarga;
    }

}
