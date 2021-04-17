/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.haybble.wallet.serivce;

import com.haybble.wallet.entities.Wallet;
import java.math.BigDecimal;

import java.util.List;

/**
 *
 * @author Administrator
 */
public interface WalletService {
     public List<Wallet> findAll() throws Exception;
    public Wallet findById(int id) throws Exception;
    public List<Wallet> findByUserId( int userId) throws Exception;
    public Boolean createWallet(String response) throws Exception;
    public Boolean updateWalletAmount(Wallet wallet, BigDecimal amount, Boolean isCredit) throws Exception;

}
