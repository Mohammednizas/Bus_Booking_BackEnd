package com.example.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.context.HttpSessionSecurityContextRepository;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.LoginModel;
import com.example.repository.UserRepo;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;


@RestController
@CrossOrigin(origins = "http://localhost:3000", allowCredentials = "true")

public class LoginController {
    @Autowired
    UserRepo repo;
    @Autowired
    PasswordEncoder encoder;
  @Autowired
  AuthenticationManager authenticationManager;
    @PostMapping("/login")
    public String postDetails(@RequestBody LoginModel mod){
           if(repo.getByUserName(mod.getUserName()) == null )
           {
                 mod.setPassword(encoder.encode(mod.getPassword()));
           repo.save(mod);
           return "you successfully logged in";
           } 
           
        return "username already exists";
    }

    @PostMapping("/signin")

    public ResponseEntity<LoginModel> matchOrnot(@RequestBody LoginModel mod, HttpServletRequest request){
        try{
        UsernamePasswordAuthenticationToken user = new UsernamePasswordAuthenticationToken(mod.getUserName(),mod.getPassword());

            Authentication auth = authenticationManager.authenticate(user);
            System.out.println(auth);
            SecurityContextHolder.getContext().setAuthentication(auth);
            request.getSession(true).setAttribute(HttpSessionSecurityContextRepository.SPRING_SECURITY_CONTEXT_KEY, SecurityContextHolder.getContext());

            return ResponseEntity.status(HttpStatus.OK).body(mod);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(mod);
        }
    
}
 @GetMapping("/admin/users")
 public List<LoginModel> getAllUsers(){
    return repo.findAll();
 }

 @GetMapping("/signedOrNot")
 public Map<String,String> getMethodName(HttpServletRequest request) {
    HashMap<String,String> map = new HashMap<>();
   HttpSession session = request.getSession();
   
   if(session!=null){
   Authentication auth = SecurityContextHolder.getContext().getAuthentication();
   map.put("username",auth.getName());
   List<GrantedAuthority> a = new ArrayList<>(auth.getAuthorities());
   map.put("role",a.get(0).toString());
   return map;
   }
    return null;
 }
 
}

 


