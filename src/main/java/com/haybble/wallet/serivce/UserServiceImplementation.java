/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.haybble.wallet.serivce;

import com.haybble.wallet.entities.Users;
import com.haybble.wallet.repository.UserRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

/**
 *
 * @author Administrator
 */
@Service
public class UserServiceImplementation implements  UserService{
    @Autowired
    UserRepository userRepository;

    @Override
    public List<Users> findAll() throws Exception {
        try {
          return  userRepository.findAll(Sort.by(Sort.Direction.ASC, "username"));
        } catch (Exception e) {
            return null;
        }
     }
    
}
