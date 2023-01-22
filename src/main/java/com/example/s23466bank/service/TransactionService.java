package com.example.s23466bank.service;


import com.example.s23466bank.exception.TransactionException;
import com.example.s23466bank.model.Client;
import com.example.s23466bank.model.Transaction;
import com.example.s23466bank.model.TransactionRequest;
import com.example.s23466bank.model.TransactionStatus;
import com.example.s23466bank.repository.ClientRepository;
import com.example.s23466bank.repository.TransactionsRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class TransactionService {
    private TransactionsRepository transactionsRepository;
    private ClientRepository clientRepository;

    public TransactionService(TransactionsRepository transactionsRepository, ClientRepository clientRepository) {
        this.transactionsRepository = transactionsRepository;
        this.clientRepository = clientRepository;
    }

    public Transaction addMoney(TransactionRequest transactionRequest) throws Exception {
        Client client = clientRepository.getClientById(transactionRequest.getClientId()).orElseThrow(() -> new RuntimeException("error"));

        if(client.equals(null)){
            throw new TransactionException("Message");
        }else {
            long newSaldo = client.getSaldo() + transactionRequest.getValue();
            Transaction transaction = new Transaction(UUID.randomUUID(), transactionRequest.getClientId(), newSaldo, TransactionStatus.ACCEPTED);
            transactionsRepository.createTransaction(transaction);
            clientRepository.updateSaldo(client, newSaldo);
            return transaction;
        }

    }

    public Transaction withDraw(TransactionRequest transactionRequest) throws Exception {
        Client client = clientRepository.getClientById(transactionRequest.getClientId())
                .orElseThrow(() -> new RuntimeException("error"));
        if(client.getSaldo() - transactionRequest.getValue() < 0){
            throw new RuntimeException("balance too low");
        }else{
            long newSaldo = client.getSaldo() - transactionRequest.getValue();
            Transaction transaction = new Transaction(UUID.randomUUID(), transactionRequest.getClientId(), newSaldo, TransactionStatus.ACCEPTED);
            transactionsRepository.createTransaction(transaction);
            clientRepository.updateSaldo(client, newSaldo);
        return transaction;
        }
    }
    public List<Transaction> showTransactionList(){
        List<Transaction> transactionList = transactionsRepository.showTransactions();
        return transactionList;
    }
}
