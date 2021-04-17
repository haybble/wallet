/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.haybble.wallet.entities;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 *
 * @author Administrator
 */
@Entity
@Table(name = "wallet")
@Getter
@Setter
@NoArgsConstructor
public class Wallet {

    @Id
    @Column(name = "wallet_id",nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int wallet_id;

  
    @Column(name = "user_id")
    private int userId;

   
    @Column(name = "balance",nullable = false)
    private BigDecimal balance;


    @Column(name = "last_updated")
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastUpdated;
    
        @Column(name = "last_updated_by")
    private String last_updated_by;


    @OneToMany(mappedBy = "wallet", fetch = FetchType.LAZY)
    private List<Transaction> transaction;

    public Wallet(int wallet_id, int userId, BigDecimal balance, Date lastUpdated, String last_updated_by) {
        this.wallet_id = wallet_id;
        this.userId = userId;
        this.balance = balance;
        this.lastUpdated = lastUpdated;
        this.last_updated_by = last_updated_by;
    }

    
    
    
    
}