package com.example.javarest.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class REST {
    @RequestMapping("/")
    public String index() {
        return "Hejsansvejsan";

    }
}
