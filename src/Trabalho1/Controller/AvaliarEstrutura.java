package Trabalho1.Controller;

import Trabalho1.Utils.Regex;
import Trabalho1.Utils.lista.Lista;
import Trabalho1.Utils.lista.NoLista;
import Trabalho1.Utils.pilha.PilhaLista;

import javax.swing.*;
import java.io.File;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static java.lang.System.exit;

public class AvaliarEstrutura {

    PilhaLista<String> pilhaTags = new PilhaLista<String>();
    Lista<String> singletonList = new Lista<>();
    Lista<String> tagsRemovidas = new Lista<>();

    // tags predefinidas
    Lista<String> singletonTagsList = new Lista<>();

    public AvaliarEstrutura() {
        this.insereSingletons();
    }

    /*
     * Valida toda a estrutura do arquivo
     * @param conteudo do arquivo HTML
     * Retorna mensagem a ser exibida na interface
     */
    public String validaEstrutura(String conteudo) {
        String mensagemFinal = "Resultados da análise: \n";

        Scanner scanner = new Scanner(conteudo);
        while(scanner.hasNextLine()){
            String conteudoLinha = scanner.nextLine();

            final Pattern patternAbertura = Pattern.compile(Regex.aberturaTags);
            final Matcher abertura = patternAbertura.matcher(conteudoLinha);

            final Pattern patternFechamento = Pattern.compile(Regex.fechamentoTags);
            final Matcher fechamento = patternFechamento.matcher(conteudoLinha);

            // encontrou tag de abertura na linha atual? Empilha!
            if(abertura.find()){
                String tagAbertura = abertura.group(2);
                Boolean isSingleton = this.singletonTagsList.buscar(tagAbertura) != null;

                // caso não seja um Singleton colocamos na pilha
                if(!isSingleton){
                    this.pilhaTags.push(tagAbertura);
                    mensagemFinal += "Tag de abertura '" + tagAbertura + "' encontrada \n";
                } else {
                    mensagemFinal += "Tag Singleton encontrada: '" + tagAbertura + "' \n";
                }

            }

            // a linha atual possui tag de fechamento?
            // SE SIM --> retiramos a tag empilhada anteriormente e comparamos (PAR?)
            if(fechamento.find()) {
                String tagFechamento = fechamento.group(2);
                mensagemFinal += "Tag de fechamento '" + tagFechamento + "' encontrada \n";

                if(tagFechamento.equalsIgnoreCase(this.pilhaTags.peek())){
                    this.pilhaTags.pop();
                } else {
                    mensagemFinal += "\nFoi encontrada uma tag final inesperada! \n" +
                            "Esperava-se a tag final: '" + this.pilhaTags.peek() + "' \n" +
                            "Foi encontrada: '" + tagFechamento + "' \n";
                }
            }
        }

        System.out.println(pilhaTags);

        if(pilhaTags.estaVazia()){
            mensagemFinal += "Arquivo HTML é válido!";
        } else {
            mensagemFinal += "Arquivo HTML é NÃO ESTÁ VÁLIDO!";
        }

        return mensagemFinal;
    }


    private void insereSingletons(){
        this.singletonTagsList.inserir("meta");
        this.singletonTagsList.inserir("base");
        this.singletonTagsList.inserir("br");
        this.singletonTagsList.inserir("col");
        this.singletonTagsList.inserir("command");
        this.singletonTagsList.inserir("embed");
        this.singletonTagsList.inserir("hr");
        this.singletonTagsList.inserir("img");
        this.singletonTagsList.inserir("input");
        this.singletonTagsList.inserir("link");
        this.singletonTagsList.inserir("param");
        this.singletonTagsList.inserir("source");
        this.singletonTagsList.inserir("!DOCTYPE");
    }

    /*
     * Valida toda a estrutura do arquivo
     * @param file Arquivo a ser analisado
     * Retorna mensagem a ser exibida na interface
     */
//    public String validaEstruturaFile(File file){
//        try {
//            Scanner scanner = new Scanner(file);
//            boolean erros = false;
//            String mensagemFinal = "";
//
//            while (scanner.hasNextLine() && !erros) {
//                boolean tagAbertura = false;
//                boolean tagFechamento = false;
//                String tag = "";
//                String linha = scanner.nextLine();
//
//                System.out.println(linha);
//
//                if (!linha.isEmpty()) {
//                    char[] listaChar = linha.toCharArray();
//
//                    for (char c : listaChar) {
//                        if (!tagAbertura && !tagFechamento && (c == ' ' || c == '\t')) {
//                            continue;
//                        }
//                        if ((tagAbertura || tagFechamento) && c == ' ') {
//                            c = '>';
//                        }
//                        if (c == '<') {
//                            tagAbertura = true;
//                        }
//                        if (c == '/') {
//                            tagAbertura = false;
//                            tagFechamento = true;
//                        }
//                        if (tagAbertura || tagFechamento) {
//                            tag += c;
//                        }
//
//                        if (c == '>') {
//                            if (tagAbertura) {
//                                tag = tag.replace("<", "");
//                                tag = tag.replace("/", "");
//                                tag = tag.replace(">", "");
//                                //requisito 2 - considerando tags singletons e tags com atributos
//                                if (singletonTagsList.buscar(tag) == null) {
//                                    mensagemFinal += "Tag de abertura encontrada:   '<" + tag + ">' \n";
//                                    pilhaTags.push(tag); //Adiciona a tag no topo da pilha
//                                } else {
//                                    singletonList.inserir(tag); //armazena as tags Singletons.
//                                    mensagemFinal += "Tag Singleton encontrada:     '" + tag + "' \n";
//                                }
//
//                                tagAbertura = false;
//                                tag = "";
//                            } else if (tagFechamento) {
//                                if (pilhaTags.estaVazia()) {
//                                    mensagemFinal += "Arquivo não pode iniciar com uma tag de fechamento."
//                                            + "Encontrada a tag: '" + tag + "' \n";
//                                    exit(0);
//                                } else {
//                                    System.out.println("Tag de fechamento encontrada: '" + tag + "'");
//                                    tag = tag.replace("<", "");
//                                    tag = tag.replace("/", "");
//                                    tag = tag.replace(">", "");
//                                    tagFechamento = false;
//
//                                    if (pilhaTags.peek().equals(tag)) {
//                                        //adicionar a tag em uma nova lista para contagem.
//                                        tagsRemovidas.inserir(tag);
//                                        pilhaTags.pop();
//                                    } else {
//                                        //Retorno requisito 4.1
//                                        mensagemFinal += "\n\nSeu arquivo não está bem formatado! \n"
//                                                + "Encontrada a tag final: '</" + tag + ">'. \n" +
//                                                "Esperava a tag final: '</"
//                                                + pilhaTags.peek() + ">'";
//                                        erros = true; //mal formatado
//                                        exit(0);
//                                    }
//                                }
//                            }
//                        }
//                    }
//                }
//
//            }
//            if (!pilhaTags.estaVazia()) {
//                //Retorno requisito 4.2
//                mensagemFinal += "\n\nSeu arquivo não está bem formatado! \nEstá(ão) faltando a(s) tag(s) final(is): \n";
//                mensagemFinal += pilhaTags.toString();
//                exit(0);
//            } else {
//                //Retorno requisito 3
//                mensagemFinal += "\n\nTotal de tags encontradas: \n";
//                //countTag.exibir(); //remover essa linha depois
//                for (int x = 0; x < tagsRemovidas.obterComprimento(); x++) {
//                    //pecorrer a lista "countTag", armazenar o valor em uma variavel e utilizar a variavel no metoto "buscarTodos()";
//                    //countTag.buscarTodos(variavel);
//                    NoLista p = tagsRemovidas.getNo(x);
//                    tagsRemovidas.buscarTodos(p);
//                }
//
//                mensagemFinal += file.getName() + " está válido!";
//
//                return mensagemFinal;
//
//            }
//        } catch (Exception e) {
//            return "Problema ao analisar estrutura do arquivo!";
//        }
//        return "";
//    }


}
