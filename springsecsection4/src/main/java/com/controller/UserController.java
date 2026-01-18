package com.controller;

import com.model.Customer;
import com.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class UserController {

    @Autowired
    private final CustomerRepository customerRepository;

    @Autowired
    private final PasswordEncoder passwordEncoder;

    @PostMapping("/register")
    public ResponseEntity<String> registerUser(
        @RequestBody Customer customer)
    {
        try{
            String hashPwd=passwordEncoder.encode(customer.getPwd());
            customer.setPwd(hashPwd);
            Customer savedCustomer=customerRepository.save(customer);
            if(savedCustomer.getId()>0){
                return ResponseEntity.status(HttpStatus.CREATED)
                        .body("Given user details are successfully registered.");
            }
            else{
                return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                        .body("User registration failed.");
            }
        }catch(Exception ex){
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Invalid username or password.");
        }
    }

}
