package com.example.shujany.VehicleRentalStore.VehicleRentalStore;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class WestminsterRentalVehicleManager implements RentalVehicleManager {
    private ArrayList<Vehicle> saveVehicle = new ArrayList<Vehicle>();
    private ArrayList<Vehicle> parkingSlot = new ArrayList<Vehicle>();
    private static final int MAXIMUM_COUNT = 50;
    Scanner input = new Scanner(System.in);  //Creating an object of Scanner class for input
    private int availableSpaces;   //initializing variable called availableSpaces
    int choice;

    DBManager db;

    public WestminsterRentalVehicleManager() {
        db = new DBManager();
        db.openConnection();
        parkingSlot = db.getItems();
        db.closeConnection();
    }


    @Override
    public void addVehicle(Vehicle item) {
        availableSpaces = MAXIMUM_COUNT - parkingSlot.size();
        System.out.println("No of vehicles you can add is " + availableSpaces);
        //System can store maximum 50 vehicles only
        if (parkingSlot.size() < MAXIMUM_COUNT) {
            parkingSlot.add(item);
            db.openConnection();
            db.addItem(item);
            db.closeConnection();
            //System.out.println(parkingSlot);
            System.out.println("\nVehicle Added Successfully\n");
        } else {
            System.out.println("\nNo slots left in parking area\n");
        }
    }


    @Override
    public boolean deleteVehicle(String vehicleNoPlate) {
        Vehicle item = null;
        for (int i = 0; i < parkingSlot.size(); i++) {
            if (parkingSlot.get(i).getVehicleNoPlate().equals(vehicleNoPlate)) {
                item = parkingSlot.get(i);
                break;
            }
        }
        if (parkingSlot.contains(item)) {
            db.openConnection();
            db.deleteItem(item);
            db.closeConnection();
            return parkingSlot.remove(item);

        } else {
            System.out.println("Vehicle not found");
        }
        return false;
    }

    @Override
    public void printListOfVehicle() {
        System.out.println("\nList of Cars\n");
        db.openConnection();
        parkingSlot = db.getItems();
        db.closeConnection();
        for (Vehicle item : parkingSlot) {
            if (item instanceof Car) {
                System.out.println(item);
            }
        }

        System.out.println("\nList of MotorBikes\n");
        for (Vehicle item : parkingSlot) {
            if (item instanceof MotorBike) {
                System.out.println(item);
            }
        }

    }

    @Override
    public void saveVehicle() {
        //File f = new File("test.txt");
        for (int a = 0; a < saveVehicle.size(); a++) {
            for (Vehicle obj : saveVehicle) {
                try {
                    FileWriter fw = new FileWriter("test2.txt", true);
                    BufferedWriter out = new BufferedWriter(fw);
                    out.write(" Vehicle:" + obj.getClass().getSimpleName() + " Make:" + saveVehicle.get(a).getMake() + " Model:" + saveVehicle.get(a).getModel() + " Capacity:" + saveVehicle.get(a).getCapacity() + " PlateNo:" + saveVehicle.get(a).getVehicleNoPlate() + " Schedule:" + saveVehicle.get(a).getSchedule());
                    out.newLine();
                    out.close();

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }

    }


    @Override
    public Vehicle search(String vehicleNoPLate) {
        for(int i=0;i<parkingSlot.size();i++){
            if(parkingSlot.get(i).getVehicleNoPlate().equals(vehicleNoPLate))
            {
                return parkingSlot.get(i);
            }
        }
        return null;

    }
    public List<Vehicle> vehicles () {
        return parkingSlot;
    }

    public static Comparator<Vehicle> compare = new Comparator<Vehicle>() {
        @Override
        public int compare(Vehicle o1, Vehicle o2) {
            String vehicle1 = o1.getMake();
            String vehicle2 = o2.getMake();
            return vehicle1.compareTo(vehicle2);
        }
    };

}
