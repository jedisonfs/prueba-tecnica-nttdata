package com.prueba.pruebanttdata;

import com.prueba.pruebanttdata.persistence.entity.Client;
import com.prueba.pruebanttdata.persistence.entity.repository.ClientRepository;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


import java.util.List;

@SpringBootTest
class PruebaNttdataApplicationTests {

    @Autowired
    private ClientRepository clientRepository;


    @Test
    void testGetAllClient() {
        List<Client> client = clientRepository.findAll();
        assertNotNull(client);
    }

}
