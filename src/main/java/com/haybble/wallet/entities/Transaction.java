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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "transaction_id")
    private int transactionId;

    @Column(name = "transaction_type_id", nullable = false)
    private int transactionTypeId;

    @Column(name = "amount", nullable = false)
    private BigDecimal amount;

    @Column(name = "wallet_id", nullable = false)
    private int walletId;

    @Column(name = "description")
    private String description;

    @Column(name = "last_updated")
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastUpdated;

    @Column(name = "last_updated_by")
    private String lastUpdatedBy;

  
     @ManyToOne
     @JoinColumn(name = "wallet_id",nullable = false,insertable = false, updatable = false,referencedColumnName = "wallet_id",table = "transaction")
     private Wallet wallet;
     
    public Transaction(int transaction_id, int transaction_type_id, BigDecimal amount, int wallet_id, String description, Date last_updated, String last_updated_by) {
        this.transactionId = transaction_id;
        this.transactionTypeId = transaction_type_id;
        this.amount = amount;
        this.walletId = wallet_id;
        this.description = description;
        this.lastUpdated = last_updated;
        this.lastUpdatedBy = last_updated_by;
    }

}
