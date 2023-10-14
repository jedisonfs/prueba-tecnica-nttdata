package com.prueba.pruebanttdata.service.impl;

import com.prueba.pruebanttdata.domain.Client;
import com.prueba.pruebanttdata.exception.custom.ClientNotFoundException;
import com.prueba.pruebanttdata.repository.ClientRepository;
import com.prueba.pruebanttdata.service.ClientService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("ClientServiceImpl")
public class ClientServiceImpl implements ClientService {

    private final ClientRepository repository;

    public ClientServiceImpl(ClientRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Client> findAllClients() {
        return repository.findAll();
    }

    @Override
    public List<Client> findAllClientsById(Long id) {
        return repository.findAllById(id);
    }

    @Override
    public Client findById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new ClientNotFoundException("Client Not Found in data base"));
    }

    @Override
    public Client findByDocumentNumber(String documentNumber) {
        return repository.findByDocumentNumber(documentNumber);
    }

    @Override
    public Client addNewClient(Client client) {
        return repository.save(client);
    }

    @Override
    public Client updateClient(Client client) {
        if (!repository.existsByDocumentNumber(client.getDocumentNumber())) {
            throw new ClientNotFoundException("Client Not Found in DataBase");
        }
        return repository.save(client);
    }

    @Override
    public void deleteByDocumentNumber(String documentNumber) {
        deleteByDocumentNumber(documentNumber);
    }

    @Override
    public Boolean existByDocumenNumber(String documentNumber) {
        return repository.existsByDocumentNumber(documentNumber);
    }
}
