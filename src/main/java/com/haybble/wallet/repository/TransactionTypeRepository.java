/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.haybble.wallet.repository;

import com.haybble.wallet.entities.TransactionType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Administrator
 */

@Transactional
public interface TransactionTypeRepository extends JpaRepository<TransactionType, Integer> {
}

