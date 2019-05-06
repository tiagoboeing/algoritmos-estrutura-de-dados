package Trabalho1;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        try {
            BorderPane root = FXMLLoader.load(getClass().getResource("View/Interface.fxml"));
            Scene scene = new Scene(root);
            primaryStage.setScene(scene);
            primaryStage.setTitle("Analisar HTML");
            primaryStage.setResizable(false);
            primaryStage.setMinWidth(600);
            primaryStage.setMinHeight(550);
            primaryStage.show();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}
