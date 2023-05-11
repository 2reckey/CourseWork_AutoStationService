package com.fa.coursework;

import com.fa.coursework.Controllers.Controller;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader loader = new FXMLLoader(Main.class.getResource("AuthorizationView.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root, 700, 400);
        stage.setTitle("123");
        stage.setScene(scene);
        stage.setResizable(false);
        Controller controller = loader.getController();
        controller.start();
        stage.show();

    }

    public static void main(String[] args) {
        launch();
    }
}