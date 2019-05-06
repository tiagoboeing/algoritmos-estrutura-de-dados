package br.furb.trabalho1_semestres_anteriores.HTML;

import java.io.File;

import static java.lang.System.exit;
import java.util.Scanner;
import javax.swing.JOptionPane;

import br.furb.trabalho1_semestres_anteriores.lista.Lista;
import br.furb.trabalho1_semestres_anteriores.lista.NoLista;
import br.furb.trabalho1_semestres_anteriores.pilha.PilhaLista;

public class CriarHTML {

    public void verificarArquivo() throws Exception {

        //String[] listaParaVerificar = new String[100];
        //int i = 0;
        PilhaLista pilha = new PilhaLista(); //empilhar as tags encontradas no arquivo
        Lista<String> countTag = new Lista();       //lista para armazenas as tags removidas da pilha
        Lista<String> verificaSingleton = new Lista(); //contem as tags Singletons do trabalho para verificação
        Lista<String> singleton = new Lista<>(); //insere as tags Singletons encontradas

        verificaSingleton.inserir("meta");
        verificaSingleton.inserir("base");
        verificaSingleton.inserir("br");
        verificaSingleton.inserir("col");
        verificaSingleton.inserir("command");
        verificaSingleton.inserir("hr");
        verificaSingleton.inserir("img");
        verificaSingleton.inserir("input");
        verificaSingleton.inserir("link");
        verificaSingleton.inserir("param");
        verificaSingleton.inserir("source");
        verificaSingleton.inserir("!DOCTYPE");

        // requisito 1
        String arquivo;
        arquivo = JOptionPane.showInputDialog("Insira o caminho completo e nome arquivo. \n Exemplo: C:\\Temp\\teste.html");
        File file = new File(arquivo);// caminho do arquivo

        if (!file.exists()) {
            JOptionPane.showMessageDialog(null, "Arquivo não existe", "Error", 0);
            JOptionPane.showMessageDialog(null, "Utilize o padrão: 'C:\\Temp\\teste.html");
            verificarArquivo();
        }

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
                                if (verificaSingleton.buscar(tag) == null) {
                                    System.out.println("Tag de abertura encotrada:   '<" + tag + ">'");
                                    pilha.push(tag); //Adiciona a tag no topo da pilha
                                } else {
                                    singleton.inserir(tag); //armazena as tags Singletons.
                                    System.out.println("Tag Singleton encotrada:     '" + tag + "'");
                                }

                                tagAbertura = false;
                                tag = "";
                            } else if (tagFechamento) {
                                if (pilha.estaVazia()) {
                                    System.out.println("Seu arquivo não pode iniciar com uma tag de fechamento."
                                            + "Encontrada a tag: '" + tag + "'");
                                    exit(0);
                                } else {
                                    System.out.println("Tag de fechamento encotrada: '" + tag + "'");
                                    tag = tag.replace("<", "");
                                    tag = tag.replace("/", "");
                                    tag = tag.replace(">", "");
                                    tagFechamento = false;

                                    if (pilha.peek().equals(tag)) {
                                        //adicionar a tag em uma nova lista para contagem.
                                        countTag.inserir(tag);
                                        pilha.pop();
                                    } else {
                                        //Retorno requisito 4.1
                                        System.out.println("\n\nSeu arquivo não está bem formatado! \n"
                                                + "Encontrado a tag final: '</" + tag + ">'. \nEsperava a tag final: '</"
                                                + pilha.peek() + ">'");
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
        if (!pilha.estaVazia()) {
            //Retorno requisito 4.2
            System.out.println("\n\nSeu arquivo não está bem formatado! \nEstá(ão) faltando a(s) tag(s) final(is): \n");
            System.out.println(pilha.toString());
            exit(0);
        } else {
            //Retorno requisito 3
            System.out.println("\n\nTotal de tags encontras: \n");
            //countTag.exibir(); //remover essa linha depois
            for (int x = 0; x < countTag.obterComprimento(); x++) {
            	//pecorrer a lista "countTag", armazenar o valor em uma variavel e utilizar a variavel no metoto "buscarTodos()";
                //countTag.buscarTodos(variavel);
            	NoLista p = countTag.getNo(x);
            	countTag.buscarTodos(p);
			}
            

            JOptionPane.showMessageDialog(null, "PARABENS! Seu arquivo '" + file.getName() + "' está bem formatado");

		}
	}

}
