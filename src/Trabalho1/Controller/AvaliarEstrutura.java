package Trabalho1.Controller;

import Trabalho1.Utils.Regex;
import Trabalho1.Utils.lista.Lista;
import Trabalho1.Utils.pilha.PilhaLista;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AvaliarEstrutura {

    PilhaLista<String> pilhaTags = new PilhaLista<>();
    Lista<String> singletonList = new Lista<>(); // singletons encontrados
    Lista<String> tagsRemovidas = new Lista<>();
    Lista<String> tagsUtilizadas = new Lista<>();

    // tags predefinidas
    Lista<String> singletonTagsList = new Lista<>();

    String mensagemFinal;

    public AvaliarEstrutura() {
        this.insereSingletons();
    }

    /*
     * Valida toda a estrutura do arquivo
     * @param conteudo do arquivo HTML
     * Retorna mensagem a ser exibida na interface
     */
    public void validaEstrutura(String conteudo) {
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
                    // adiciona na lista se Singletons
                    this.singletonList.inserir(tagAbertura);
                    this.tagsUtilizadas.inserir(tagAbertura);
                }

            }

            // a linha atual possui tag de fechamento?
            // SE SIM --> retiramos a tag empilhada anteriormente e comparamos (PAR?)
            if(fechamento.find()) {
                String tagFechamento = fechamento.group(2);
                mensagemFinal += "Tag de fechamento '" + tagFechamento + "' encontrada \n";

                if(tagFechamento.equalsIgnoreCase(this.pilhaTags.peek())){
                    this.tagsUtilizadas.inserir(this.pilhaTags.peek());
                    this.pilhaTags.pop();
                } else {
                    mensagemFinal += "\nFoi encontrada uma tag final inesperada! \n" +
                            "Esperava-se a tag final: '" + this.pilhaTags.peek() + "' \n" +
                            "Foi encontrada: '" + tagFechamento + "' \n";
                }
            }
        }

        tagsUtilizadas.exibir();

        if(pilhaTags.estaVazia()){
            mensagemFinal += "Arquivo HTML é válido!";
        } else {
            mensagemFinal += "Arquivo HTML é NÃO ESTÁ VÁLIDO!";
        }

        setMensagemFinal(mensagemFinal);
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

    public String getMensagemFinal() {
        return mensagemFinal;
    }

    public void setMensagemFinal(String mensagemFinal) {
        this.mensagemFinal += mensagemFinal;
    }
}
