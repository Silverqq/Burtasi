package com.example.kursa4;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Objects;

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
    String toastMsg = "INVALID Login or Password";
    int toastMsgTime = 400; //0.4 seconds
    int fadeInTime = 200; //0.2 seconds
    int fadeOutTime = 200; //0.2 seconds

    @FXML
    public void Return(ActionEvent actionEvent) {
        try {
            SceneLoader.loadNewScene("Hello.fxml", Reg);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    void initialize() {
        DatabaseHandler dbHandler = new DatabaseHandler();
        Registration.setOnAction(event -> {
            if (!Objects.equals(Name.getText(), "") && !Objects.equals(LastName.getText(), "")
                    && !Objects.equals(Password.getText(), "") && !Objects.equals(Login.getText(), "")){
                dbHandler.regUser(Name.getText(), LastName.getText(), Password.getText(), Login.getText());
                try {
                    SceneLoader.loadNewScene("Trainer.fxml", Reg);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }}
            else
            ToastController.makeText(toastMsg, toastMsgTime, fadeInTime, fadeOutTime);
        });
    }
}


