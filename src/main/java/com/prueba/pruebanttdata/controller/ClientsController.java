package com.prueba.pruebanttdata.controller;

import com.prueba.pruebanttdata.persistence.entity.Client;
import com.prueba.pruebanttdata.exception.custom.ClientNotFoundException;
import com.prueba.pruebanttdata.service.ClientService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/client")
@Slf4j
public class ClientsController {

    private final ClientService service;

    public ClientsController(@Qualifier("ClientServiceImpl") ClientService service) {
        this.service = service;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Client>> getAllClients() {
        log.info("Initial service find all clients");

        List<Client> clients = service.findAllClients();
//        if (service.) {
//            throw new ClientNotFoundException("Oops cannot get all clients");
//        }
        return ResponseEntity.ok(service.findAllClients());
    }

    @GetMapping("/{documentNumber}")
    public ResponseEntity<List<Client>> getClienAlltByDocumentNumber(@PathVariable String documentNumber) {
        log.info("Initial service find all by document number clients");
        if (documentNumber.isEmpty()) {
            throw new ClientNotFoundException("Oops cannot get all clients");
        }
        return ResponseEntity.ok(service.findAllClients());
    }


    @PostMapping("/add")
    public ResponseEntity<Client> insertClient(@RequestBody Client client) {
        log.info("Initial service add new client");

        if (client.getDocumentNumber() != null) {
            throw new ClientNotFoundException("Oops cannot add client for document name is empty");
        }
        return ResponseEntity.ok(client);
    }

    @PutMapping("/update")
    public ResponseEntity<Client> updateClient(@RequestBody Client client) {
        log.info("Initial service update client exist");

        if (service.findByDocumentNumber(client.getDocumentNumber()) != null) {
            throw new ClientNotFoundException("Oops cannot found client ");
        }
        return ResponseEntity.ok(service.updateClient(client));
    }

    @DeleteMapping("/delete/{documentNumber}")
    public ResponseEntity<Client> deleteClientByDocumentNumber(@PathVariable String documentNumber) {
        log.info("Initial service delete client by document number");
        if (!service.existByDocumenNumber(documentNumber)) {
            throw new ClientNotFoundException("Oops client not exist");
        }
        service.deleteByDocumentNumber(documentNumber);
        return ResponseEntity.ok().build();
    }


}
