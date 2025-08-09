package com;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class passwordfinder {
    public static void main(String args[]){
    
        System.out.println( new BCryptPasswordEncoder().encode("74185"));

    }

}
