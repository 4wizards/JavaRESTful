package com.example.javarest.Controller;

import com.example.javarest.Repository.Property;
import io.github.cdimascio.dotenv.Dotenv;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Properties;

@RestController
public class NOREST {

    @GetMapping ("/")
    public String index() {

        return "<marquee direction=\"down\" width=\"250\" height=\"200\" behavior=\"alternate\" style=\"border:solid\">\n" +
                "  <marquee behavior=\"alternate\">hejsansvejsan</marquee>";
    }

    @GetMapping ("/env")
    public void env() {
    new Property();

    }
}
