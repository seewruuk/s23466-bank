package com.example.s23466bank.exception;



import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class TransactionException extends RuntimeException {
    private final String message;
}
