package com.example.javarest.Controller;

import com.example.javarest.Models.JoinedData;
import com.example.javarest.Models.Measurement;
import com.example.javarest.Models.Message;
import com.example.javarest.Repository.GetValuesFromDB;
import com.example.javarest.Repository.SendValuesToDB;
import com.example.javarest.Repository.TestConnection;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping("/api")
public class REST {

    List<Integer> messages = new ArrayList<>();


    @CrossOrigin
    @PostMapping("/postvalue")
    public void Post(@RequestBody Message payload){
        new SendValuesToDB(payload);
    }

    @CrossOrigin
    @GetMapping("/getvalues")
    //public List<Measurement> getmessages() throws SQLException {
    public List<JoinedData> getmessages() throws SQLException {
        GetValuesFromDB values = new GetValuesFromDB();
        return values.getJoinedValues();
        //return messages;
    }
    @CrossOrigin
    @GetMapping("/getvalues/{limit}")
    public void getmessages(@PathVariable String limit) throws SQLException {
        System.out.println(limit);
        TestConnection test = new TestConnection();

        //return messages;
    }


}
