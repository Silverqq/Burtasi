package com.example.kursa4;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import java.io.IOException;

public class Registration {

    @FXML
    private TextField LastName;

    @FXML
    private TextField Login;
    @FXML
    private AnchorPane Reg;
    @FXML
    private TextField Name;

    @FXML
    private TextField Password;

    @FXML
    private Button Registration;
    @FXML
    private Button Return;

    @FXML
    public void Return(ActionEvent actionEvent) throws IOException {
        SceneLoader.loadNewScene("Hello.fxml", Reg);
    }
    @FXML
    void initialize(){
        DatabaseHandler dbHandler = new DatabaseHandler();
        Registration.setOnAction(event -> {
            dbHandler.regUser(Name.getText(), LastName.getText(), Password.getText(), Login.getText());
        });
    }
}


