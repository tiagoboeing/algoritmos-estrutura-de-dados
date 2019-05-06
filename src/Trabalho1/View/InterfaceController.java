package Trabalho1.View;

import Trabalho1.Controller.AvaliarEstrutura;
import Trabalho1.Utils.Files;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.File;

public class InterfaceController {

    static final String[] extensoesPermitidas = {"*.html", "*.HTML"};
    static String caminhoArquivoSalvo = null; // local do arquivo aberto
    private String conteudoArquivo = null;

    @FXML private TextArea resultadoAnalise;
    @FXML private Button buttonAbrirArquivo;
    @FXML private Button buttonVerConteudo;

    @FXML
    private void abrirArquivo(){
        File arquivo = Files.chooseFile(extensoesPermitidas);
        this.conteudoArquivo = Files.readFile(arquivo); // lê arquivo e guarda em uma string

        if(this.conteudoArquivo != null){
            this.limpaResultados(); // limpa área de mensagens
            this.arquivoAberto(true); // manipula comportamento da interface

            caminhoArquivoSalvo = arquivo.getAbsolutePath();
            this.resultadoAnalise.appendText("Um arquivo foi selecionado: \n" + caminhoArquivoSalvo);
            this.resultadoAnalise.appendText("\n \n");

//            this.resultadoAnalise.appendText(this.conteudoArquivo);

            // realizar análise da estrutura
            AvaliarEstrutura analisar = new AvaliarEstrutura();
            this.resultadoAnalise.appendText(analisar.validaEstrutura(conteudoArquivo));

        } else {
            this.arquivoAberto(false); // desativa botões e define labels
            this.resultadoAnalise.appendText("SELECIONE UM ARQUIVO COM CONTEÚDO!");
        }
    }

    @FXML
    public void verConteudo(ActionEvent event){
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("ConteudoArquivo.fxml"));
            Parent root = loader.load();
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.setTitle(caminhoArquivoSalvo);
            stage.initStyle(StageStyle.UTILITY);
            stage.initModality(Modality.WINDOW_MODAL);
            stage.initOwner(((Node)event.getSource()).getScene().getWindow());
            stage.setResizable(true);
            stage.show();

            ConteudoArquivoController conteudo = loader.getController();
            conteudo.limpaConteudo();
            conteudo.setConteudo(conteudoArquivo);
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void carregaArquivoTeste(){
        this.limpaResultados();
        this.arquivoAberto(true);

        this.resultadoAnalise.appendText("Arquivo de testes foi aberto \n\n");

        caminhoArquivoSalvo = "Arquivo de teste";
        conteudoArquivo =
                "<html>\n" +
                "<body>\n" +
                "<h1>Aqui cabeçalho do arquivo</h1>\n" +
                "<p>Meu parágrafo da página web.</p>\n" +
                "<p>Meu segundo parágrafo.</p>\n" +
                "</body>\n" +
                "</html>";

        // realizar análise da estrutura
        AvaliarEstrutura analisar = new AvaliarEstrutura();
        this.resultadoAnalise.appendText(analisar.validaEstrutura(conteudoArquivo));
    }

    private void limpaResultados(){
        this.resultadoAnalise.clear();
    }

    private void arquivoAberto(Boolean aberto){
        if(!aberto){
            this.buttonVerConteudo.setDisable(true);
            this.buttonAbrirArquivo.setText("Abrir arquivo");
        } else {
            this.buttonAbrirArquivo.setText("Abrir outro arquivo");
            this.buttonVerConteudo.setDisable(false);
        }
    }

}
