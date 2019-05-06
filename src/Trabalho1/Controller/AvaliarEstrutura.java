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
    public String validaEstrutura(String conteudo){

        // busca tags de abertura
        this.empilhaTags(Regex.aberturaTags, conteudo);

        // busca tags de fechamento e retira da pilha
        return this.desempilhaTags(Regex.fechamentoTags, conteudo);

    }

    /*
     * Empilha tags em uma lista de acordo com um Regex
     * @param regex Expressão regular para identificar tags
     * @param conteudoArquivo Texto a ser analisado
     */
    public void empilhaTags(String regex, String conteudoArquivo){
        final Pattern pattern = Pattern.compile(regex, Pattern.MULTILINE);
        final Matcher matcher = pattern.matcher(conteudoArquivo);

        // varre buscando por tags de abertura (<a>, <p>, <h1>, ...)
        while (matcher.find()) {
            String tag = matcher.group(2);
            Boolean isSingleton = this.singletonTagsList.buscar(tag) != null;

            // se não for singleton, coloca na lista
            if(!isSingleton){
                this.pilhaTags.push(tag);

                // insere na lista para ser possível contar vezes utilizada
                this.singletonList.inserir(tag);
            }
        }
    }

    /*
     * Desempilha tags em uma lista de acordo com um Regex
     * @param regex Expressão regular para identificar tags
     * @param conteudoArquivo Texto a ser analisado
     */
    public String desempilhaTags(String regex, String conteudoArquivo){
        final Pattern pattern = Pattern.compile(regex, Pattern.MULTILINE);
        final Matcher matcher = pattern.matcher(conteudoArquivo);

        // varre buscando por tags de abertura (<a>, <p>, <h1>, ...)
        while (matcher.find()) {
            String tag = matcher.group(2);
            String dadoDesempilhado = this.pilhaTags.pop();

            // o dado desempilhado precisa ser igual a tag de fechamento (formar par)
            if(!dadoDesempilhado.equalsIgnoreCase(tag)) {
                return "Foi encontrada uma tag final inesperada! \n" +
                        "Esperava-se a tag final: '" + tag + "' \n" +
                        "Foi encontrada: '" + dadoDesempilhado + "'";
            }
        }
        return "";
    }

    /*
     * Valida toda a estrutura do arquivo
     * @param file Arquivo a ser analisado
     * Retorna mensagem a ser exibida na interface
     */
    public String validaEstruturaFile(File file){
        try {
            Scanner scanner = new Scanner(file);
            boolean erros = false;
            String mensagemFinal = "";

            while (scanner.hasNextLine() && !erros) {
                boolean tagAbertura = false;
                boolean tagFechamento = false;
                String tag = "";
                String linha = scanner.nextLine();

                System.out.println(linha);

                if (!linha.isEmpty()) {
                    char[] listaChar = linha.toCharArray();

                    for (char c : listaChar) {
                        if (!tagAbertura && !tagFechamento && (c == ' ' || c == '\t')) {
                            continue;
                        }
                        if ((tagAbertura || tagFechamento) && c == ' ') {
                            c = '>';
                        }
                        if (c == '<') {
                            tagAbertura = true;
                        }
                        if (c == '/') {
                            tagAbertura = false;
                            tagFechamento = true;
                        }
                        if (tagAbertura || tagFechamento) {
                            tag += c;
                        }

                        if (c == '>') {
                            if (tagAbertura) {
                                tag = tag.replace("<", "");
                                tag = tag.replace("/", "");
                                tag = tag.replace(">", "");
                                //requisito 2 - considerando tags singletons e tags com atributos
                                if (singletonTagsList.buscar(tag) == null) {
                                    mensagemFinal += "Tag de abertura encontrada:   '<" + tag + ">' \n";
                                    pilhaTags.push(tag); //Adiciona a tag no topo da pilha
                                } else {
                                    singletonList.inserir(tag); //armazena as tags Singletons.
                                    mensagemFinal += "Tag Singleton encontrada:     '" + tag + "' \n";
                                }

                                tagAbertura = false;
                                tag = "";
                            } else if (tagFechamento) {
                                if (pilhaTags.estaVazia()) {
                                    mensagemFinal += "Arquivo não pode iniciar com uma tag de fechamento."
                                            + "Encontrada a tag: '" + tag + "' \n";
                                    exit(0);
                                } else {
                                    System.out.println("Tag de fechamento encontrada: '" + tag + "'");
                                    tag = tag.replace("<", "");
                                    tag = tag.replace("/", "");
                                    tag = tag.replace(">", "");
                                    tagFechamento = false;

                                    if (pilhaTags.peek().equals(tag)) {
                                        //adicionar a tag em uma nova lista para contagem.
                                        tagsRemovidas.inserir(tag);
                                        pilhaTags.pop();
                                    } else {
                                        //Retorno requisito 4.1
                                        mensagemFinal += "\n\nSeu arquivo não está bem formatado! \n"
                                                + "Encontrada a tag final: '</" + tag + ">'. \n" +
                                                "Esperava a tag final: '</"
                                                + pilhaTags.peek() + ">'";
                                        erros = true; //mal formatado
                                        exit(0);
                                    }
                                }
                            }
                        }
                    }
                }

            }
            if (!pilhaTags.estaVazia()) {
                //Retorno requisito 4.2
                mensagemFinal += "\n\nSeu arquivo não está bem formatado! \nEstá(ão) faltando a(s) tag(s) final(is): \n";
                mensagemFinal += pilhaTags.toString();
                exit(0);
            } else {
                //Retorno requisito 3
                mensagemFinal += "\n\nTotal de tags encontradas: \n";
                //countTag.exibir(); //remover essa linha depois
                for (int x = 0; x < tagsRemovidas.obterComprimento(); x++) {
                    //pecorrer a lista "countTag", armazenar o valor em uma variavel e utilizar a variavel no metoto "buscarTodos()";
                    //countTag.buscarTodos(variavel);
                    NoLista p = tagsRemovidas.getNo(x);
                    tagsRemovidas.buscarTodos(p);
                }

                mensagemFinal += file.getName() + " está válido!";

                return mensagemFinal;

            }
        } catch (Exception e) {
            return "Problema ao analisar estrutura do arquivo!";
        }
        return "";
    }

    // SEMESTRE ANTERIOR
    private void analisaArquivo(File file){
        try {
            Scanner sc = new Scanner(file);// seta o Scanner
            boolean withError = false;

            while (sc.hasNextLine()) {
                if (!withError) {
                    boolean tagAbertura = false;
                    boolean tagFechamento = false;
                    String tag = "";
                    String linha = sc.nextLine();

                    if (!linha.isEmpty()) {
                        char[] listaChar = linha.toCharArray();
                        for (char c : listaChar) {
                            if (!tagAbertura && !tagFechamento && (c == ' ' || c == '\t')) {
                                continue;
                            }

                            if ((tagAbertura || tagFechamento) && c == ' ') {
                                c = '>';
                            }

                            if (c == '<') {
                                tagAbertura = true;
                            }

                            if (c == '/') {
                                tagAbertura = false;
                                tagFechamento = true;
                            }

                            if (tagAbertura || tagFechamento) {
                                tag += c;
                            }

                            if (c == '>') {
                                if (tagAbertura) {
                                    tag = tag.replace("<", "");
                                    tag = tag.replace("/", "");
                                    tag = tag.replace(">", "");
                                    //requisito 2 - considerando tags singletons e tags com atributos
                                    if (singletonTagsList.buscar(tag) == null) {
                                        System.out.println("Tag de abertura encotrada:   '<" + tag + ">'");
                                        pilhaTags.push(tag); //Adiciona a tag no topo da pilha
                                    } else {
                                        singletonList.inserir(tag); //armazena as tags Singletons.
                                        System.out.println("Tag Singleton encotrada:     '" + tag + "'");
                                    }

                                    tagAbertura = false;
                                    tag = "";
                                } else if (tagFechamento) {
                                    if (pilhaTags.estaVazia()) {
                                        System.out.println("Seu arquivo não pode iniciar com uma tag de fechamento."
                                                + "Encontrada a tag: '" + tag + "'");
                                        exit(0);
                                    } else {
                                        System.out.println("Tag de fechamento encotrada: '" + tag + "'");
                                        tag = tag.replace("<", "");
                                        tag = tag.replace("/", "");
                                        tag = tag.replace(">", "");
                                        tagFechamento = false;

                                        if (pilhaTags.peek().equals(tag)) {
                                            //adicionar a tag em uma nova lista para contagem.
                                            tagsRemovidas.inserir(tag);
                                            pilhaTags.pop();
                                        } else {
                                            //Retorno requisito 4.1
                                            System.out.println("\n\nSeu arquivo não está bem formatado! \n"
                                                    + "Encontrado a tag final: '</" + tag + ">'. \nEsperava a tag final: '</"
                                                    + pilhaTags.peek() + ">'");
                                            withError = true; //mal formatado
                                            exit(0);
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
            if (!pilhaTags.estaVazia()) {
                //Retorno requisito 4.2
                System.out.println("\n\nSeu arquivo não está bem formatado! \nEstá(ão) faltando a(s) tag(s) final(is): \n");
                System.out.println(pilhaTags.toString());
                exit(0);
            } else {
                //Retorno requisito 3
                System.out.println("\n\nTotal de tags encontras: \n");
                //countTag.exibir(); //remover essa linha depois
                for (int x = 0; x < tagsRemovidas.obterComprimento(); x++) {
                    //pecorrer a lista "countTag", armazenar o valor em uma variavel e utilizar a variavel no metoto "buscarTodos()";
                    //countTag.buscarTodos(variavel);
                    NoLista p = tagsRemovidas.getNo(x);
                    tagsRemovidas.buscarTodos(p);
                }


                System.out.println("PARABENS! Seu arquivo '" + file.getName() + "' está bem formatado");

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
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

}
