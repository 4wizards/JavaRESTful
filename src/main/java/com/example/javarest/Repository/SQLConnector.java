package com.example.javarest.Repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class SQLConnector {
    static Connection conny;

    SQLConnector(){
        Property p = new Property();



        try {
            conny = DriverManager.getConnection(System.getenv("MYSQLDB"),System.getenv("USERNAME"), System.getenv("PASSWORD"));
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public static Connection GetConnected(){
        new SQLConnector();
        return conny;
    }
}
