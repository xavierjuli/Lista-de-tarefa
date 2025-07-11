package GUI;

import database.DBTarefa;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MainApp extends Application {

    @Override
    public void start(Stage primaryStage) {
        new DBTarefa();

        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/GUI/menu.fxml"));
            Scene scene = new Scene(loader.load());

            primaryStage.setTitle("Lista de Tarefas");
            primaryStage.setScene(scene);
            primaryStage.setResizable(false);
            primaryStage.show();

        } catch (Exception e) {
            System.out.println("Erro! " + e.getMessage());
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
