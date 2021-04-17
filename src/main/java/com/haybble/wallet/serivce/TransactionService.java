/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.haybble.wallet.serivce;

import com.haybble.wallet.entities.Transaction;
import java.util.List;

/**
 *
 * @author Administrator
 */
public interface TransactionService {

    public List<Transaction> getTransactionsByWalletId( int walletId) throws Exception;
    public Boolean createTransaction( String response) throws Exception;

}
