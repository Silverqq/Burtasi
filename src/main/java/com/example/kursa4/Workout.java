package com.example.kursa4;

import java.util.Date;

public class Workout {
    private String Name;
    private Date date;
    private String NameTr;
    private String LastNameTr;
    private String SurNameTr;

    public Workout(String name, Date date, String nameTr, String lastNameTr, String surNameTr) {
        this.Name = name;
        this.date = date;
        this.NameTr = nameTr;
        this.LastNameTr = lastNameTr;
        this.SurNameTr = surNameTr;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getNameTr() {
        return NameTr;
    }

    public void setNameTr(String nameTr) {
        NameTr = nameTr;
    }

    public String getLastNameTr() {
        return LastNameTr;
    }

    public void setLastNameTr(String lastNameTr) {
        LastNameTr = lastNameTr;
    }

    public String getSurNameTr() {
        return SurNameTr;
    }

    public void setSurNameTr(String surNameTr) {
        SurNameTr = surNameTr;
    }
}
