package com.example.javarest.Models;


public class Message {
    Device device;
    Measurement measurement;
    Location location;

    public Message(Device device, Location location, Measurement measurement) {
        this.device = device;
        this.measurement = measurement;
        this.location = location;
    }

    public Device getDevice() {
        return device;
    }

    public void setDevice(Device device) {
        this.device = device;
    }

    public Measurement getMeasurement() {
        return measurement;
    }

    public void setMeasurement(Measurement measurement) {
        this.measurement = measurement;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }
}
