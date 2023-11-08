package com.example.kursa4;

import javafx.scene.control.DatePicker;

import java.sql.*;

public class DatabaseHandler {
    Connection connection;

    public Connection getConnection() throws ClassNotFoundException, SQLException {
        String connectionstring = "jdbc:mysql://localhost:3306/workout";
        connection = DriverManager.getConnection(connectionstring, "root", "1234");

        return connection;
    }

    public void regUser(String Name, String LastName, String Password, String Login) {
        String insert = "INSERT INTO " + Const.USER_TABLE + "(" + Const.USER_Name + "," + Const.USER_LastName + ","
                + Const.USER_Login + "," + Const.USER_Password + ")"
                + "VALUES(?,?,?,?)";
        try {
            PreparedStatement prSt = getConnection().prepareStatement(insert);
            prSt.setString(1, Name);
            prSt.setString(2, LastName);
            prSt.setString(3, Login);
            prSt.setString(4, Password);
            prSt.executeUpdate();
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public void AddWorkout(String Discipline, String LastName, String SurName, String Name, String Time, String Date) {
        String insert = "INSERT INTO " + Const.WORKOUT_Table + "(" + Const.USER_Discipline + "," + Const.USER_Name + ","
                + Const.USER_LastName + "," + Const.USER_SurName + "," + Const.USER_Date + "," + Const.USER_Time + ")"
                + "VALUES(?,?,?,?,?,?)";
        try {
            PreparedStatement prSt = getConnection().prepareStatement(insert);
            prSt.setString(1, Discipline);
            prSt.setString(2, Name);
            prSt.setString(3, LastName);
            prSt.setString(4, SurName);
            prSt.setString(5, Date);
            prSt.setString(6, Time);
            prSt.executeUpdate();
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException();
        }
    }
    public ResultSet getUser(User user){
        ResultSet resSet = null;
        String select = "SELECT * FROM " + Const.USER_TABLE + " WHERE " + Const.USER_Login
                + "=? AND " + Const.USER_Password + "=?";
        try {
            PreparedStatement prSt = getConnection().prepareStatement(select);
            prSt.setString(1, user.getLogin());
            prSt.setString(2, user.getPassword());
            resSet = prSt.executeQuery();
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException();
        }

        return resSet;
    }
    public ResultSet getSport(Sport sport){
        ResultSet resSet = null;
        String select = "SELECT * FROM " + Const.WORKOUT_Table + " WHERE " + Const.USER_Date + "=?";
        try{
            PreparedStatement prSt = getConnection().prepareStatement(select);
            prSt.setString(1, sport.getDate());
            resSet = prSt.executeQuery();
        }
        catch (SQLException|ClassNotFoundException e) {
            throw new RuntimeException();
        }return resSet;
    }
}
