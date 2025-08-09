package com.example.model;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
@Entity
public class BookingModel {
       @Id
       @GeneratedValue(strategy = GenerationType.IDENTITY)
       int sno;
       String userName;
       String userAddr;
       String phno;
       int busNo;
       int bookedSeat;
       LocalDate date;
       
    public BookingModel(){

    }
    public BookingModel(int sn,String nm,String add,String no,int bno,int bk,LocalDate dt){
        sno = sn;
        userName = nm;
        userAddr = add;
        phno = no;
        busNo = bno;
        bookedSeat = bk;
        date = dt;
    }
    public String getUserName() {
        return userName;
    }

    public String getUserAddr() {
        return userAddr;
    }

    public String getPhno() {
        return phno;
    }

    public void setPhno(String phno) {
        this.phno = phno;
    }

    public int getBusNo() {
        return busNo;
    }

    public void setBusNo(int busNo) {
        this.busNo = busNo;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setUserAddr(String userAddr) {
        this.userAddr = userAddr;
    }

    public int getSno() {
        return sno;
    }

    public void setSno(int sno) {
        this.sno = sno;
    }

    public int getBookedSeat() {
        return bookedSeat;
    }

    public void setBookedSeat(int bookedSeat) {
        this.bookedSeat = bookedSeat;
    }

}
