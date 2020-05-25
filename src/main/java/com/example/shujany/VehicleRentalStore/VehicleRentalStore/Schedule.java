package com.example.shujany.VehicleRentalStore.VehicleRentalStore;

public class Schedule {
    private Date date;
    private Date pickUpDateOfVehicle;
    private Date deliveryDateOfVehicle;

    public Schedule(String date, String pickUpDateOfVehicle, String deliveryDateOfVehicle) {
        this.date = new Date(date);
        this.pickUpDateOfVehicle = new Date (pickUpDateOfVehicle);
        this.deliveryDateOfVehicle =  new Date(deliveryDateOfVehicle);
    }

    public Schedule(Date date, Date pickUpDateOfVehicle, Date deliveryDateOfVehicle) {
        this.date = date;
        this.pickUpDateOfVehicle = pickUpDateOfVehicle;
        this.deliveryDateOfVehicle = deliveryDateOfVehicle;
    }

    public Schedule(Date date) {

    }

    //method to retrieve date
    public Date getDate() {
        return date;
    }

    //method to set date
    public void setDate(Date date) {
        this.date = date;
    }

    public Date getPickUpDateOfVehicle() {
        return pickUpDateOfVehicle;
    }

    public String getPickUpDateOfVehicleString(){return pickUpDateOfVehicle.getDate();}

    public String getDateString(){
        //System.out.println("Date for database : "+date.getDateString());
        return date.getDateString();
    }
    public void setPickUpDateOfVehicle(Date pickUpDateOfVehicle) {
        this.pickUpDateOfVehicle = pickUpDateOfVehicle;
    }

    public Date getDeliveryDateOfVehicle() {
        return deliveryDateOfVehicle;
    }

    public String getDeliveryDateOfVehicleString(){return deliveryDateOfVehicle.getDate();}

    public void setDeliveryDateOfVehicle(Date deliveryDateOfVehicle) {
        this.deliveryDateOfVehicle = deliveryDateOfVehicle;
    }

    @Override
    public String toString() {
        return "Schedule{" +
                "date=" + date +
                ", pickUpDateOfVehicle=" + pickUpDateOfVehicle +
                ", deliveryDateOfVehicle=" + deliveryDateOfVehicle +
                '}';
    }

}
