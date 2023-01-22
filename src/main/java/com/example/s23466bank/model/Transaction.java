package com.example.s23466bank.model;


import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.UUID;

@Data
@AllArgsConstructor
public class Transaction {
    private final UUID id;
    private final int clientId;
    private final long value;
    private TransactionStatus transactionStatus;

}
