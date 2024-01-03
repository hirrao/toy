package com.hirrao.game.main;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("mainScene.fxml"));
        Scene scene = new Scene(loader.load(),600,800);
        stage.setScene(scene);
        stage.setTitle("2048");
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
