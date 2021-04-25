/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.haybble.wallet.controller;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.haybble.wallet.entities.Transaction;
import com.haybble.wallet.entities.Users;
import com.haybble.wallet.entities.Wallet;
import com.haybble.wallet.repository.UserRepository;
import com.haybble.wallet.serivce.UserService;
import java.math.BigDecimal;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Administrator
 */
@CrossOrigin
@RestController
@RequestMapping("/api/v1")
@Service
public class UsersController {

    @Autowired
    private UserService userService;

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/listallusers")
    public ResponseEntity ListAllUsers() throws Exception {

        List<Users> UsersList = userService.findAll();
        System.out.println("userlist" + UsersList);
        return (UsersList == null) ? new ResponseEntity(HttpStatus.NOT_FOUND) : new ResponseEntity(UsersList, HttpStatus.OK);

    }

    @PostMapping("/adduser")
    public ResponseEntity AddUsers(@RequestBody String response) throws Exception {

        ObjectMapper objectMapper = new ObjectMapper();
        Users user = objectMapper.readValue(response, new TypeReference<Users>() {
        });
        System.out.println("user is " + user);
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
     
        
        return (userRepository.save(user) == null) ? new ResponseEntity(user, HttpStatus.OK) : new ResponseEntity(HttpStatus.BAD_REQUEST);
    }

}
