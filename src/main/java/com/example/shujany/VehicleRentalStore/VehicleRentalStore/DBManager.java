package com.example.shujany.VehicleRentalStore.VehicleRentalStore;

import java.sql.*;
import java.util.ArrayList;




public class DBManager {
    //public static void main(String[]args){
        //try{
            //Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
           // DBManager db = new DBManager();
            //db.openConnection();

    private Connection conn;

    public void openConnection(){
        try {
            String driverName = "com.mysql.cj.jdbc.Driver";
            Class.forName(driverName).newInstance();

            String severName = "localhost";
            String mydatabase = "rental_manager";
            String url = "jdbc:mysql://" + severName + "/" + mydatabase + "?serverTimezone=UTC";

            String username = "root";
            String password = "";
            conn = DriverManager.getConnection(url, username, password);
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }



    }
    public void addItem(Vehicle m) {
        System.out.println(m instanceof Car);
        if (m instanceof Car) {
            String sql = "INSERT INTO `items`(`vehicleNoPlate`, `make`, `model`, `seatCapacity`, `enginecapacity`,`AC`, `date`, `pickUpDate`, `dropOfDate`, `noOfDoors`,`airBag`,`type`)  VALUES " +
                    "(?,?,?,?,?,?,?,?,?,?,?,?)";
            try {
                Car c = (Car) m;
                PreparedStatement ps = conn.prepareStatement(sql);
                ps.setString(1, c.getVehicleNoPlate());
                ps.setString(2, c.getMake());
                ps.setString(3, c.getModel());
                ps.setInt(4, c.getCapacity().getSeatCapacity());
                ps.setString(5, c.getCapacity().getEngineCapacity());
                ps.setBoolean(6, c.isAvailable());
                ps.setString(7, c.getSchedule().getDateString());
                ps.setString(8, c.getSchedule().getPickUpDateOfVehicleString());
                ps.setString(9, c.getSchedule().getDeliveryDateOfVehicleString());
                ps.setInt(10, c.getNoOfDoors());
                ps.setBoolean(11, c.isHaveAirBag());
                ps.setInt(12,1);
                ps.executeUpdate();
            } catch (Exception e) {
                System.out.println("error"+e);
                //System.out.println(sql);
            }
        } else {
            String sql = "INSERT INTO `items`(`vehicleNoPlate`, `make`, `model`, `seatCapacity`, `engineCapacity`,`date`,`pickUpDate`,`dropOfDate`` noOfGears`,` noOfHelmets`,`rearDiskBreak`,`frontDiskBreak`,` type`) VALUES " +
                    "(?,?,?,?,?,?,?,?,?,?,?,?,?)";


            try {
                MotorBike c = (MotorBike) m;

                PreparedStatement ps = conn.prepareStatement(sql);
                ps.setString(1, c.getVehicleNoPlate());
                ps.setString(2, c.getMake());
                ps.setString(3, c.getModel());
                ps.setString(5, c.getCapacity().getEngineCapacity());
                ps.setInt(4, c.getCapacity().getSeatCapacity());
                ps.setString(6, c.getScheduleText());
                ps.setString(7, c.getSchedule().getPickUpDateOfVehicleString());
                ps.setString(8, c.getSchedule().getDeliveryDateOfVehicleString());
                ps.setInt(9, c.getNumberOfGears());
                ps.setInt(10, c.getNoOfHelmets());
                ps.setBoolean(11, c.isRearDiskBreak());
                ps.setBoolean(12, c.isFrontDiskBreak());
                ps.setInt(13, 2);
                ps.executeUpdate();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }


        }

    }
    public void deleteItem(Vehicle m) {
        try
        {
            String query = "DELETE FROM items WHERE vehicleNoPlate = ?";
            PreparedStatement preparedStmt = conn.prepareStatement(query);
            preparedStmt.setString(1, m.getVehicleNoPlate());
            preparedStmt.execute();
            conn.close();
        }
        catch (Exception e){
            System.out.println(e);
        }
    }

    public ArrayList<Vehicle> getItems(){
        ArrayList<Vehicle> mi = new ArrayList<>();
        try{
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("select * from items");
            while(rs.next()){
                String vehicleNoPlate = rs.getString("vehicleNoPlate");
                String make= rs.getString("make");
                String model= rs.getString("model");
                String engineCapacity=rs.getString("engineCapacity");
                int seatCapacity=rs.getInt("seatCapacity");
                String date= rs.getString("date");
                boolean AC=rs.getBoolean("AC");
                String pickUpDate= rs.getString("pickUpDate");
                String dropOfDate= rs.getString("dropOfDate");
                int noOfDoors=rs.getInt("noOfDoors");
                boolean hasAirBag=rs.getBoolean("AirBag");
                int noOfGears=rs.getInt("noOfGears");
                int noOfHelmets=rs.getInt("noOfHelmets");
                boolean rearDiskBreak=rs.getBoolean("rearDiskBreak");
                boolean frontDiskBreak=rs.getBoolean("frontDiskBreak");
                int type=rs.getInt("type");

                if(type==1){
                    Capacity c = new Capacity(seatCapacity,engineCapacity);
                    Schedule s=new Schedule(date,pickUpDate,dropOfDate);
                    Car cd = new Car(vehicleNoPlate,make,model,c,AC,s,noOfDoors,hasAirBag);
                    mi.add(cd);
                }
                else{
                    Capacity c = new Capacity(seatCapacity,engineCapacity);
                    Schedule s=new Schedule(date,pickUpDate,dropOfDate);
                    MotorBike v = new MotorBike(vehicleNoPlate,make,model,c,AC,s,noOfGears,noOfHelmets,rearDiskBreak,frontDiskBreak);
                    mi.add(v);
                }
            }
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }

        return mi;


    }


    public void closeConnection() {
        try {
            conn.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }




}



