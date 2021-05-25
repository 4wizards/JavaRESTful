package com.example.javarest.Controller;

import com.example.javarest.Models.CombinedData;
import com.example.javarest.Models.Message;
import com.example.javarest.Repository.GetValuesFromDB;
import com.example.javarest.Repository.SendValuesToDB;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/api")
public class REST {

    @CrossOrigin
    @PostMapping("/postvalue")
    public void Post(@RequestBody Message payload){
        new SendValuesToDB(payload);
    }

    @CrossOrigin
    @GetMapping(path = {"/getvalues","/getvalues/{limit}"})
    public List<CombinedData> listLimiterFunc(@PathVariable("limit") Optional<String> limit)
    {
        GetValuesFromDB values = new GetValuesFromDB();
        return values.GetLimitedValuesFromDB(limit);
    }
}
