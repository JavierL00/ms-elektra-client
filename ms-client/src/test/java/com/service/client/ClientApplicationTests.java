package com.service.client;

import com.service.client.controller.ClientController;
import com.service.client.controller.IClientRepository;
import com.service.client.controller.dto.request.ClientDtoRequest;
import com.service.client.controller.dto.request.ClientIdentifierDtoRequest;
import com.service.client.controller.dto.response.ClientDtoResponse;
import com.service.client.controller.mapper.IClientMapper;
import com.service.client.model.ClientEntity;
import com.service.client.model.GenderEnum;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;

import java.time.LocalDate;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;
import static org.mockito.Mockito.when;

@SpringBootTest
class ClientApplicationTests {
    @Mock
    private IClientRepository clientRepository;

    @Mock
    private IClientMapper clientMapper;

    @InjectMocks
    private ClientController clientController;

    @Test
    void testGetById() throws Exception {
        ClientIdentifierDtoRequest input = new ClientIdentifierDtoRequest();
        input.setId(1L);

        ClientEntity client = new ClientEntity();
        client.setId(1L);
        client.setName("Test");
        client.setFirstSurname("Test");
        client.setSecondSurname("Test");
        client.setBirthDate(LocalDate.parse("2010-10-10"));
        client.setGender(GenderEnum.valueOf("MALE"));
        client.setEmail("test@email.com");
        client.setPhone("967574382");

        when(this.clientRepository.findById(input.getId())).thenReturn(Optional.of(client));

        ResponseEntity<ClientEntity> response = this.clientController.getClientById(input);

        assertEquals(client, response.getBody());
        assertEquals(200, response.getStatusCodeValue());
    }

    @Test
    void testGetById_GivenIdNull() {
        ClientIdentifierDtoRequest input = new ClientIdentifierDtoRequest();
        input.setId(null);

        try {
            this.clientController.getClientById(input);
            fail("Se esperaba una excepción");
        }
        catch (Exception e) {
            assertEquals("El id no puede ser nulo", e.getMessage());
        }
    }

    @Test
    void saveClient() throws Exception {
        ClientDtoRequest input = new ClientDtoRequest();
        input.setName("Test");
        input.setFirstSurname("Test");
        input.setSecondSurname("Test");
        input.setBirthDate(LocalDate.parse("2010-10-10"));
        input.setGender(GenderEnum.valueOf("MALE"));
        input.setEmail("test@email.com");
        input.setPhone("967574382");

        ClientEntity client = new ClientEntity();
        when(this.clientMapper.toEntity(input)).thenReturn(client);
        client.setId(1L);
        when(this.clientRepository.save(client)).thenReturn(client);
        ClientDtoResponse response = new ClientDtoResponse();
        response.setClientId(client.getId());

        ResponseEntity<ClientDtoResponse> apiResponse = this.clientController.saveClient(input);

        assertEquals(response, apiResponse.getBody());
        assertEquals(200, apiResponse.getStatusCodeValue());
    }

    @Test
    void saveClient_GivenInputNull() {
        ClientDtoRequest input = new ClientDtoRequest();
        input.setName("Test");

        ClientEntity client = new ClientEntity();
        client.setId(1L);

        when(this.clientRepository.findClientEntityByName(input.getName())).thenReturn(client);

        try {
            this.clientController.saveClient(input);
            fail("Se esperaba una excepción");
        }
        catch (Exception e) {
            assertEquals("El cliente ya existe", e.getMessage());
        }
    }
}
