package com.example.shujany.VehicleRentalStore.VehicleRentalStore;

public class Capacity {
    private int seatCapacity;
    private String engineCapacity;

    public Capacity(int seatCapacity, String engineCapacity) {
        this.seatCapacity = seatCapacity;
        this.engineCapacity = engineCapacity;
    }

    //method to retrieve the Number of seats
    public int getSeatCapacity() {
        return seatCapacity;
    }

    //method to set the Number of seats
    public void setSeatCapacity(int seatCapacity) {
        this.seatCapacity = seatCapacity;
    }

    //method to retrieve the Engine Capacity
    public String getEngineCapacity() {
        return engineCapacity;
    }

    //method to set the Engine Capacity
    public void setEngineCapacity(String engineCapacity) {
        this.engineCapacity = engineCapacity;
    }

    @Override
    public String toString() {
        return "Capacity{" +
                "seatCapacity=" + seatCapacity +
                ", engineCapacity='" + engineCapacity + '\'' +
                '}';
    }

}
