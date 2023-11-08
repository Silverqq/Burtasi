package com.example.kursa4;

public class User {
    public String Name;
    public String Login;
    public String Password;
    public String LastName;

    public User(String Name, String Login, String Password, String LastName) {
        this.Name = Name;
        this.Login = Login;
        this.Password = Password;
        this.LastName = LastName;
    }

    public User() {

    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public String getLogin() {
        return Login;
    }

    public void setLogin(String login) {
        Login = login;
    }

    public String getLastName() {
        return LastName;
    }

    public void setLastName(String lastName) {
        LastName = lastName;
    }
}
