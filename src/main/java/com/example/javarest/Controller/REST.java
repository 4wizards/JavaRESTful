package com.example.javarest.Controller;

import com.example.javarest.Models.JoinedData;
import com.example.javarest.Models.Message;
import com.example.javarest.Repository.GetValuesFromDB;
import com.example.javarest.Repository.SendValuesToDB;
import com.mysql.cj.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;


@RestController
@RequestMapping("/api")
public class REST {

    @CrossOrigin
    @PostMapping("/postvalue")
    public void Post(@RequestBody Message payload){
        new SendValuesToDB(payload);
    }

    @CrossOrigin
    @GetMapping("/getvalues")
    public List<JoinedData> getmessages() throws SQLException {
        GetValuesFromDB values = new GetValuesFromDB();
        return values.getJoinedValues();
    }

    @CrossOrigin
    @GetMapping("/getvalues/{limit}")
    public List<JoinedData> listLimiterFunc(@PathVariable String limit)
    {
        GetValuesFromDB values = new GetValuesFromDB();
        if(StringUtils.isStrictlyNumeric(limit)){
            System.out.println("print list limited to "+limit);
            return values.GetLimitedValuesFromDB(limit);
        }
        else return values.getJoinedValues();

    }
}
