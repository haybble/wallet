/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.haybble.wallet.serivce;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.haybble.wallet.entities.Transaction;
import com.haybble.wallet.entities.TransactionType;
import com.haybble.wallet.entities.Wallet;
import com.haybble.wallet.repository.TransactionRepository;
import com.haybble.wallet.repository.TransactionTypeRepository;
import java.math.BigDecimal;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Administrator
 */
@Service
public class TransactionServiceImplementation implements TransactionService {

    @Autowired
    private TransactionRepository transactionRepository;

    @Autowired
    private WalletService walletService;

    @Autowired
    private TransactionTypeRepository transactionTypeRepository;

    @Override
    public List<Transaction> getTransactionsByWalletId(int walletId) throws Exception {
        try {
           
            List<Transaction> listAll = transactionRepository.findByWalletId(walletId);
             System.out.println("list transactions"+listAll);
            return transactionRepository.findByWalletId(walletId);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public Boolean createTransaction(String response) throws Exception {
        try {

            Transaction transaction = new Transaction();
            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

            transaction = objectMapper.readValue(response, new TypeReference<Transaction>() {
            });

            //Get transactionType reference
            TransactionType transactionType = transactionTypeRepository.getOne(transaction.getTransactionTypeId());
//            System.out.println("transtype"+ transactionType);
//            System.out.println("transactioncode"+transactionType.getCode());
            Boolean isCredit = transactionType.getCode().equalsIgnoreCase("cr") ? true : false;
            transaction.setDescription(isCredit == true ? "Credit transaction" : "Debit transaction");
//            System.out.println("iscredit"+isCredit);

            BigDecimal amount = transaction.getAmount();
//            System.out.println("amunt"+amount);
            //Check wallet is present
            Wallet wallet = walletService.findById(transaction.getWalletId());

//            System.out.println("walletbalance"+wallet.getBalance());
            Boolean walletTransaction = walletService.updateWalletAmount(wallet, amount, isCredit);

            return (walletTransaction == true) ? transactionRepository.save(transaction) != null : false;
        } catch (Exception ex) {
            return false;
        }
    }

    @Override
    public List<TransactionType> getTransactionType() throws Exception {
       return transactionTypeRepository.findAll();
    }
}
