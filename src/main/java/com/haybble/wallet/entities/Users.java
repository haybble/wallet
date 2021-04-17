/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.haybble.wallet.entities;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;

/**
 *
 * @author Olagunju Jesufemi
 */
@Entity
@Getter @Setter @NoArgsConstructor
@Table(name = "users")
public class Users  {
 
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="user_id")
    private int user_id;
    
    @Column(name="username",unique = true,nullable = false)
    private String username;
 
    @Column(name="created_by")
    @Value(value = "admin")
    private String created_by;
    
    @Column(name="created_date")
    private Date created_date;
  
    

    public Users(int user_id, String username, String created_by, Date created_date) {
        this.user_id = user_id;
        this.username = username;
        this.created_by = created_by;
        this.created_date = created_date;
    }

   
    
    
}
