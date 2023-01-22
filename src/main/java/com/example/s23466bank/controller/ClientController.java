package com.example.s23466bank.controller;


import com.example.s23466bank.model.Client;
import com.example.s23466bank.service.ClientService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequestMapping("/client")
@RestController
public class ClientController {
    private ClientService clientService;

    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @PostMapping("/addClient")
    public ResponseEntity<Client> addClient(@RequestBody Client client){
        clientService.addClientToDB(client);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/showClientList")
    public ResponseEntity<List<Client>> showAllClients() {
        List<Client> clientList = clientService.getClientList();
        return ResponseEntity.ok(clientList);
    }

    @GetMapping("{id}")
    public ResponseEntity<Client> getClientInfo(@PathVariable int id){
        Optional<Client> client = clientService.getClientById(id);

        return client.map(ResponseEntity::ok).orElse(ResponseEntity.badRequest().build());
    }
}
