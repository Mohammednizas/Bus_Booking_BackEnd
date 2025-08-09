package com.example.model;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
@Entity
public class BusModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int busNo;
    String bus;
    String driverName;
    int seatCapacity;
    String startPlace;
    String endPlace;
    public BusModel(){

    }
    public BusModel(int no,String nm,String dn,int sc,String pl,String epl){
        busNo = no;
        bus= nm;
        driverName = dn;
        seatCapacity = sc;
        startPlace = pl;
        endPlace = epl;
    }
    public void setBusNo(int no){
        busNo = no;
    }
     public void setBus(String bu) {
        System.out.println("hello");
        bus = bu;
    
    }

   
    public void setDriverName(String dn){
        System.out.println(dn);
        driverName = dn;
    }
    public void setSeatCapacity(int sc){
        seatCapacity = sc;
    }
    public void setStartPlace(String pl){
        startPlace = pl;
    }
    public void setEndPlace(String epl){
        endPlace = epl;
    }
    public int getBusNo(){
        return busNo;
    }
    public String getBus(){
        return bus;
    }
    public String getDriverName(){
        return driverName;
    }
    public int getSeatCapacity(){
        return seatCapacity;
    }
    public String getStartPlace(){
        return startPlace;
    }
    public String getEndPlace(){
        return endPlace;
    }

   
    

}
