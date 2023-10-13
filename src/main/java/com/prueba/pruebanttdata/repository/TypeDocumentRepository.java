package com.prueba.pruebanttdata.repository;

import com.prueba.pruebanttdata.domain.TypeDocument;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TypeDocumentRepository extends JpaRepository<TypeDocument, Long> {
}
