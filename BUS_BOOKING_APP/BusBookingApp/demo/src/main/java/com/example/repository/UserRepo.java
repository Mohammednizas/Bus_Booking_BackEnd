package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.model.LoginModel;

public interface UserRepo extends JpaRepository<LoginModel,Integer> {

    LoginModel getByUserName(String userName);

}
