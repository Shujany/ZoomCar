package com.example.shujany.VehicleRentalStore.VehicleRentalStore;

import java.util.Objects;

public class Vehicle {
    private String vehicleNoPlate;
    private String make;
    private String model;
    private Capacity capacity;
    private boolean available;
    private Schedule schedule;

    public Vehicle() {
    }

    public Vehicle(String vehicleNoPlate, String make, String model, Capacity capacity, boolean available, Schedule schedule) {
        this.vehicleNoPlate = vehicleNoPlate;
        this.make = make;
        this.model = model;
        this.capacity = capacity;
        this.available = available;
        this.schedule = schedule;
    }

    //method to retrieve the VehicleNoPlate
    public String getVehicleNoPlate() { return vehicleNoPlate; }

    //method to set the VehicleNoPlate
    public void setVehicleNoPlate(String vehicleNoPlate) { this.vehicleNoPlate = vehicleNoPlate; }

    //method to retrieve the make
    public String getMake() { return make; }

    //method to set the make
    public void setMake(String make) { this.make = make; }

    //method to retrieve the model
    public String getModel() { return model; }

    //method to set the model
    public void setModel(String model) { this.model = model; }

    //method to retrieve the capacity
    public Capacity getCapacity() { return capacity; }

    //method to set capacity
    public void setCapacity(Capacity capacity) { this.capacity = capacity; }

    public boolean isAvailable() { return available; }

    public void setAvailable(boolean available) { this.available = available; }

    //method to retrieve the schedule
    public Schedule getSchedule() { return schedule; }

    public String getScheduleText(){return schedule.toString();}

    public void setSchedule(Schedule schedule) { this.schedule = schedule; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Vehicle)) return false;
        Vehicle vehicle = (Vehicle) o;
        return isAvailable() == vehicle.isAvailable() &&
                getVehicleNoPlate().equals(vehicle.getVehicleNoPlate()) &&
                getMake().equals(vehicle.getMake()) &&
                getModel().equals(vehicle.getModel()) &&
                getCapacity().equals(vehicle.getCapacity()) &&
                Objects.equals(getSchedule(), vehicle.getSchedule());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getVehicleNoPlate(), getMake(), getModel(), getCapacity(), isAvailable(), getSchedule());
    }

    @Override
    public String toString() {
        return "Vehicle{" +
                "vehicleNoPlate='" + vehicleNoPlate + '\'' +
                ", make='" + make + '\'' +
                ", model='" + model + '\'' +
                ", capacity=" + capacity +
                ", available=" + available +
                ", schedule=" + schedule +
                '}';
    }
}
