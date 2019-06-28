package Questao2.mapa;

import java.time.LocalDate;
import Questao2.lista.Lista;
import Questao2.lista.NoLista;

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

    private int calcularHash(int chave) {
        return (chave % info.length);
    }

    public void inserir(int chave, T dado) {
        int indice = calcularHash(chave);

        if (info[indice] == null) {
            info[indice] = new Lista<>();
        }
        NoMapa<T> no = new NoMapa<>();
        no.setChave(chave);
        no.setInfo(dado);

        info[indice].inserir(no);
    }

    public void retirar(int chave) {
        int indice = calcularHash(chave);

        if (info[indice] != null) {
            NoMapa<T> no = new NoMapa<>();
            no.setChave(chave);
            info[indice].retirar(no);
        }
    }

    public T buscar(int chave) {
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

    public int calcularQtdeObjetos() {

        int qtdeObjetos = 0;

        for (int i = 0; i < getInfo().length; i++) {
            if (info[i] != null) {
                qtdeObjetos += this.info[i].obterComprimento();
            }

        }

        return qtdeObjetos;
    }

    public double fatorCarga() {
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
