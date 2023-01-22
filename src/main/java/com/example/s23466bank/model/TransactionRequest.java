package com.example.s23466bank.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.With;

@Data
@AllArgsConstructor
public class TransactionRequest {
    private final int clientId;
    private final long value;
}
