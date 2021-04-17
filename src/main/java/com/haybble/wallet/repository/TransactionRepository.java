/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.haybble.wallet.repository;

import com.haybble.wallet.entities.Transaction;
import com.haybble.wallet.entities.Wallet;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author Administrator
 */


public interface TransactionRepository extends JpaRepository<Transaction, Integer> {
    List<Transaction> findByWallet(int walletId);
    
}