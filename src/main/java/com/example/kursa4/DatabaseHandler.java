package com.example.kursa4;

import java.sql.*;

public class DatabaseHandler {
    Connection connection;

    public Connection getConnection() throws ClassNotFoundException, SQLException{
        String connectionstring = "jdbc:mysql://localhost:3306/workout";
        connection = DriverManager.getConnection(connectionstring, "root", "1234");

        return connection;
    }

    public void regUser(String Name, String LastName, String Password, String Login){
        String insert = "INSERT INTO " + Const.USER_TABLE + "(" + Const.USER_Name + "," + Const.USER_LastName + ","
                + Const.USER_Login + ","+ Const.USER_Password + ")"
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
}
