package com.example.javarest.Models;

public class Message {
    private String temp;
    private String hum;
    private String date;


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

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
