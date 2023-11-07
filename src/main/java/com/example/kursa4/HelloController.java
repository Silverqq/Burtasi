package com.example.kursa4;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.layout.AnchorPane;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

import java.io.IOException;

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

    @FXML
    void SignIn(ActionEvent actionEvent) throws IOException  {
        String Logintxt = Login.getText().trim();
        String Passwordtxt = Password.getText().trim();
        if (!Logintxt.equals("")&& !Passwordtxt.equals(""))
            loginUser(Logintxt,Passwordtxt);
        else
            System.out.println("Login is uncorrect");
        SceneLoader.loadNewScene("MainApp.fxml", Sign);

    }

    private void loginUser(String logintxt, String passwordtxt) {
    }

    @FXML
    public void Registration(ActionEvent actionEvent) throws IOException {
        SceneLoader.loadNewScene("Registration.fxml", Sign);
    }
    @FXML
    public void Calendar (ActionEvent actionEvent) throws IOException{
        SceneLoader.loadNewScene("Calendar.fxml", Sign);
    }
}
