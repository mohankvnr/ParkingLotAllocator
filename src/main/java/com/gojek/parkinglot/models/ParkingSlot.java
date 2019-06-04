package com.gojek.parkinglot.models;

/**
 * Created by Mohan Kotla on 01/June/2019
 */

public class ParkingSlot {
    private String vehicleNumber;
    private String color;
    private Boolean occupied ;
    public ParkingSlot() {
    }

    public ParkingSlot(String vehicleNumber, String color, Boolean occupied) {
        this.vehicleNumber = vehicleNumber;
        this.color = color;
        this.occupied = occupied;
    }

    public String getVehicleNumber() {
        return vehicleNumber;
    }

    public void setVehicleNumber(String vehicleNumber) {
        this.vehicleNumber = vehicleNumber;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Boolean getOccupied() {
        return occupied;
    }

    public void setOccupied(Boolean occupied) {
        this.occupied = occupied;
    }
}
