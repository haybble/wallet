/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.haybble.wallet.entities;

import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "wallet_id")
    private int walletId;

    @Column(name = "user_id")
    private int userId;
   
    @Column(name = "balance",nullable = false)
    private BigDecimal balance;

    @Column(name = "last_updated")
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastUpdated;
    
    @Column(name = "last_updated_by")
    private String lastUpdatedBy;

    public Wallet(int wallet_id, int userId, BigDecimal balance, Date lastUpdated, String last_updated_by) {
        this.walletId = wallet_id;
        this.userId = userId;
        this.balance = balance;
        this.lastUpdated = lastUpdated;
        this.lastUpdatedBy = last_updated_by;
    }

    
    
    
    
}