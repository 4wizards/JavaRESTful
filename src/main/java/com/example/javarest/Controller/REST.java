package com.example.javarest.Controller;

import com.example.javarest.Models.Message;
import com.example.javarest.Repository.TestConnection;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping("/api")
public class REST {

    List<Integer> messages = new ArrayList<>();

    /*
    @CrossOrigin
    @PostMapping("/postvalue")
    public void Post(@RequestBody Message message){
        messages.add(message);
    }*/

    @GetMapping("/getvalues")
    public void getmessages() throws SQLException {
        TestConnection test = new TestConnection();

        //return messages;
    }

    @GetMapping("/getvalues/{limit}")
    public void getmessages(@PathVariable String limit) throws SQLException {
        System.out.println(limit);
        TestConnection test = new TestConnection();

        //return messages;
    }


}
