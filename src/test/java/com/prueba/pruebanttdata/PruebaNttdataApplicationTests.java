package com.prueba.pruebanttdata;

import com.prueba.pruebanttdata.domain.Client;
import com.prueba.pruebanttdata.repository.ClientRepository;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


import java.util.List;
import java.util.Set;

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
