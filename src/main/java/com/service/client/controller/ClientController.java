package com.service.client.controller;

import com.service.client.controller.dto.ClientIdentifierDto;
import com.service.client.model.ClientEntity;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Log4j2
@RestController
@RequiredArgsConstructor
@RequestMapping("/client")
public class ClientController {
    private final IClientRepository clientRepository;

    @PostMapping("/id")
    ResponseEntity<ClientEntity> getClientById(
            @RequestBody ClientIdentifierDto input
    ) {
        log.info("MS Elektra Client [getClientById] ---> input: {}", input);

        if (input.getId() == null) {
            log.error("MS Elektra Client [getClientById] ---> input error: {}", "id is null");
            return ResponseEntity.badRequest().build();
        }

        try {
            return clientRepository.findById(input.getId())
                    .map(client -> ResponseEntity.ok().body(client))
                    .orElse(ResponseEntity.notFound().build());
        }
        catch (Exception e) {
            log.error("MS Elektra Client [getClientById] ---> error: {}", e.getMessage());
            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        }
    }
}
