package com.example.kursa4;

import com.mysql.cj.jdbc.jmx.LoadBalanceConnectionGroupManager;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
import java.util.FormatterClosedException;
import java.util.Objects;

public class Trainer {

    @FXML
    private Button AddEventSport;

    @FXML
    private DatePicker DatePicker = new DatePicker();

    @FXML
    private TextField Discipline;

    @FXML
    private TextField Lastname;

    @FXML
    private TextField Name;

    @FXML
    private TextField SurName;

    @FXML
    private TextField Time;

    @FXML
    private AnchorPane Tr;
    String toastMsg = "Fill in the data";
    String toastMsg1 = "Fill in the data";
    int toastMsgTime = 400; //0.4 seconds
    int fadeInTime = 200; //0.2 seconds
    int fadeOutTime = 200; //0.2 seconds
    @FXML
    public void AddSport(ActionEvent event){
        try{ToastController.makeText(toastMsg1, toastMsgTime, fadeInTime, fadeOutTime);
        String date = DatePicker.getValue().toString();
        DatabaseHandler db = new DatabaseHandler();
        AddEventSport.setOnAction(event1 -> {
            if(!Objects.equals(Discipline.getText(), "")&& !Objects.equals(Lastname.getText(), "")&&
                    !Objects.equals(SurName.getText(), "")&& !Objects.equals(Name.getText(), "")&&
                    !Objects.equals(Time.getText(), "")&&!Objects.equals(date,""))
                db.AddWorkout(Discipline.getText(), Lastname.getText(), SurName.getText(), Name.getText(), Time.getText(), date);
            else
                ToastController.makeText(toastMsg, toastMsgTime, fadeInTime, fadeOutTime);
        });
    }catch (FormatterClosedException e){
            e.printStackTrace();
        }
    }
    public void Return(ActionEvent actionEvent) throws IOException {
        SceneLoader.loadNewScene("Hello.fxml", Tr);
    }
}
