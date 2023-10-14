package com.prueba.pruebanttdata.repository;

import com.prueba.pruebanttdata.domain.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {

    Boolean existsByDocumentNumber(String documentNumber);

    Client findByDocumentNumber(String documentNumber);

    List<Client> findAllById(Long id);

    Integer deleteByDocumentNumber(String documentNumber);
}
