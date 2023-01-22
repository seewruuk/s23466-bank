package com.example.s23466bank.service;


import com.example.s23466bank.exception.DatabaseException;
import com.example.s23466bank.exception.ValidationException;
import com.example.s23466bank.model.Client;
import com.example.s23466bank.repository.ClientRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClientService {
    private ClientRepository clientRepository;

    public ClientService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }
    public void addClientToDB(Client client){
        if(client.getSurname() == null){
            throw new ValidationException("Surname is null");
        }

        if(client.getSurname().isBlank()){
            throw new ValidationException("Surname is blank");
        }

        if(client.getFirstName() == null){
            throw new ValidationException("Firstname is null");
        }

        if(client.getFirstName().isBlank()){
            throw new ValidationException("Firstname is blank");
        }
        try{
            clientRepository.addClient(client);
        }catch(Exception e){
            throw new DatabaseException("db error");
        }
    }
    public List<Client> getClientList(){
        return clientRepository.getClientList();
    }

    public Optional<Client> getClientById(int id){
        return clientRepository.getClientById(id);
    }
}
