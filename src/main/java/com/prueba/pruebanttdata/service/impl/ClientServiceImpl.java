package com.prueba.pruebanttdata.service.impl;

import com.prueba.pruebanttdata.domain.Client;
import com.prueba.pruebanttdata.exception.custom.ClientNotFoundException;
import com.prueba.pruebanttdata.repository.ClientRepository;
import com.prueba.pruebanttdata.service.ClientService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("ClientServiceImpl")
@Slf4j
public class ClientServiceImpl implements ClientService {

    private final ClientRepository repository;

    public ClientServiceImpl(ClientRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Client> findAllClients() {
        log.info("Service find all clients");
        return repository.findAll();
    }

    @Override
    public List<Client> findAllClientsById(Long id) {
        log.info("Service find all by ID clients");
        return repository.findAllById(id);
    }

    @Override
    public Client findById(Long id) {
        log.info("Service find by ID clients");
        return repository.findById(id)
                .orElseThrow(() -> new ClientNotFoundException("Client Not Found in data base"));
    }

    @Override
    public Client findByDocumentNumber(String documentNumber) {
        log.info("Service find by document number clients");
        return repository.findByDocumentNumber(documentNumber);
    }

    @Override
    public Client addNewClient(Client client) {
        log.info("Service add new client clients");
        return repository.save(client);
    }

    @Override
    public Client updateClient(Client client) {
        log.info("Service update client exist");

        if (!repository.existsByDocumentNumber(client.getDocumentNumber())) {
            throw new ClientNotFoundException("Client Not Found in DataBase");
        }
        return repository.save(client);
    }

    @Override
    public void deleteByDocumentNumber(String documentNumber) {
        log.info("Service delete client by document number");
        deleteByDocumentNumber(documentNumber);
    }

    @Override
    public Boolean existByDocumenNumber(String documentNumber) {
        return repository.existsByDocumentNumber(documentNumber);
    }
}
