package com.example.javarest.Repository;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class Property {

    private static String userName;
    private static String password;
    private static String connectionString;

    public Property(){
        Properties p = new java.util.Properties();
        try{
            p.load(new FileInputStream("src/main/resources/application.properties"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        this.setUserName(p.getProperty("USERNAME"));
        this.setPassword(p.getProperty("PASSWORD"));
        this.setConnectionString(p.getProperty("MYSQLDB"));
        System.out.println(this.userName);

        System.setProperty("MYSQLDB", this.connectionString);
        System.setProperty("USERNAME", this.userName);
        System.setProperty("PASSWORD", this.password);
    }

    public static String getUserName() {
        return userName;
    }

    public static String getPassword() {
        return password;
    }

    public static String getConnectionString() {
        return connectionString;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setConnectionString(String connectionString) {
        this.connectionString = connectionString;
    }
}
