package com.prueba.pruebanttdata.controller;

import com.prueba.pruebanttdata.domain.Client;
import com.prueba.pruebanttdata.exception.ApiRequestException;
import com.prueba.pruebanttdata.exception.ClientNotFoundException;
import com.prueba.pruebanttdata.service.ClientService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/client")
public class ClientsController {

    private final ClientService service;

    public ClientsController(ClientService service) {
        this.service = service;
    }

    @GetMapping("/all")
    public ResponseEntity<Object> getAllClients(@RequestBody Client client) {
        if (client.getTypeDocumentId().getId() != null) {
            throw new ClientNotFoundException("Oops cannot get all clients");
        }
        return ResponseEntity.ok(service.findAllCliets());
    }

    @PostMapping("/add")
    public ResponseEntity<Object> insertClient(@RequestBody Client client) {
        if (client.getTypeDocumentId().getDocumentName() != null) {
            throw new ClientNotFoundException("Oops cannot add client for document name is empty");
        }
        return ResponseEntity.ok(client);
    }

    @PutMapping("/update")
    public ResponseEntity<Object> updateClient(@RequestBody Client client) {
        if (client.getDocumentNumber() != null) {
            throw new ClientNotFoundException("Oops cannot found client ");
        }
        return null;
    }

    @DeleteMapping("/delete/{documentNumber}")
    public ResponseEntity<Object> deleteClientByDocumentNumber(@PathVariable String documentNumber) {
        if () {
            throw new ClientNotFoundException("Oops cannot get all clients");
        }
        return null;
    }


}
