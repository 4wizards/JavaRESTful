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

        String insertQuery = "insert ignore into location(locationName, longitude, latitude) value(?,?,?); ";
        String selectQuery = "select locationId from location where locationName = ?;";
        try {
            PreparedStatement statement = this.con.prepareStatement(insertQuery);

            statement.setString(1, location.getLocationName());
            statement.setString(2, location.getLongitude());
            statement.setString(3, location.getLatitude());
            statement.executeUpdate();

            //next statement query
            statement = this.con.prepareStatement(selectQuery);
            statement.setString(1, location.getLocationName());

            ResultSet result = statement.executeQuery();
            while(result.next()){

                //Uncomment to print to console
                //System.out.println("location id: " + result.getInt(1));

                this.locationId = result.getInt(1);
            }
            return true;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean Device(Device device){
        String insertQuery = "insert ignore into device(deviceName, mcuType, sensor) value(?,?,?);";
        String selectQuery = "select deviceId from device where deviceName = ?;";
        try {
            PreparedStatement statement = this.con.prepareStatement(insertQuery);
            statement.setString(1, device.getDeviceName());
            statement.setString(2, device.getMcuType());
            statement.setString(3, device.getSensor());
            statement.executeUpdate();

            //next statement query
            statement = this.con.prepareStatement(selectQuery);
            statement.setString(1, device.getDeviceName());

            ResultSet result = statement.executeQuery();
            while(result.next()){

                //Uncomment to print to console
                //System.out.println("device id: " + result.getInt(1));

                this.deviceId = result.getInt(1);
            }
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
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
