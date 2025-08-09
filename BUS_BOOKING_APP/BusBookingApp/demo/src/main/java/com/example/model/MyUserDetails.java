package com.example.model;

import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
@Component
public class MyUserDetails implements UserDetails {
    
    private  LoginModel mod;

  public MyUserDetails(){

  }
   public MyUserDetails(LoginModel mo){
        mod = mo;
    }

    @Override
    public List<GrantedAuthority> getAuthorities() {
    return List.of(new SimpleGrantedAuthority("ROLE_" + mod.getRole()));
}


    @Override
    public String getUsername(){
        return mod.getUserName();
    }
    @Override
     public String getPassword(){
        return mod.getPassword();
    }


}
