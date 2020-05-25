package com.example.shujany.VehicleRentalStore.VehicleRentalStore;

public class MotorBike extends Vehicle {
    private int numberOfGears;
    private int noOfHelmets;
    private boolean rearDiskBreak;
    private boolean frontDiskBreak;

    public MotorBike (){

    }

    public MotorBike(String vehicleNoPlate, String make, String model, Capacity capacity, Schedule schedule, int numberOfGears, int noOfHelmets, boolean rearDiskBreak, boolean frontDiskBreak) {
        this.numberOfGears = numberOfGears;
        this.noOfHelmets = noOfHelmets;
        this.rearDiskBreak = rearDiskBreak;
        this.frontDiskBreak = frontDiskBreak;
    }

    public MotorBike(String vehicleNoPlate, String make, String model, Capacity capacity, boolean available, Schedule schedule, int numberOfGears, int noOfHelmets, boolean rearDiskBreak, boolean frontDiskBreak) {
        super(vehicleNoPlate, make, model, capacity, available, schedule);
        this.numberOfGears = numberOfGears;
        this.noOfHelmets = noOfHelmets;
        this.rearDiskBreak = rearDiskBreak;
        this.frontDiskBreak = frontDiskBreak;
    }


    //method to retrieve the Number of Gears
    public int getNumberOfGears() {
        return numberOfGears;
    }

    //method to set the Number of Gears
    public void setNumberOfGears(int numberOfGears) {
        this.numberOfGears = numberOfGears;
    }

    //method to retrieve the Number of Helmets
    public int getNoOfHelmets() {
        return noOfHelmets;
    }

    //method to set the Number of Helmets
    public void setNoOfHelmets(int noOfHelmets) {
        this.noOfHelmets = noOfHelmets;
    }

    public boolean isRearDiskBreak() {
        return rearDiskBreak;
    }

    public void setRearDiskBreak(boolean rearDiskBreak) {
        this.rearDiskBreak = rearDiskBreak;
    }

    public boolean isFrontDiskBreak() {
        return frontDiskBreak;
    }

    public void setFrontDiskBreak(boolean frontDiskBreak) {
        this.frontDiskBreak = frontDiskBreak;
    }

    @Override
    public String toString() {
        return "MotorBike{" +
                "numberOfGears=" + numberOfGears +
                ", noOfHelmets=" + noOfHelmets +
                ", rearDiskBreak=" + rearDiskBreak +
                ", frontDiskBreak=" + frontDiskBreak +
                '}'+super.toString();
    }
}
