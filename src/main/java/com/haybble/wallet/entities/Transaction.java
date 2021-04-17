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
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "transaction")
@Getter
@Setter
@NoArgsConstructor
public class Transaction {

    @Id
    @Column(name = "transaction_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int transaction_id;

    @Column(name = "transaction_type_id", nullable = false)
    private int transaction_type_id;

    @Column(name = "amount", nullable = false)
    private BigDecimal amount;

  
    @Column(name = "wallet_id",nullable = false)
    private int wallet_id;

    @Column(name = "description")
   private String description;

    @Column(name = "last_updated")
    @Temporal(TemporalType.TIMESTAMP)
    private Date last_updated;

    @Column(name = "last_updated_by")
    private String last_updated_by;
    
    
    @ManyToOne(fetch = FetchType.LAZY)
     @JoinColumn(name = "transaction_type_id",nullable = false,insertable = false, updatable = false)
    private TransactionType transactionType;
        @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "wallet_id",nullable = false,insertable = false, updatable = false)
    private Wallet wallet;

    public Transaction(int transaction_id, int transaction_type_id, BigDecimal amount, int wallet_id, String description, Date last_updated, String last_updated_by) {
        this.transaction_id = transaction_id;
        this.transaction_type_id = transaction_type_id;
        this.amount = amount;
        this.wallet_id = wallet_id;
        this.description = description;
        this.last_updated = last_updated;
        this.last_updated_by = last_updated_by;
    }

    
}
