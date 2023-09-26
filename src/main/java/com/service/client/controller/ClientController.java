package com.service.client.controller;

import com.service.client.controller.dto.request.ClientDtoRequest;
import com.service.client.controller.dto.request.ClientIdentifierDtoRequest;
import com.service.client.controller.dto.response.ClientDtoResponse;
import com.service.client.controller.mapper.IClientMapper;
import com.service.client.model.ClientEntity;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@Log4j2
@RestController
@RequiredArgsConstructor
@RequestMapping("/client")
public class ClientController {
    private final IClientRepository clientRepository;
    private final IClientMapper mapper;

    @PostMapping("/id")
    ResponseEntity<ClientEntity> getClientById(
            @RequestBody ClientIdentifierDtoRequest input
    ) throws Exception {
        log.info("MS Elektra Client [getClientById] ---> input: {}", input);

        if (input.getId() == null) {
            log.error("MS Elektra Client [getClientById] ---> input error: {}", "El id no puede ser nulo");
            throw new Exception("El id no puede ser nulo");
        }

        try {
            return clientRepository.findById(input.getId())
                    .map(client -> ResponseEntity.ok().body(client))
                    .orElse(ResponseEntity.notFound().build());
        }
        catch (Exception e) {
            log.error("MS Elektra Client [getClientById] ---> error: {}", e.getMessage());
            throw new Exception(e.getMessage());
        }
    }

    @PostMapping("/save")
    ResponseEntity<ClientDtoResponse> saveClient(
            @RequestBody @Valid ClientDtoRequest input
    ) throws Exception {
        log.info("MS Elektra Client [saveClient] ---> input: {}", input);

        if (input == null) {
            log.error("MS Elektra Client [saveClient] ---> input error: {}", "input is null");
            throw new Exception("input is null");
        } else {
            ClientEntity client = clientRepository.findClientEntityByName(input.getName());
            if (client != null) {
                log.error("MS Elektra Client [saveClient] ---> input error: {}", "El cliente ya existe");
                throw new Exception("El cliente ya existe");
            }
        }

        try {
            ClientEntity clientEntity = mapper.toEntity(input);
            clientEntity = clientRepository.save(clientEntity);
            ClientDtoResponse response = new ClientDtoResponse();
            response.setClientId(clientEntity.getId());
            return ResponseEntity.ok().body(response);
        }
        catch (Exception e) {
            log.error("MS Elektra Client [saveClient] ---> error: {}", e.getMessage());
            throw new Exception(e.getMessage());
        }
    }
}
