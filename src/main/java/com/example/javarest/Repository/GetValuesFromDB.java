package com.example.javarest.Repository;

import com.example.javarest.Models.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class GetValuesFromDB {
    Measurement measurement;
    private Connection con = SQLConnector.GetConnected();

    public GetValuesFromDB(){
        //getMeasurementValues();
    }
    public List<JoinedData>GetLimitedValuesFromDB(String limitNumber)
    {
        List<JoinedData> joinedData = new ArrayList<>();

        String query = "select measurementTime, temperature, humidity from measurement";
        String query1 = "SELECT " +
                "measurement.measurementTime, " +
                "measurement.temperature, " +
                "measurement.humidity, " +
                "location.locationName, " +
                "device.deviceName " +
                "FROM heroku_ce7cafd7b067d97.measurement\n" +
                "JOIN device ON measurement.deviceId=device.deviceId\n" +
                "JOIN location ON measurement.locationId=location.locationId\n"+
                "order by measurementTime DESC LIMIT "+limitNumber
                ;
        try {
            PreparedStatement statement = this.con.prepareStatement(query1);
            ResultSet result = statement.executeQuery(query1);

            while(result.next()){
                joinedData.add(new JoinedData(
                        result.getLong("measurementTime"),
                        result.getDouble("temperature"),
                        result.getDouble("humidity"),
                        result.getString("locationName"),
                        result.getString("deviceName")

                ));

            }
            for (JoinedData dataItem : joinedData){
                System.out.println(dataItem.getTemperature() + " " + dataItem.getDeviceName());
            }

            return joinedData;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return null;
    }

    public List<Measurement> getMeasurementValues(){
        List<Measurement> measurementList = new ArrayList<>();

        String query = "select measurementTime, temperature, humidity from measurement";
        String query1 = "SELECT measurement.measurementTime, measurement.temperature, measurement.humidity, location.locationName, device.deviceName FROM heroku_ce7cafd7b067d97.measurement\n" +
                "JOIN device ON measurement.deviceId=device.deviceId\n" +
                "JOIN location ON measurement.locationId=location.locationId";
        try {
            PreparedStatement statement = this.con.prepareStatement(query);
            ResultSet result = statement.executeQuery(query);

            while(result.next()){
                measurementList.add(new Measurement(result.getLong("measurementTime"),
                        result.getDouble("temperature"), result.getDouble("humidity")));

            }
            for (Measurement dataItem : measurementList){
                System.out.println(dataItem.getTemperature());
            }


            return measurementList;
            //return measurementList;
    } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return null;
    }

    public List<JoinedData> getJoinedValues(){
        List<JoinedData> joinedData = new ArrayList<>();

        String query = "select measurementTime, temperature, humidity from measurement";
        String query1 = "SELECT " +
                "measurement.measurementTime, " +
                "measurement.temperature, " +
                "measurement.humidity, " +
                "location.locationName, " +
                "device.deviceName " +
                "FROM heroku_ce7cafd7b067d97.measurement\n" +
                "JOIN device ON measurement.deviceId=device.deviceId\n" +
                "JOIN location ON measurement.locationId=location.locationId\n"//+
                //"order by measurementTime DESC LIMIT 10"
                ;
        try {
            PreparedStatement statement = this.con.prepareStatement(query1);
            ResultSet result = statement.executeQuery(query1);

            while(result.next()){
                joinedData.add(new JoinedData(
                        result.getLong("measurementTime"),
                        result.getDouble("temperature"),
                        result.getDouble("humidity"),
                        result.getString("locationName"),
                        result.getString("deviceName")

                ));

            }
            for (JoinedData dataItem : joinedData){
                System.out.println(dataItem.getTemperature() + " " + dataItem.getDeviceName());
            }

            return joinedData;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return null;
    }
}

