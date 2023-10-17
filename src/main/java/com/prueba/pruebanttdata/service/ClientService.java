package com.prueba.pruebanttdata.service;

import com.prueba.pruebanttdata.persistence.entity.Client;

import java.util.List;

public interface ClientService {

    List<Client> findAllClients();

    List<Client> findAllClientsById(Long id);

    Client findByDocumentNumber(String documentNumber);

    Client findById(Long id);

    Client addNewClient(Client client);

    Client updateClient(Client client);

    void deleteByDocumentNumber(String documentNumber);

    Boolean existByDocumenNumber(String documentNumber);

}
