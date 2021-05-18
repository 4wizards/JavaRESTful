package com.example.javarest.Repository;

import com.example.javarest.Models.Measurement;

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



    public void AddMeasurement(Measurement measurement){

        Connection con = SQLConnector.GetConnected();
        String query ="INSERT INTO measurement VALUES(?,?,?,?,?)";
        try{
            PreparedStatement statement = con.prepareStatement(query);
            statement.setInt(1, measurement.getDeviceId());
            statement.setInt(2, measurement.getLocationId());
            statement.setString(3, measurement.getMeasurementTime());
            statement.setDouble(4, measurement.getTemperature());
            statement.setDouble(5, measurement.getHumidity());
            statement.executeUpdate();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }

}

/* TEST getValues
BEGIN
    DECLARE @deviceId varchar(100);
    DECLARE @measurementTime varchar (100);
    DECLARE @temperature varchar (100);
    DECLARE @humidity varchar (100);
    SET @measurementTime = ?;
    SET @temperature = ?;
    SET @humidity = ?;
    SELECT @measurementTime, @temperature, @humidity FROM measurement
END
state = setString(1, measurementTime.getMeasurementTime);
state = setString(2, temperature.getTemperature);
state = setString(3, humidity.getHumidity);

*/

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
