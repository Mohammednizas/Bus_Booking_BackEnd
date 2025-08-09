package com.example.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.BusModel;
import com.example.service.BusService;


@RestController
@CrossOrigin(origins = "http://localhost:3000", allowCredentials = "true")

public class BussController {
    @Autowired
    BusService ser;
    @GetMapping("/")
    public String getReq(){
        return "welcome to home page";
    }
    @GetMapping("/bus")
    
    public List<BusModel> getBus(){
        return ser.getBus();
    }
    @GetMapping("/bus/{id}")
    public BusModel getBusById(@PathVariable("id") int busNo){
        return ser.getBusById(busNo);
    }
    @PostMapping("/admin/bus/post")
    public ResponseEntity<String> postBus(@RequestBody BusModel entity) {
        System.out.println(entity.getBus());
        return ser.postBus(entity);
    }
    @DeleteMapping("/admin/bus/deleteAll")
    public ResponseEntity<String> deleteAllBus(){
        return ser.deleteAllBus();
    }
    @DeleteMapping("/admin/bus/delete/{id}")
    public ResponseEntity<String> deleteBusById(@PathVariable("id") int busNo){
        return ser.deleteBusById(busNo);
    }
    
}
