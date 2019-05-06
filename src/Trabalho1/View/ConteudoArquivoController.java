package Trabalho1.View;

import javafx.fxml.FXML;
import javafx.scene.control.TextArea;

public class ConteudoArquivoController {

    @FXML private TextArea conteudo;

    public String getConteudo() {
        return conteudo.getText();
    }

    public void setConteudo(String conteudo) {
        this.conteudo.appendText(conteudo);
    }

    public void limpaConteudo(){
        this.conteudo.clear();
    }

}
