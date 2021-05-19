package com.example.javarest.Models;

public class JoinedData {
    long measurementTime;
    double temperature;
    double humidity;
    String deviceName;
    String locationName;

    public JoinedData(long measurementTime, double temperature, double humidity, String deviceName, String locationName) {
        this.measurementTime = measurementTime;
        this.temperature = temperature;
        this.humidity = humidity;
        this.deviceName = deviceName;
        this.locationName = locationName;
    }

    public long getMeasurementTime() {
        return measurementTime;
    }

    public void setMeasurementTime(long measurementTime) {
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

    public String getDeviceName() {
        return deviceName;
    }

    public void setDeviceName(String deviceName) {
        this.deviceName = deviceName;
    }

    public String getLocationName() {
        return locationName;
    }

    public void setLocationName(String locationName) {
        this.locationName = locationName;
    }
}
