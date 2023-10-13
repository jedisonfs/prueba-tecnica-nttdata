package com.prueba.pruebanttdata.service;

import com.prueba.pruebanttdata.domain.Client;

import java.util.List;
import java.util.Optional;

public interface ClientService {

    List<Client> findAllCliets();

    List<Client> findAllClientsById(Long id);

    Client findById(Long id);

    Client addNewClient(Client client);

    Client updateClient(Client client);
    void deleteByDocumentNumber(String documentNumber);

    Boolean existByDocumenNumber(String documentNumber);

}
