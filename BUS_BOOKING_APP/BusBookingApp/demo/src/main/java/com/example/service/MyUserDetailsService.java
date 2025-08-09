package com.example.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.model.LoginModel;
import com.example.model.MyUserDetails;
import com.example.repository.UserRepo;

@Service
public class MyUserDetailsService implements UserDetailsService{
    @Autowired
    UserRepo repo;


     
    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        LoginModel user = repo.getByUserName(userName);
        if(user==null){
            throw new UsernameNotFoundException("not found..");
        }
       return new MyUserDetails(user);
         
    }
}
