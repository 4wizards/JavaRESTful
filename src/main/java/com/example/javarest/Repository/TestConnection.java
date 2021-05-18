package com.example.javarest.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TestConnection {

    public TestConnection () throws SQLException {
        Connection con = SQLConnector.GetConnected();

        Statement statement = con.createStatement();
        ResultSet result = statement.executeQuery("SELECT * FROM device");

        while(result.next()){
            System.out.println(result.getInt("deviceId"));
        }
    }

    public void TestAdd () {
        Connection con = SQLConnector.GetConnected();
        try {
            PreparedStatement statement = con.prepareStatement("SELECT id FROM location WHERE longitude=?");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

  /*  public List<Integer> Testa{
        List lista = new ArrayList();

    }*/
}


/*
BEGIN
    DECLARE @MyName varchar(100);
    DECLARE @MySubject varchar(100);
    SET @MyName = ?;
    SET @MySubject = ?;
    IF NOT EXISTS (SELECT * FROM tbl_sampleTable WHERE name = @MyName OR subject = @MySubject)
    BEGIN
        INSERT INTO tbl_sampleTable(subject, name) VALUES (@MySubject, @MyName)
    END
END
 */
