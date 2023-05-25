package oop.familyTree;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.util.Objects;

public class MainDesktop extends Application{

    public void start(Stage stage) {
        try {
            AnchorPane root = FXMLLoader.load(Objects.requireNonNull(
                    MainDesktop.class.getResource("familyTreeView.fxml")));
            stage.setTitle("Семейное древо");
            stage.setScene(new Scene(root, 800, 600));
            stage.show();
        }
        catch (Exception ex){
            System.out.println(ex.getMessage());
        }
    }

    public static void main(String[] args) {
        launch();
    }
}