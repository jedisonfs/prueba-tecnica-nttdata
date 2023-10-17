package com.prueba.pruebanttdata.persistence.entity.repository;

import com.prueba.pruebanttdata.persistence.entity.Client;
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
