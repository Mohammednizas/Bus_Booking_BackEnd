package com.example.service;
import com.example.model.*;

import java.util.*;

import com.example.repository.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class BusService {
      @Autowired
      BusRepo repo;
     public List<BusModel> getBus(){
         return repo.findAll();
     }
     public BusModel getBusById(int busNo){
        return repo.findById(busNo).orElse(new BusModel());
     }
     public ResponseEntity<String> postBus(BusModel en) {
        try{
        repo.save(en);
        return ResponseEntity.status(HttpStatus.CREATED).body("successfully posted");
        }
        catch(Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("error occured");
        }
}

    public ResponseEntity<String> deleteBusById(int id){
         if(!repo.existsById(id)){
                return ResponseEntity.status(HttpStatus.OK).body("no file exist");
         }
        repo.deleteById(id);
        return ResponseEntity.status(HttpStatus.OK).body("successfully deleted");
    }
    public ResponseEntity<String> deleteAllBus(){
        if(repo.count()==0){
            return ResponseEntity.status(HttpStatus.OK).body("no element exist to delete");
        }
        repo.deleteAll();
        return ResponseEntity.status(HttpStatus.OK).body("successfully deleted");
    }
}
