package com.hirrao.rockpaperscissors;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {
    public static void main(String[] args) {
        launch();
    }

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader mainFxmlLoader = new FXMLLoader(Main.class.getResource("MainScene.fxml"));
        Scene scene = new Scene(mainFxmlLoader.load(), 640, 480);
        stage.setTitle("Rock-Paper-Scissors");
        stage.setScene(scene);
        stage.show();
    }
}