package com.example.shujany.VehicleRentalStore.VehicleRentalStore;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@SpringBootApplication
@RestController
@RequestMapping("/api/vehicle")
public class Console extends WestminsterRentalVehicleManager {
    public static WestminsterRentalVehicleManager westminsterRentalVehicleManager;
    public static void main(String[] args) {
        WestminsterRentalVehicleManager manager = new WestminsterRentalVehicleManager();
        //Creating an object of Scanner class for input
        Scanner input = new Scanner(System.in);
        //Creating an integer variable called option to deal with the user selections.
        int option;
        do {
            //User Selection Part
            System.out.println("Welcome to Westminster Vehicle Rental System");
            System.out.println("What you like to do:");
            System.out.println("\t1. Add Vehicle");
            System.out.println("\t2. Delete Vehicle");
            System.out.println("\t3. Print List of Vehicles");
            System.out.println("\t4. Save Vehicle");
            //System.out.println("\t5. Update Vehicle");
            System.out.println("\t5. Search for Vehicle");
            System.out.println("\t6. Graphical User Interface");
            System.out.println("\t7. Spring");
            System.out.println("\t8. Exit Westminster Vehicle Rental Store");
            System.out.print(" Enter Option : ");
            option = input.nextInt();

            if (option == 1) {
                //Selection Part for Vehicle Type (Car/ Bike)
                System.out.println("Select Vehicle Type:");
                System.out.println("1.Car");
                System.out.println("2.Motorbike");
                option = input.nextInt();
                int yearDate = 0;
                if (option == 1) {

                    System.out.println("Enter Vehicle Plate Number:");
                    String vehicleNoPlate = input.next();

                    System.out.println("Enter Vehicle Make:");
                    String make = input.next();

                    System.out.println("Enter Vehicle Model:");
                    String model = input.next();

                    System.out.print("Enter the seat capacity:");
                    while (!input.hasNextInt()) {
                        System.out.println("Invalid Input!!! Please enter a number: ");
                        input.next();
                    }
                    int seat = input.nextInt();

                    System.out.print("Enter the engine capacity:");
                    String engine = input.next();
                    Capacity capacity = new Capacity(seat, engine);

                    System.out.println("Enter if Car is Air Conditioned or not:");
                    System.out.print("Enter 'True' or 'False':");
                    while (!input.hasNextBoolean()) {
                        System.out.println("Invalid Input!!! Please enter True or False: ");
                        input.next();
                    }
                    boolean AC = input.nextBoolean();

                    System.out.println("Enter No.of.Doors");
                    while (!input.hasNextInt()) {
                        System.out.println("Invalid Input!!! Please enter a number: ");
                        input.next();
                    }
                    int noOfDoors = input.nextInt();

                    System.out.println("Enter if Car has AirBag");
                    System.out.print("Enter 'True' or 'False':");
                    while (!input.hasNextBoolean()) {
                        System.out.println("Invalid Input!!! Please enter True or False: ");
                        input.next();
                    }
                    boolean airBag = input.nextBoolean();

                    System.out.println("Enter Date:");
                    int day = 0;
                    int month = 0;

                    for (int a = 0; a <= 1; a++) {
                        System.out.print("Enter the Day:");
                        day = input.nextInt();
                        if (day >= 1 && day <= 31) {
                            a = 1;
                        } else {
                            System.out.println("Invalid Day");
                            a = 0;
                        }
                    }

                    for (int b = 0; b <= 1; b++) {
                        System.out.print("Enter the Month:");
                        month = input.nextInt();

                        if (month >= 1 && month <= 12) {
                            b = 1;
                        } else {
                            System.out.println("Invalid Month");
                            b = 0;
                        }
                    }
                    System.out.print("Enter the Year:");
                    while (!input.hasNextInt()) {
                        System.out.println("Invalid Input!!! Please enter a number: ");
                        input.next();
                    }
                    yearDate = input.nextInt();

                    Date date = new Date(day, month, yearDate);
                    //Schedule schedule = new Schedule(date);
                    Date pickup=new Date("2019-10-10");
                    Date dropDate=new Date("2019-10-06");
                    Schedule schedule = new Schedule(date,pickup,dropDate);

                    //Creating a Car Object
                    Car car = new Car(vehicleNoPlate,make,model,capacity,AC,schedule,noOfDoors,airBag);
                    manager.addVehicle(car);



                } else if (option == 2) {
                    System.out.println("Enter Vehicle Number Plate:");
                    String vehicleNoPlate = input.next();

                    System.out.println("Enter Vehicle Make:");
                    String make = input.next();

                    System.out.println("Enter Vehicle Model:");
                    String model = input.next();

                    System.out.print("Enter the seat capacity:");
                    while (!input.hasNextInt()) {
                        System.out.println("Invalid Input!!! Please enter a number: ");
                        input.next();
                    }
                    int seat = input.nextInt();

                    System.out.print("Enter the engine capacity:");
                    String engine = input.next();
                    Capacity capacity = new Capacity(seat, engine);

                    System.out.print("Enter the noOfGears:");
                    while (!input.hasNextInt()) {
                        System.out.println("Invalid Input!!! Please enter a number: ");
                        input.next();
                    }
                    int noOfGears = input.nextInt();

                    System.out.print("Enter the noOfHelmets:");
                    while (!input.hasNextInt()) {
                        System.out.println("Invalid Input!!! Please enter a number: ");
                        input.next();
                    }
                    int noOfHelmets = input.nextInt();

                    System.out.println("Enter whether MotorBike have rearDiskBreak or not:");
                    System.out.print("Enter 'True' or 'False':");
                    while (!input.hasNextBoolean()) {
                        System.out.println("Invalid Input!!! Please enter True or False: ");
                        input.next();
                    }
                    boolean rearDiskBreak = input.nextBoolean();

                    System.out.println("Enter whether MotoBike have frontDiskBreak or not:");
                    System.out.print("Enter 'True' or 'False':");
                    while (!input.hasNextBoolean()) {
                        System.out.println("Invalid Input!!! Please enter True or False: ");
                        input.next();
                    }
                    boolean frontDiskBreak = input.nextBoolean();

                    System.out.println("Enter Date:");
                    int day = 0;
                    int month = 0;

                    for (int a = 0; a <= 1; a++) {
                        System.out.print("Enter the Day:");
                        day = input.nextInt();
                        if (day >= 1 && day <= 31) {
                            a = 1;
                        } else {
                            System.out.println("Invalid Day");
                            a = 0;
                        }
                    }


                    for (int b = 0; b <= 1; b++) {
                        System.out.print("Enter the month:");
                        month = input.nextInt();

                        if (month >= 1 && month <= 12) {
                            b = 1;
                        } else {
                            System.out.println("Invalid Month");
                            b = 0;
                        }
                    }
                    System.out.print("Enter the Year:");
                    while (!input.hasNextInt()) {
                        System.out.println("Invalid Input!!! Please enter a number: ");
                        input.next();
                    }
                    yearDate = input.nextInt();

                    Date date = new Date(day, month, yearDate);
                   // Schedule schedule = new Schedule(date);
                    Date pickup=new Date("2019-10-10");
                    Date dropDate=new Date("2019-10-06");
                    Schedule schedule = new Schedule(date,pickup,dropDate);

                    //Creating a MotorBike Object
                    MotorBike bike = new MotorBike(vehicleNoPlate, make, model, capacity, schedule, noOfGears, noOfHelmets, rearDiskBreak, frontDiskBreak);
                    manager.addVehicle(bike);

                } else {
                    System.out.println("You have entered invalid option");
                }
            } else if (option == 2) {
                System.out.println("Enter the Vehicle Number Plate:");
                String vehicleNoPlate = input.next();
                try {
                    manager.deleteVehicle(vehicleNoPlate);
                    System.out.println("Vehicle No:"+vehicleNoPlate+ "is deleted  deleted Successfully from the store");
                } catch ( Exception e) {
                    System.out.println("Vehicle No:"+vehicleNoPlate+ " is not found in the store");
                }

            } else if (option == 3) {
                manager.printListOfVehicle();


            } else if (option == 4) {
                manager.saveVehicle();


           // } else if (option == 5) {
               //manager.updateVehicle();


            } else if (option == 5) {
                System.out.println("Enter vehicle Number Plate");
                String vehicleNoPlate = input.next();
                Vehicle m = manager.search(vehicleNoPlate);
                if (m != null) {
                    System.out.println("Vehicle Details"+ m);
                } else {
                    System.out.println("Vehicle not found");
                }

            } else if (option == 6) {

            }

            else if (option == 7) {
                SpringApplication.run(VehicleRentalStoreApplication.class, args);

            }
            else if (option == 8) {
                exVehicle();
            } else {
                System.out.println("You have entered an invalid choice");

            }
        } while (option >= 1 && option <= 8);
    }

    private static void exVehicle() {
        Scanner exit = new Scanner(System.in);
        System.out.println("Are you sure you want to exit Westminster Vehicle Rental Store? Y/N");
        String exVehicle = exit.next();
        if (exVehicle.toUpperCase().equals("Y")) {
            System.out.println("Thanks for using Westminster Vehicle Rental Store\nCome Again");
            System.exit(0);
        }


    }



    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/list")
    public ArrayList<Vehicle> vehicleList() {
         return (ArrayList<Vehicle>) new WestminsterRentalVehicleManager().vehicles();
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/delete")
    public String delete(@RequestParam String no) {
         boolean result = new WestminsterRentalVehicleManager().deleteVehicle(no);
         if(result){

             return "Deleted successfully";
         }
         else{
             return "unable to delete";
         }
    }
    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping ("/searchVehicle")
    public List<Vehicle> searchVehicle(@RequestParam String no){
        List<Vehicle> arr = new ArrayList<Vehicle>();
        Vehicle result= new WestminsterRentalVehicleManager().search(no);
        if(result!=null){
            arr.add(result);
        }
        return arr;
    }


    @ResponseBody
    @PostMapping("/add/Car")
    public String addCar(@RequestParam String no, String make,String model,String engineCapacity,String seatCapacity,String isAirConditioned, String noOfDoors,String airBag, String date, String picUpDate, String dropOfDate )
    {
        return (no + make + model + engineCapacity + seatCapacity+ isAirConditioned+ noOfDoors + date +picUpDate +dropOfDate);

    }

    @ResponseBody
    @PostMapping("/add/Bike")
    public String addBike(@RequestParam String no, String make,String model,String engineCapacity,String seatCapacity,String noOfGears, String noOfHelmets, String rearDiskBreak, String frontDiskBreak, String date, String picUpDate, String dropOfDate )
    {
        return (no + make + model + engineCapacity + seatCapacity+ noOfGears  + noOfHelmets+ rearDiskBreak+ frontDiskBreak+ date +picUpDate +dropOfDate);

    }


}
