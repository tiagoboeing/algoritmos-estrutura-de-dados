package Trabalho2.huffman;

import Trabalho2.arvoreBinaria.ArvoreBinaria;
import Trabalho2.arvoreBinaria.NoArvoreBinaria;
import Trabalho2.lista.PesoCaractere;

public class ArvoreBinariaHuffman extends ArvoreBinaria<PesoCaractere> implements Comparable<ArvoreBinariaHuffman> {

    @Override
    public int compareTo(ArvoreBinariaHuffman o) {

        if (getRaiz().getInfo().getPeso() < o.getRaiz().getInfo().getPeso()) {

            return -1;
        }

        if (getRaiz().getInfo().getPeso() > o.getRaiz().getInfo().getPeso()) {

            return 1;
        }

        return 0;
    }

    public String buscarBinario(PesoCaractere info, ArvoreBinariaHuffman arvoreFinal) {

        String tempBinario = "";

        NoArvoreBinaria<PesoCaractere> p = arvoreFinal.getRaiz();

        while (p != null && !p.getInfo().equals(info)) {
            if (info.getCaractere() != p.getInfo().getCaractere()) {
                p = p.getEsquerda();
                tempBinario = tempBinario + "0";
            } else {
                p = p.getDireita();
                tempBinario = tempBinario + "1";
            }
        }
        return tempBinario;
    }

}
