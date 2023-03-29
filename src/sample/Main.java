package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * Два проекта на выбор. Реализовать один из них на любой языке программирования реализующих ООП (в том числе Java).
 * Проект должен быть построен с использованием паттерна MVP и удовлетворять принципам SOLID.
 * 1. Проект с прошлых уроков с блокнотом. Реализовать возможность добавления, изменения и удаления записей в блокнот
 * (каждая запись отдельный объект)
 * 2. Обычный калькулятор поддерживающий 4 основных действия (+,-,*,/).
 * Проект должен соответствовать заданию описанному выше.
 * создать ui с использованием библиотек для создания desktop приложений, например swing или JavaFX
 * добавить логгирование в проект
 */

public class Main extends Application {
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("Hello world!");
        primaryStage.setScene(new Scene(root, 300, 400));
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}