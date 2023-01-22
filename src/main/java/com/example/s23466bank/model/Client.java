package com.example.s23466bank.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.With;

@With
@Data
@AllArgsConstructor
public class Client {
    private final int clientId;
    private final String firstName;
    private final String surname;
    private long saldo;
}
