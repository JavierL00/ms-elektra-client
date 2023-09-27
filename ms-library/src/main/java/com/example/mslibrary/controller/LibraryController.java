package com.example.mslibrary.controller;

import com.example.mslibrary.controller.dto.request.LibraryIdentifierDtoRequest;
import com.example.mslibrary.controller.dto.response.LibraryDtoResponse;
import com.example.mslibrary.controller.feign.IFeignPort;
import com.example.mslibrary.controller.feign.dto.ClientDtoRequest;
import com.example.mslibrary.controller.feign.dto.ClientDtoResponse;
import com.example.mslibrary.controller.util.CustomUtilClass;
import com.example.mslibrary.model.LibraryEntity;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityNotFoundException;

@Log4j2
@RestController
@RequiredArgsConstructor
@RequestMapping("/library")
public class LibraryController {
    private final ILibraryRepository libraryRepository;
    private final IFeignPort feignPort;

    @Transactional
    @PostMapping("/id")
    public ResponseEntity<LibraryDtoResponse> getLibraryById(
            @RequestBody LibraryIdentifierDtoRequest input
    ) throws Exception {
        log.info("MS Elektra Library [getLibraryById] ---> input: {}", input);

        if (input.getId() == null) {
            log.error("MS Elektra Library [getLibraryById] ---> input error: {}", "El id no puede ser nulo");
            throw new Exception("El id no puede ser nulo");
        }

        try {
            LibraryEntity libraryEntity = libraryRepository.getById(input.getId());
            log.info("MS Elektra Library [getLibraryById] ---> libraryEntity: {}", libraryEntity);

            ClientDtoResponse clientDtoResponse = feignPort.getClientById(new ClientDtoRequest(libraryEntity.getAuthorClientId()));
            log.info("MS Elektra Library [getLibraryById] ---> clientDtoResponse: {}", clientDtoResponse);

            CustomUtilClass customUtilClass = new CustomUtilClass();
            return ResponseEntity.ok(customUtilClass.toDtoResponse(libraryEntity, clientDtoResponse));
        }
        catch (EntityNotFoundException e) {
            log.error("MS Elektra Library [getLibraryById] ---> input error: {}", "No se encontró la biblioteca");
            return ResponseEntity.notFound().build();
        }
        catch (Exception e) {
            log.error("MS Elektra Library [getLibraryById] ---> error: {}", e.getMessage());
            throw new Exception(e.getMessage());
        }
    }
}
