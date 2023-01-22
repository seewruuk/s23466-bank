package com.example.s23466bank.repository;


import com.example.s23466bank.exception.DatabaseException;
import com.example.s23466bank.exception.ValidationException;
import com.example.s23466bank.model.Client;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class ClientRepository {

    private final List<Client> clientList = new ArrayList<>();
    public void addClient(Client client) throws Exception{
        if(clientList.contains(client)){
            throw new DatabaseException("user already exist");
        }
        clientList.add(client);
    }

    public List<Client> getClientList(){
        return clientList;
    }
    public Optional<Client> getClientById(int id){
        return clientList.stream().filter(it -> it.getClientId() == id).findFirst();
    }

    public void updateSaldo(Client client, long newSaldo){
        clientList.stream().filter(it -> it.equals(client)).forEach(it->it.setSaldo(newSaldo));
    }




}
