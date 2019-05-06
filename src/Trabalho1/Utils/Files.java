package Trabalho1.Utils;

import javafx.stage.FileChooser;

import java.io.*;

public class Files {

    // Reutilização da matéria de compiladores (:

    /* Caixa de seleção de arquivo nativa do sistema
     * @param extensões permitidas
     * @return File
     */
    public static File chooseFile(String[] extensoesPermitidas) {
        FileChooser fileChooser = new FileChooser();

        fileChooser.getExtensionFilters().add(new FileChooser
                .ExtensionFilter(
                "Todos os arquivos", extensoesPermitidas
        ));

        fileChooser.setInitialDirectory(new File(System.getProperty("user.home")));
        File arquivo = fileChooser.showOpenDialog(null);

        try {
            if(arquivo != null) {
                return arquivo;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    /*
     * Lê conteúdo de um arquivo
     * @param File - arquivo
     * @return String - conteúdo do arquivo
     */
    public static String readFile(File arquivo){
        try {
            if(arquivo != null){
                FileReader arq = new FileReader(arquivo.getAbsolutePath());
                BufferedReader lerArq = new BufferedReader(arq);

                String conteudoArquivo = "";
                String linha = lerArq.readLine();
                while (linha != null) {
                    conteudoArquivo += linha + "\n";
                    linha = lerArq.readLine();
                }

                return conteudoArquivo;
            }
        } catch (Exception e){
            return null;
        }
        return null;
    }

}
