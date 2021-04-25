/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.haybble.wallet.serivce;

import com.haybble.wallet.entities.Users;
import java.util.List;

/**
 *
 * @author Administrator
 */
public interface UserService {
     List<Users> findAll() throws Exception;
    
}
