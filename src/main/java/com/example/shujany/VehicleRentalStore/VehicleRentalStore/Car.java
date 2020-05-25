package com.example.shujany.VehicleRentalStore.VehicleRentalStore;

public class Car extends Vehicle {
    private int noOfDoors;
    private boolean haveAirBag;

    public Car() {

    }

    public Car(int noOfDoors, boolean haveAirBag) {
        this.noOfDoors = noOfDoors;
        this.haveAirBag = haveAirBag;
    }

    public Car(String vehicleNoPlate, String make, String model, Capacity capacity, boolean available, Schedule schedule, int noOfDoors, boolean haveAirBag) {
        super(vehicleNoPlate, make, model, capacity, available, schedule);
        this.noOfDoors = noOfDoors;
        this.haveAirBag = haveAirBag;
    }

    //method to retrieve the Number of Doors
    public int getNoOfDoors() { return noOfDoors; }

    //method to set the Number of Doors
    public void setNoOfDoors(int noOfDoors) { this.noOfDoors = noOfDoors; }

    public boolean isHaveAirBag() { return haveAirBag; }

    public void setHaveAirBag(boolean haveAirBag) { this.haveAirBag = haveAirBag; }

    @Override
    public String toString() {
        return "Car{" +
                "noOfDoors=" + noOfDoors +
                ", haveAirBag=" + haveAirBag +
                '}';
    }
}
