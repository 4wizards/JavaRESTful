package com.example.javarest.Models;

public class Measurement {
    String measurementTime;
    double temperature;
    double humidity;

    public Measurement(String measurementTime, double temperature, double humidity) {
        this.measurementTime = measurementTime;
        this.temperature = temperature;
        this.humidity = humidity;
    }

    public String getMeasurementTime() {
        return measurementTime;
    }

    public void setMeasurementTime(String measurementTime) {
        this.measurementTime = measurementTime;
    }

    public double getTemperature() {
        return temperature;
    }

    public void setTemperature(double temperature) {
        this.temperature = temperature;
    }

    public double getHumidity() {
        return humidity;
    }

    public void setHumidity(double humidity) {
        this.humidity = humidity;
    }
}
