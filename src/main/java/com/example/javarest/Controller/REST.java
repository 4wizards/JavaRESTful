package com.example.javarest.Controller;

import com.example.javarest.Models.Message;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping("/api")
public class REST {

    List<Message> messages = new ArrayList<>();

    @CrossOrigin
    @PostMapping("/postvalue")
    public void Post(@RequestBody Message message){
        //hejhej
        //hejhej
        //hejhej
        messages.add(message);
    }

    @GetMapping("/getvalues")
    public List<Message> getmessages(){
        return messages;
    }


}
