package com.example.kursa4;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

public class Start {

    public AnchorPane start;
    @FXML
    private Button CL;

    @FXML
    private Button TR;

    @FXML
    public void Tr(ActionEvent actionEvent) throws IOException {
        SceneLoader.loadNewScene("Hello.fxml", start);
    }

    @FXML
    public void Cl(ActionEvent actionEvent) throws IOException {
        SceneLoader.loadNewScene("Client.fxml", start);
    }
}
