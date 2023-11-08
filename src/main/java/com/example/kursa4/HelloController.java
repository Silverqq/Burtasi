package com.example.kursa4;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.layout.AnchorPane;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

public class HelloController {

    @FXML
    private TextField Login;

    @FXML
    private PasswordField Password;
    @FXML
    private AnchorPane Sign;

    @FXML
    private Button SignIn;

    @FXML
    private Button registr;

    @FXML
    private Button calendar;

    String toastMsg = "INVALID Login or Password";
    int toastMsgTime = 400; //0.4 seconds
    int fadeInTime = 200; //0.2 seconds
    int fadeOutTime = 200; //0.2 seconds
    @FXML
    void initialize() {
        SignIn.setOnAction(event -> {
            String Logintxt = Login.getText().trim();
            String Passwordtxt = Password.getText().trim();
            ToastController Toast = null;
            if (!Logintxt.equals("") && !Passwordtxt.equals(""))
                loginUser(Logintxt, Passwordtxt);
            else
                ToastController.makeText(toastMsg, toastMsgTime, fadeInTime, fadeOutTime);
        });
    }

    private void loginUser(String Logintxt, String Passwordtxt) {
        DatabaseHandler dbHandler = new DatabaseHandler();
        User user = new User();
        user.setLogin(Logintxt);
        user.setPassword(Passwordtxt);
        ResultSet result = dbHandler.getUser(user);

        int count = 0;
        try {
            while (result.next()) {
                count++;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        if (count >= 1) {
            try {
                SceneLoader.loadNewScene("Trainer.fxml", Sign);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            System.out.println("Success!!!");
        }
    }

    @FXML
    public void Registration(ActionEvent actionEvent) throws IOException {
        SceneLoader.loadNewScene("Registration.fxml", Sign);
    }

    public void Client(ActionEvent event) throws IOException {
        SceneLoader.loadNewScene("Client.fxml", Sign);
    }

    public void Return(ActionEvent event) throws IOException {
        SceneLoader.loadNewScene("Start.fxml", Sign);
    }
}
