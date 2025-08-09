package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.model.BookingModel;
import com.example.model.BusModel;
import com.example.repository.BookingRepo;
import com.example.repository.BusRepo;

@Service
public class BookingService {
    @Autowired
    BookingRepo repo;
    @Autowired
    BusRepo brep;
    public List<BookingModel> getBookingModels(){
           return repo.findAll();
    }
    public ResponseEntity<BookingModel> postBooking(BookingModel entity){
        repo.save(entity);
        return ResponseEntity.status(HttpStatus.CREATED).body(entity);
    }
    public ResponseEntity<String> deleteBookingById(int sno){
        if(repo.existsById(sno)){

            repo.deleteById(sno);
          return ResponseEntity.status(HttpStatus.OK).body("your seats succesfully deleted");
        }
        System.out.println(sno);
         return ResponseEntity.status(HttpStatus.OK).body("no id exists");

    }
    public ResponseEntity<String> deleteAllBookings(){
        if(repo.count()==0){
            return ResponseEntity.status(HttpStatus.OK).body("no element exist to delete");
        }
        repo.deleteAll();
        return ResponseEntity.status(HttpStatus.OK).body("successfully deleted");
    }
    public ResponseEntity<String> availabilityCheck(BookingModel ent){
        
       int cap = brep.findAll().stream().filter(item -> item.getBusNo() == ent.getBusNo()).findFirst().map(BusModel :: getSeatCapacity).orElse(0);
      System.out.println(cap);
       int book  = repo.findAll().stream().filter(item -> item.getBusNo()==ent.getBusNo() && item.getDate().equals(ent.getDate())).mapToInt(BookingModel :: getBookedSeat).sum();
       if(cap == 0)
          return ResponseEntity.status(HttpStatus.OK).body("enter the valid bus no");
      
           if(book+ent.getBookedSeat()<=cap)
           {
             return  ResponseEntity.status(HttpStatus.OK).body("your seats are available");
           }
        
            return ResponseEntity.status(HttpStatus.OK).body("only "+ cap +" seats are available");
           
}
}
