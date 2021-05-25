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
        Device(payload.getDevice());
        Location(payload.getLocation());
        Measurements(payload.getMeasurement());
    }

    public boolean Location(Location location){
        int rowChanged = 0;
        String query = "insert ignore into location(locationName, longitude, latitude) value(?,?,?); ";
        String query1 = "select locationId from location where locationName = ?;";
        try {
            PreparedStatement statement = this.con.prepareStatement(query);

            statement.setString(1, location.getLocationName());
            statement.setString(2, location.getLongitude());
            statement.setString(3, location.getLatitude());
            rowChanged = statement.executeUpdate();

                statement = this.con.prepareStatement(query1);
                statement.setString(1, location.getLocationName());

                ResultSet result = statement.executeQuery();
                while(result.next()){
                    System.out.println("location id: " + result.getInt(1));
                    this.locationId = result.getInt(1);
                }
                return true;

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return false;
    }

    public boolean Device(Device device){
        int rowChanged = 0;
        String query = "insert ignore into device(deviceName, mcuType, sensor) value(?,?,?);";
        String query1 = "select deviceId from device where deviceName = ?;";
        try {
            PreparedStatement statement = this.con.prepareStatement(query);
            statement.setString(1, device.getDeviceName());
            statement.setString(2, device.getMcuType());
            statement.setString(3, device.getSensor());

            rowChanged = statement.executeUpdate();


                statement = this.con.prepareStatement(query1);
                statement.setString(1, device.getDeviceName());

                ResultSet result = statement.executeQuery();
                while(result.next()){
                    System.out.println("device id: " + result.getInt(1));
                    this.deviceId = result.getInt(1);
                }
                return true;


        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return false;
    }

    public void Measurements(Measurement measurement){
        String query = "INSERT INTO measurement(deviceId, locationId, measurementTime, temperature, humidity) VALUES(?,?,?,?,?)";
        try {
            PreparedStatement statement = this.con.prepareStatement(query);
            System.out.println(this.deviceId + "  " + this.locationId);
            statement.setInt(1, this.deviceId);
            statement.setInt(2, this.locationId);

            statement.setLong(3, measurement.getMeasurementTime());
            statement.setDouble(4, measurement.getTemperature());
            statement.setDouble(5, measurement.getHumidity());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
