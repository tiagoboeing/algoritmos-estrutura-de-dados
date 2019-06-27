//@author Lucas A. W. P. do Nascimento
package Trabalho2.huffman;

import Trabalho2.arvoreBinaria.NoArvoreBinaria;
import Trabalho2.lista.Lista;
import Trabalho2.lista.ListaOrdenada;
import Trabalho2.lista.PesoCaractere;
import Trabalho2.lista.Tabela;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import static java.lang.Integer.parseInt;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Huffman {

    public int contarDistintos(String conteudo) {
        String temp = "";

        for (int i = 0; i < conteudo.length(); i++) {
            if (temp.indexOf(conteudo.charAt(i)) == -1) {
                temp = temp + conteudo.charAt(i);
            }
        }

        return temp.length();
    }

    public char[] caracteresDistintos(String conteudo) {
        String temp = "";

        for (int i = 0; i < conteudo.length(); i++) {
            if (temp.indexOf(conteudo.charAt(i)) == -1) {
                temp = temp + conteudo.charAt(i);
            }
        }
        char[] arrayDistintos = temp.toCharArray();

        return arrayDistintos;
    }

    public int obterPeso(String conteudo, char algarismo) {
        int peso = 0;

        for (int i = 0; i < conteudo.length(); i++) {
            if (conteudo.charAt(i) == algarismo) {
                peso++;
            }
        }
        return peso;
    }

    public ListaOrdenada<ArvoreBinariaHuffman> criarLista(String conteudo) {
        //tirar enter
        conteudo = conteudo.replace("\n", "").replace("\r", "");

        char caracteresDistintos[] = caracteresDistintos(conteudo);

        ListaOrdenada<ArvoreBinariaHuffman> lista = new ListaOrdenada();

        for (int i = 0; i < caracteresDistintos.length; i++) {
            PesoCaractere p = new PesoCaractere();

            int pesoTemp = obterPeso(conteudo, caracteresDistintos[i]);

            p.setCaractere(caracteresDistintos[i]);
            p.setPeso(pesoTemp);

            //System.out.println(caracteresDistintos[i]);
            //System.out.println(pesoTemp);
            NoArvoreBinaria<PesoCaractere> no = new NoArvoreBinaria(p);

            ArvoreBinariaHuffman arvore = new ArvoreBinariaHuffman();

            arvore.setRaiz(no);

            lista.inserir(arvore);
        }
        /*
        System.out.println("Conteudo da lista");
        for (int i = 0; i < lista.getTamanho(); i++) {
            System.out.println("Caractere: " + lista.obterElemento(i).getRaiz().getInfo().getCaractere());
            System.out.println("Peso: " + lista.obterElemento(i).getRaiz().getInfo().getPeso());
        }
         */
        return lista;

    }

    public ArvoreBinariaHuffman montarArvore(ListaOrdenada<ArvoreBinariaHuffman> lista) {

        while (lista.getTamanho() > 1) {
            //System.out.println("tamanho = " + lista.getTamanho());
            //pegue as duas primeiras árvores da lista e as chame de T1 e T2.
            ArvoreBinariaHuffman T1 = lista.obterElemento(0);
            ArvoreBinariaHuffman T2 = lista.obterElemento(1);

            //crie uma nova árvore Tr cuja raiz tenha o peso igual à soma dos pesos de T1 e T2
            ArvoreBinariaHuffman Tr = new ArvoreBinariaHuffman();
            PesoCaractere pRaiz = new PesoCaractere();

            //o peso do Tr será a soma do peso do T1 e T2
            pRaiz.setPeso(T1.getRaiz().getInfo().getPeso() + T2.getRaiz().getInfo().getPeso());

            PesoCaractere pEsquerda = new PesoCaractere();
            pEsquerda.setPeso(T1.getRaiz().getInfo().getPeso());
            pEsquerda.setCaractere(T1.getRaiz().getInfo().getCaractere());

            PesoCaractere pDireita = new PesoCaractere();
            pDireita.setPeso(T2.getRaiz().getInfo().getPeso());
            pDireita.setCaractere(T2.getRaiz().getInfo().getCaractere());

            NoArvoreBinaria<PesoCaractere> noEsquerda = T1.getRaiz();
            NoArvoreBinaria<PesoCaractere> noDireita = T2.getRaiz();
            NoArvoreBinaria<PesoCaractere> noRaiz = new NoArvoreBinaria<>(pRaiz, noEsquerda, noDireita);

            Tr.setRaiz(noRaiz);

            //exclua T1 e T2 da lista (mantendo T1 e T2 na memória)
            lista.retirar(T1);
            lista.retirar(T2);

            //inclua Tr na lista, de maneira que a lista seja mantida ordenada
            lista.inserir(Tr);
        }

        ArvoreBinariaHuffman arvoreFinal = lista.obterElemento(0);

        return arvoreFinal;

    }

    public String escreverArquivo(String diretorio, String conteudo, int qtdDistintos, ArvoreBinariaHuffman arvoreFinal) {
        Huffman h = new Huffman();

        char caracteresDistintos[] = caracteresDistintos(conteudo);
        try {

            PrintWriter out = new PrintWriter(diretorio);
            //quantidade de caracteres mapeados (distintos)
            out.println(qtdDistintos);

            for (int i = 0; i < caracteresDistintos.length; i++) {
                int ascii = (int) caracteresDistintos[i];
                out.print(ascii);
                out.print("=");

                PesoCaractere p = new PesoCaractere();

                //System.out.println(conteudo.charAt(i));
                //System.out.println(h.obterPeso(conteudo, conteudo.charAt(i)));
                p.setCaractere(caracteresDistintos[i]);
                p.setPeso(h.obterPeso(caracteresDistintos.toString(), caracteresDistintos[i]));

                out.println(arvoreFinal.buscarBinario(p, arvoreFinal));
            }

            for (int i = 0; i < conteudo.length(); i++) {
                PesoCaractere p = new PesoCaractere();

                //System.out.println(conteudo.charAt(i));
                //System.out.println(h.obterPeso(conteudo, conteudo.charAt(i)));
                p.setCaractere(conteudo.charAt(i));
                p.setPeso(h.obterPeso(conteudo, conteudo.charAt(i)));

                NoArvoreBinaria<PesoCaractere> no = arvoreFinal.buscar(p);

                if (i == 0) {
                    out.print(arvoreFinal.buscarBinario(p, arvoreFinal));
                    //out.print(arvoreFinal.buscar(p));
                } else {
                    out.print(" " + arvoreFinal.buscarBinario(p, arvoreFinal));
                    //out.print(" " + arvoreFinal.buscar(p));
                }
            }

            out.close();

        } catch (FileNotFoundException ex) {
            Logger.getLogger(Huffman.class
                    .getName()).log(Level.SEVERE, null, ex);
        }

        return "";
    }

    public void descompactar(String diretorio, String conteudo) {

        String[] arrayConteudo = conteudo.split("\n|=");
        Tabela t = new Tabela();
        Lista<Tabela> l = new Lista();

        //cria tabela char x binário
        for (int i = 1; i < arrayConteudo.length; i++) {

            if (i != arrayConteudo.length - 1) {
                t.setCaractere(arrayConteudo[i]);
                t.setBinario(arrayConteudo[i + 1]);

                //System.out.println(t.getCaractere());
                //System.out.println(t.getBinario());
                l.inserir(t);
                i++;
            }

        }

        //utiliza a tabela para descompactar a ultima linha
        String ultimaLinha = arrayConteudo[arrayConteudo.length - 1];
        String[] arrayUltimaLinha = ultimaLinha.split(" ");

        String conteudoDescompactado = "";

        for (int i = 1; i < arrayUltimaLinha.length; i++) {

            t.setBinario(arrayUltimaLinha[i]);
            int indice = l.buscar(t);
            Tabela elemento = l.obterElemento(indice);

            //System.out.println(elemento.getCaractere());
            //System.out.println(elemento.getBinario());
            String tempCaractere = elemento.getCaractere();
            //System.out.println(tempCaractere);

            int tempInt = Integer.parseInt(tempCaractere);

            tempCaractere = Character.toString((char) tempInt);
            //Character.toString((char) tempCaractere);

            conteudoDescompactado = conteudoDescompactado + tempCaractere;
        }
        //System.out.println(conteudoDescompactado);

        //escreve no arquivo de destino
        try {
            PrintWriter out = new PrintWriter(diretorio);
            out.println(conteudoDescompactado);
            out.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Huffman.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public String lerArquivo(String diretorio) {
        try {
            String content = readFile(diretorio, StandardCharsets.UTF_8);
            return content;

        } catch (IOException ex) {
            Logger.getLogger(Huffman.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    static String readFile(String path, Charset encoding)
            throws IOException {
        byte[] encoded = Files.readAllBytes(Paths.get(path));
        return new String(encoded, encoding);
    }

}
