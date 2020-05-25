package com.example.shujany.VehicleRentalStore.VehicleRentalStore;

public interface RentalVehicleManager {
    void addVehicle(Vehicle item);
    boolean deleteVehicle(String vehicleNoPlate);
    void printListOfVehicle();
    void saveVehicle();
    //void updateVehicle(Vehicle item);
    Vehicle search(String vehicleNoPLate);

}
