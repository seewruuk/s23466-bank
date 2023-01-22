package com.example.s23466bank.controller;


import com.example.s23466bank.model.Transaction;
import com.example.s23466bank.model.TransactionRequest;
import com.example.s23466bank.model.TransactionStatus;
import com.example.s23466bank.service.TransactionService;
import org.apache.coyote.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/transactionController")
public class TransactionController {

    private TransactionService transactionService;

    public TransactionController(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    @PostMapping("/withdraw")
    public ResponseEntity<Transaction> withDraw(@RequestBody TransactionRequest transactionRequest) throws Exception {
        Transaction transaction = transactionService.withDraw(transactionRequest);
        return ResponseEntity.ok(transaction);
    }

    @PostMapping("/addMoney")
    public ResponseEntity<Transaction> addMoney(@RequestBody TransactionRequest transactionRequest) throws Exception {
        Transaction transaction = transactionService.addMoney(transactionRequest);
        return ResponseEntity.ok(transaction);
    }


    @GetMapping("/getTransiactions")
    public ResponseEntity<List<Transaction>> getTransactionList(){
        List<Transaction> list = transactionService.showTransactionList();
        return ResponseEntity.ok(list);
    }
}
