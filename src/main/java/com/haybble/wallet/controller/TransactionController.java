/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.haybble.wallet.controller;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.haybble.wallet.entities.Transaction;
import com.haybble.wallet.serivce.TransactionService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Administrator
 */

@CrossOrigin
@RestController
@RequestMapping("/api/v1")
@Service
public class TransactionController {
    
    @Autowired
    private TransactionService transactionService;
  
   
    @GetMapping("/listtransactionsbywallet")
    public ResponseEntity ListWalletTransactions(@PathVariable("walletId") int walletId) throws Exception {
        List<Transaction> transactionList = transactionService.getTransactionsByWalletId(walletId);
        return (transactionList == null) ? new ResponseEntity(HttpStatus.NOT_FOUND) : new ResponseEntity(transactionList, HttpStatus.OK);
    }
    
     @PostMapping("/createwallettransaction")
    public ResponseEntity CreateWalletTransactions(@RequestBody String response) throws Exception {
         ObjectMapper objectMapper = new ObjectMapper();
         Transaction transaction = objectMapper.readValue(response, new TypeReference<Transaction>() {
         });
         System.out.println("transaction"+transaction);
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        return (transactionService.createTransaction(response)) ? new ResponseEntity(transaction, HttpStatus.OK) : new ResponseEntity(HttpStatus.BAD_REQUEST);
    }
      
}
