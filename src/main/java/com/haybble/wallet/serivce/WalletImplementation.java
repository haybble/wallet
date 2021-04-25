/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.haybble.wallet.serivce;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.haybble.wallet.entities.Wallet;
import com.haybble.wallet.repository.TransactionRepository;
import com.haybble.wallet.repository.WalletRepository;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Administrator
 */
@Service
public class WalletImplementation implements WalletService {

    @Autowired
    private WalletRepository walletRepository;

    @Autowired
    private TransactionRepository transactionRepository;

    @Override
    public List<Wallet> findAll() throws Exception {
        return walletRepository.findAll();
    }

    @Override
    public Wallet findById(int id) throws Exception {

        Optional<Wallet> optionalWallet = walletRepository.findById(id);
        return optionalWallet.get();
    }

    @Override
    public List<Wallet> findByUserId(int userId) throws Exception {
        return walletRepository.findByUserId(userId);
    }

    @Override
    public Boolean createWallet(String response) throws Exception {
        Wallet wallet = new Wallet();
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

        wallet = objectMapper.readValue(response, new TypeReference<Wallet>() {
        });
        return walletRepository.save(wallet) != null;
    }

    @Override
    public Boolean updateWalletAmount(Wallet wallet, BigDecimal amount, Boolean isCredit) throws Exception {

        try {

            BigDecimal transactionAmount = (isCredit) ? amount.abs() : amount.abs().negate();
            BigDecimal newBalance = wallet.getBalance().add(transactionAmount);
            System.out.println("wallet balance"+newBalance);

            if (newBalance.compareTo(BigDecimal.ZERO) >= 0) {
                wallet.setBalance(wallet.getBalance().add(transactionAmount));
                wallet.setLastUpdatedBy("Admin");
                wallet.setLastUpdated(new Date());
                return walletRepository.save(wallet) != null;
            }else{
            return false;}

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

}
