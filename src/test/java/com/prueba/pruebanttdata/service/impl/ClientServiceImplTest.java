package com.prueba.pruebanttdata.service.impl;

import com.prueba.pruebanttdata.persistence.entity.Client;
import com.prueba.pruebanttdata.persistence.entity.repository.ClientRepository;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.*;

import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

//@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@Slf4j
class ClientServiceImplTest {

    //    @Mock
    ClientRepository clientRepository;
    //    @InjectMocks
    ClientServiceImpl service;

    private Client client;

    @BeforeEach
    void setUp() {
        clientRepository = mock(ClientRepository.class);
        service = new ClientServiceImpl(clientRepository);

        log.debug("Se inicializan mocks");

        client = new Client();
        client.setId(2L);
        client.setTypeDocument("Cedula de ciudadania");
        client.setInitialTypeDocument("CC");
    }


    @Test
    @Order(1)
    @DisplayName("Encontrar todos los usuarios")
    void findAllClients() {
        log.info("Test service find all clients");

        when(clientRepository.findAll())
                .thenReturn(Arrays.asList(client));
        assertNotNull(service.findAllClients());
        assertEquals(client.getDocumentNumber(), "23445322");
    }

    @Test
    @Order(2)
    @DisplayName("Traer todos los usuarios por ID")
    void findAllClientsById() {
        log.info("Test service find all by ID clients");

        when(clientRepository.findAllById(2L))
                .thenReturn(Arrays.asList(client));
        List<Client> clientList = service.findAllClientsById(2L);

        assertNotNull(clientList);
        assertEquals(clientList.get(0).getInitialTypeDocument(), "CC");
    }

    @Test
    @Order(3)
    void findById() {
        log.info("Test service find by ID clients");

        when(clientRepository.findById(2L))
                .thenReturn(Optional.of(client));

//        assertInstanceOf(Client.class, client);
        assertNotNull(service.findById(2L));
    }

    @Test
    @Order(4)
    void findByDocumentNumber() {
        log.info("Test service find by document number clients");

        when(clientRepository.findByDocumentNumber("23445322"))
                .thenReturn(client);
        Client clientResponse = service.findByDocumentNumber("23445322");

//        assertInstanceOf(Client.class, client);
        assertEquals(clientResponse.getTypeDocument(), "Cedula de ciudadania");
    }

    @Test
    @Order(5)
    void addNewClient() {
        log.info("Test service add new client clients");

        when(clientRepository.save(client))
                .thenReturn(client);

        Client clientResponse = service.addNewClient(client);

//        assertInstanceOf(Client.class, clientResponse);
        assertEquals(clientResponse.getTypeDocument(), "Cedula de ciudadania");
        assertEquals(clientResponse.getFirstName(), "Jhon");
    }

    @Test
    void updateClient() {
        log.info("Test service update client exist");

        client = new Client();
        client.setId(2L);
        client.setTypeDocument("Cedula de ciudadania");
        client.setInitialTypeDocument("CC");
        client.setFirstName("Fabian");

        when(clientRepository.save(client))
                .thenReturn(client);

        when(clientRepository.existsByDocumentNumber(client.getDocumentNumber()))
                .thenReturn(true);

        Client clientResponse = service.updateClient(client);

//        assertInstanceOf(Client.class, clientResponse);
        assertEquals(clientResponse.getFirstName(), "Fabian");
    }
}