package com.example.repository;
import com.example.model.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface BusRepo extends JpaRepository<BusModel,Integer> {

}
