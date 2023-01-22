package com.example.s23466bank.repository;


import com.example.s23466bank.model.Transaction;
import com.example.s23466bank.model.TransactionStatus;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class TransactionsRepository {


    private final List<Transaction> transactionList = new ArrayList<>();

    public void createTransaction(Transaction transaction) throws Exception{
        if(transactionList.contains(transaction)){
            throw new Exception();
        }
        transactionList.add(transaction);
    }
    public List<Transaction> showTransactions(){
        return transactionList;
    }

}
