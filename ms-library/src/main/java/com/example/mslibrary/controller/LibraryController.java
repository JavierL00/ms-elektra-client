package com.example.mslibrary.controller;

import com.example.mslibrary.controller.dto.request.LibraryIdentifierDtoRequest;
import com.example.mslibrary.controller.dto.response.ClientDtoResponse;
import com.example.mslibrary.controller.dto.response.LibraryDtoResponse;
import com.example.mslibrary.model.LibraryEntity;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Date;
import java.util.List;

@Log4j2
@RestController
@RequiredArgsConstructor
@RequestMapping("/library")
public class LibraryController {
    private final ILibraryRepository libraryRepository;

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
            List<Object[]> libraryResponse = libraryRepository.getLibraryById(input.getId());
            LibraryDtoResponse libraryEntity = new LibraryDtoResponse();
            for (Object[] library : libraryResponse) {
                libraryEntity.setId(library[0] == null ? null : Long.parseLong(library[0].toString()));
                libraryEntity.setName(library[1] == null ? null : library[1].toString());
                libraryEntity.setEditorial(library[2] == null ? null : library[2].toString());
                libraryEntity.setPublicationDate(library[3] == null ? null : Date.valueOf(library[3].toString()).toLocalDate());
                ClientDtoResponse author = new ClientDtoResponse();
                author.setId(library[4] == null ? null : Long.parseLong(library[4].toString()));
                author.setName(library[5] == null ? null : library[5].toString());
                author.setFirstSurname(library[6] == null ? null : library[6].toString());
                author.setSecondSurname(library[7] == null ? null : library[7].toString());
                author.setGender(library[8] == null ? null : library[8].toString());
                author.setBirthDate(library[9] == null ? null : Date.valueOf(library[9].toString()).toLocalDate());
                author.setPhone(library[10] == null ? null : library[10].toString());
                author.setEmail(library[11] == null ? null : library[11].toString());
                libraryEntity.setAuthor(author);
            }
            return ResponseEntity.ok(libraryEntity);
        }
        catch (Exception e) {
            log.error("MS Elektra Library [getLibraryById] ---> error: {}", e.getMessage());
            throw new Exception(e.getMessage());
        }
    }
}
