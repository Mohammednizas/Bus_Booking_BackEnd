package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.model.BookingModel;

public interface BookingRepo extends JpaRepository<BookingModel, Integer> {

}
