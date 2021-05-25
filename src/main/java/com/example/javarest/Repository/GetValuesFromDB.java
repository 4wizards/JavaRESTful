package com.example.javarest.Repository;

import com.example.javarest.Models.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class GetValuesFromDB {
    private Connection con = SQLConnector.GetConnected();

    public List<CombinedData>GetLimitedValuesFromDB(Optional<String> limitNumber)
    {
        List<CombinedData> combinedData = new ArrayList<>();

        String query = "SELECT " +
                "measurement.measurementTime, " +
                "measurement.temperature, " +
                "measurement.humidity, " +
                "location.locationName, " +
                "device.deviceName " +
                "FROM heroku_ce7cafd7b067d97.measurement\n" +
                "JOIN device ON measurement.deviceId=device.deviceId\n" +
                "JOIN location ON measurement.locationId=location.locationId\n"+
                "order by measurementTime DESC"
                 ;
        if (limitNumber.isPresent())
            query += " LIMIT "+limitNumber.get();

        try {
            PreparedStatement statement = this.con.prepareStatement(query);
            ResultSet result = statement.executeQuery(query);

            while(result.next()){
                combinedData.add(new CombinedData(
                        result.getLong("measurementTime"),
                        result.getDouble("temperature"),
                        result.getDouble("humidity"),
                        result.getString("locationName"),
                        result.getString("deviceName")
                ));
            }

            return combinedData;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}

