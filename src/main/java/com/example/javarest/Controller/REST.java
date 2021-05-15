package com.example.javarest.Controller;

import com.example.javarest.Models.Message;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api")
public class REST {

    @CrossOrigin
    @PostMapping("/addvalue")
    public Message Post(@RequestBody Message message){
        System.out.println(message.getTemp());
        Message newMessage = new Message("hej!", "va duktiga ni är");
        return  newMessage;
    }
}
