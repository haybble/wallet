/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.haybble.wallet.entities;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
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
@Getter
@Setter 
@NoArgsConstructor
@Table(name = "users")
public class Users  {
 
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="user_id")
    private int userId;
    
    @Column(name="username",unique = true,nullable = false)
    private String username;
 
    @Column(name="created_by")
    @Value(value = "admin")
    private String createdBy;
    
    @Column(name="created_date")
    private Date createdDate;
  
    @OneToOne
    @JoinColumn(name = "user_id",referencedColumnName = "user_id",table = "users")
    private Wallet wallet;

    public Users(int userId, String username, String createdBy, Date createdDate) {
        this.userId = userId;
        this.username = username;
        this.createdBy = createdBy;
        this.createdDate = createdDate;
    }

   
    
    
}
