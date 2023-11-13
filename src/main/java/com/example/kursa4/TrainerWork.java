package com.example.kursa4;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TrainerWork {

    @FXML
    private AnchorPane TrainerWork;

    @FXML
    private TableColumn<TableView, String> Date;

    @FXML
    private DatePicker Datepick;

    @FXML
    private TableColumn<TableView, String> LastName;

    @FXML
    private Button LogOut;

    @FXML
    private TableColumn<TableView, String> Name;

    @FXML
    private TableColumn<TableView, String> SurName;

    @FXML
    private TableView<Sport> TableV;

    @FXML
    private TableColumn<TableView, String> Time;

    @FXML
    private TableColumn<TableView, String> discipline;


    String toastMsg = "INVALID DATE";
    int toastMsgTime = 400; //0.4 seconds
    int fadeInTime = 200; //0.2 seconds
    int fadeOutTime = 200; //0.2 seconds

    @FXML
    public void Initialize(ActionEvent event) {
        ToastController Toast = null;
        try {
            String date = Datepick.getValue().toString();
            if (!date.equals(""))
                UpdateT(date);
        } catch (Exception e) {
            ToastController.makeText(toastMsg, toastMsgTime, fadeInTime, fadeOutTime);
        }

    }

    public void LogOut(ActionEvent event) throws IOException {
        SceneLoader.loadNewScene("Trainer.fxml", TrainerWork);
    }

    private void UpdateT(String date) {
        DatabaseHandler db = new DatabaseHandler();
        Sport sport = new Sport();
        sport.setDate(date);
        ResultSet rsSet = db.getSport(sport);

        ObservableList<Sport> SportsList = FXCollections.observableArrayList();

        try {
            while (rsSet.next()) {
                String discipline = rsSet.getString("discipline");
                String name = rsSet.getString("Name");
                String lastName = rsSet.getString("lastName");
                String surName = rsSet.getString("surName");
                String Date = rsSet.getString("Date");
                String Time = rsSet.getString("Time");


                sport = new Sport(discipline, name, lastName, surName, Date, Time);
                SportsList.add(sport);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        // Привязка модели данных к столбцам TableView
        Name.setCellValueFactory(new PropertyValueFactory<>("name"));
        discipline.setCellValueFactory(new PropertyValueFactory<>("discipline"));
        Date.setCellValueFactory(new PropertyValueFactory<>("date"));
        Time.setCellValueFactory(new PropertyValueFactory<>("time"));
        LastName.setCellValueFactory(new PropertyValueFactory<>("lastName"));
        SurName.setCellValueFactory(new PropertyValueFactory<>("surName"));

        // Установка модели данных в TableView
        TableV.setItems(SportsList);
    }
}
