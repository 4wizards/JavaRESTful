package com.example.javarest.Repository;

import io.github.cdimascio.dotenv.Dotenv;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class SQLConnector {
    static Connection conny;

    SQLConnector(){
        //Property p = new Property();
        Dotenv dotenv = Dotenv.load();

        try {
            conny = DriverManager.getConnection(dotenv.get("MYSQLDB"),dotenv.get("USERNAME"), dotenv.get("PASSWORD"));
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public static Connection GetConnected(){
        new SQLConnector();
        return conny;
    }
}
