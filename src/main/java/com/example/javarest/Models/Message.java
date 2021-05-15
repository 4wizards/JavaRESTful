package com.example.javarest.Models;

public class Message {
    private String temp;
    private String hum;


    public Message(String temp, String hum){
        setTemp(temp);
        setHum(hum);
    }

    public String getTemp() {
        return temp;
    }

    public void setTemp(String temp) {
        this.temp = temp;
    }

    public String getHum() {
        return hum;
    }

    public void setHum(String hum) {
        this.hum = hum;
    }
}
