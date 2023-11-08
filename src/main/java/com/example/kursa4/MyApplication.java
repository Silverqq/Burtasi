package com.example.kursa4;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;
import java.sql.SQLException;

public class MyApplication extends Application {

    @Override
    public void start(Stage stage) throws IOException, SQLException {
        FXMLLoader fxmlLoader = new FXMLLoader(MyApplication.class.getResource("Start.fxml"));
        Scene scene = new Scene(fxmlLoader.load(),600, 500);
        stage.setScene(scene);
        stage.setTitle("Буртасы");
        stage.show();
        stage.setResizable(false);
    }

    public static void main(String[] args) {
        launch();
    }

}