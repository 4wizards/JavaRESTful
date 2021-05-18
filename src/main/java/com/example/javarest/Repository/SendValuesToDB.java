package com.example.javarest.Repository;

import com.example.javarest.Models.Device;
import com.example.javarest.Models.Location;
import com.example.javarest.Models.Measurement;

import java.sql.*;

public class SendValuesToDB {
    private Connection con = SQLConnector.GetConnected();

    int locationId;
    int deviceId;

    public void Location(Location location){
        String query = "BEGIN\n" +
                "    DECLARE @longitude varchar(100);\n" +
                "    DECLARE @latitude varchar(100);\n" +
                "    SET @longitude = ?;\n" +
                "    SET @latitude = ?;\n" +
                "    IF NOT EXISTS (SELECT locationId FROM Location WHERE Longitude = @longitude AND Latitude = @latitude)\n" +
                "    BEGIN\n" +
                "        INSERT INTO Location(Longitude, Latitude) VALUES (@longitude, @latitude)\n" +
                "    END\n" +
                "END";
        try {
            PreparedStatement statement = this.con.prepareStatement(query);
            statement.setString(1, location.getLongitude());
            statement.setString(2, location.getLatitude());
            ResultSet result = statement.executeQuery();
            while(result.next()){
                System.out.println("location id: " + result.getInt(1));
                this.locationId = result.getInt(1);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void Device(Device device){
        String query = "BEGIN\n" +
                "    DECLARE @devicename varchar(100);\n" +
                "    DECLARE @mcuType varchar(100);\n" +
                "    DECLARE @sensor varchar(100);\n" +
                "    SET @devicename = ?;\n" +
                "    SET @mcuType = ?;\n" +
                "    SET @sensor = ?;\n" +
                "    IF NOT EXISTS (SELECT deviceId FROM Device WHERE deviceName = @deviceName)\n" +
                "    BEGIN\n" +
                "        INSERT INTO Device(devicename, mcuType, sensor) VALUES (@devicename, @mcuType, @sensor)\n" +
                "    END\n" +
                "END";
        try {
            PreparedStatement statement = this.con.prepareStatement(query);
            statement.setString(1, device.getDeviceName());
            statement.setString(2, device.getMcuType());
            statement.setString(3, device.getSensor());
            ResultSet result = statement.executeQuery();
            while(result.next()){
                System.out.println("device id: " + result.getInt(1));
                this.deviceId = result.getInt(1);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void Measurments(Measurement measurement){
        String query = "INSERT INTO Measurement VALUES(?,?,?,?,?)";
        try {
            PreparedStatement statement = this.con.prepareStatement(query);
            statement.setInt(1, this.deviceId);
            statement.setInt(2, this.locationId);
            statement.setString(3, measurement.getMeasurementTime());
            statement.setDouble(4, measurement.getTemperature());
            statement.setDouble(5, measurement.getHumidity());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
