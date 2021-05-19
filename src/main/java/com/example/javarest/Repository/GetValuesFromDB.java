package com.example.javarest.Repository;

import com.example.javarest.Models.Device;
import com.example.javarest.Models.Location;
import com.example.javarest.Models.Measurement;
import com.example.javarest.Models.Message;

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






    public List<Measurement> getMeasurementValues(){
        List<Measurement> measurementList = new ArrayList<>();

        String query = "select measurementTime, temperature, humidity from measurement";
        String query1 = "";
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
}
