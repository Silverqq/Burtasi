package com.example.kursa4;

import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class Sport {
    private String Discipline;
    private String Name;
    private String LastName;
    private String SurName;
    private String Date;
    private String Time;

    public Sport(String discipline, String name, String lastName, String surName, String date, String time) {
        Discipline = discipline;
        Name = name;
        LastName = lastName;
        SurName = surName;
        Date = date;
        Time = time;
    }

    public Sport() {

    }

    public String getTime() {
        return Time;
    }

    public void setTime(String time) {
        Time = time;
    }

    public String getDate() {
        return Date;
    }

    public void setDate(String date) {
        Date = date;
    }

    public String getSurName() {
        return SurName;
    }

    public void setSurName(String surName) {
        SurName = surName;
    }

    public String getLastName() {
        return LastName;
    }

    public void setLastName(String lastName) {
        LastName = lastName;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getDiscipline() {
        return Discipline;
    }

    public void setDiscipline(String discipline) {
        Discipline = discipline;
    }
}
