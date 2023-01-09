package com.tione.tiona;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
//check the jar files
public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("Admin/admin_panel.fxml"));
//        Scene scene = new Scene(fxmlLoader.load(), 1024, 600);
        Scene scene = new Scene(fxmlLoader.load(), 1300, 700);
        stage.setTitle("Admin Dashboard");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {

        launch();
    }
}