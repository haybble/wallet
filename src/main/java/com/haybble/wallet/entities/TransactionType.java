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
@Table(name = "transactiontype")
@Getter
@Setter
@NoArgsConstructor
public class TransactionType {

    @Id
    @Column(name = "transaction_type_id", nullable = false, unique = true)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int transactionTypeId;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "code")
    private String code;

    @Column(name = "last_updated")
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastUpdated;

    @Column(name = "last_updated_by")
    private String lastUpdatedBy;

    public TransactionType(int transaction_type_id, String name, String description, String code, Date last_updated, String last_updated_by) {
        this.transactionTypeId = transaction_type_id;
        this.name = name;
        this.description = description;
        this.code = code;
        this.lastUpdated = last_updated;
        this.lastUpdatedBy = last_updated_by;
    }

}
