package com.example.javarest.Models;

public class Device {
    String deviceName;
    String mcuType;
    String sensor;

    public Device(String deviceName, String mcuType, String sensor) {
        this.deviceName = deviceName;
        this.mcuType = mcuType;
        this.sensor = sensor;
    }

    public String getDeviceName() {
        return deviceName;
    }

    public void setDeviceName(String deviceName) {
        this.deviceName = deviceName;
    }

    public String getMcuType() {
        return mcuType;
    }

    public void setMcuType(String mcuType) {
        this.mcuType = mcuType;
    }

    public String getSensor() {
        return sensor;
    }

    public void setSensor(String sensor) {
        this.sensor = sensor;
    }
}
