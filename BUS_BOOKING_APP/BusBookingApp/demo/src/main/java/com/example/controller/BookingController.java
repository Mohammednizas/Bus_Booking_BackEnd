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

import com.example.model.BookingModel;
import com.example.service.BookingService;


@RestController
@CrossOrigin(origins = "http://localhost:3000", allowCredentials = "true")

public class BookingController {
    @Autowired
    BookingService ser;

     @GetMapping("/admin/bookings")
     public List<BookingModel> getBookingModels(){
         return ser.getBookingModels();
     }
     @PostMapping("/bookings/availability")
     public ResponseEntity<String> availabilityCheck(@RequestBody BookingModel ent){
        System.out.println(ent);
        return ser.availabilityCheck(ent);
     }
     @PostMapping("/bookings/post")
     public ResponseEntity<BookingModel> postBookingModels(@RequestBody BookingModel entity) {
         
        return ser.postBooking(entity);    
     }
     @DeleteMapping("/bookings/delete/{id}")
     public ResponseEntity<String> deleteBookingModels(@RequestBody BookingModel ent,@PathVariable("id") int sno){
          return ser.deleteBookingById(sno);
     }
     @DeleteMapping("/admin/bookings/delete/all")
     public ResponseEntity<String> deleteAllBookingModels(){
        return ser.deleteAllBookings();
     }


}
