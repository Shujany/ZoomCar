package com.example.shujany.VehicleRentalStore.VehicleRentalStore;

public class Date {
    private String date;
    public Date(String date){
        this.date = date;
    }

    public Date(int day, int month, int year) {
        this.date = String.valueOf(year).toString()+"-"+String.valueOf(month).toString()+"-"+String.valueOf(day).toString();
    }

    public String getDateString(){
        System.out.println("Date is:"+date);
        return date;
    }

    public String getDate(){
        return date;
    }

    @Override
    public String toString() {
        return "Date {" + date + '}';
    }
}
