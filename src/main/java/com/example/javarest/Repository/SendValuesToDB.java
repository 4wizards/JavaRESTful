package com.example.javarest.Repository;

import com.example.javarest.Models.Device;
import com.example.javarest.Models.Location;
import com.example.javarest.Models.Measurement;
import com.example.javarest.Models.Message;

import java.sql.*;

public class SendValuesToDB {
    private Connection con = SQLConnector.GetConnected();

    int locationId;
    int deviceId;

    public SendValuesToDB(Message payload) {
        Location(payload.getLocation());
        Device(payload.getDevice());
        Measurements(payload.getMeasurement());
    }

    public void Location(Location location){
        String query = "IF NOT EXISTS " +
                "(SELECT locationId FROM Location WHERE Longitude = ? AND Latitude = ?)\n" +
                "    ELSE INSERT INTO Location(Longitude, Latitude) VALUES (?, ?)";
        try {
            PreparedStatement statement = this.con.prepareStatement(query);
            statement.setString(1, location.getLongitude());
            statement.setString(2, location.getLatitude());
            statement.setString(3, location.getLongitude());
            statement.setString(4, location.getLatitude());
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
        //String query = "IF NOT EXISTS (SELECT deviceId FROM Device WHERE deviceName = ?) INSERT INTO Device(devicename, mcuType, sensor) VALUES (?, ?, ?)";
        String query = "insert ignore into device(deviceName, mcuType, sensor)\n" +
                "value(?,?,?);\n" +
                "select\n" +
                "    deviceId\n" +
                "from\n" +
                "    device\n" +
                "where\n" +
                "    deviceName = ?;";
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

    public void Measurements(Measurement measurement){
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
