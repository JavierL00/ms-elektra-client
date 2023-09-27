package com.example.mslibrary;

import com.example.mslibrary.controller.ILibraryRepository;
import com.example.mslibrary.controller.LibraryController;
import com.example.mslibrary.controller.dto.request.LibraryIdentifierDtoRequest;
import com.example.mslibrary.controller.dto.response.LibraryDtoResponse;
import com.example.mslibrary.controller.feign.IFeignPort;
import com.example.mslibrary.controller.feign.dto.ClientDtoRequest;
import com.example.mslibrary.controller.feign.dto.ClientDtoResponse;
import com.example.mslibrary.model.LibraryEntity;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@SpringBootTest
class MsLibraryApplicationTests {

    @Mock
    private ILibraryRepository libraryRepository;

    @Mock
    private IFeignPort feignPort;

    @InjectMocks
    private LibraryController libraryController;

    @Test
    void testGetById() throws Exception {
        LibraryIdentifierDtoRequest input = new LibraryIdentifierDtoRequest();
        input.setId(1L);

        LibraryEntity library = new LibraryEntity();
        library.setId(1L);
        library.setName("Test");
        library.setAuthorClientId(1L);
        library.setEditorial("Test");
        library.setPublicationDate(LocalDate.parse("2010-10-10"));

        when(this.libraryRepository.getById(input.getId())).thenReturn(library);

        ClientDtoResponse clientDtoResponse = new ClientDtoResponse();
        clientDtoResponse.setId(1L);
        clientDtoResponse.setName("Test");
        clientDtoResponse.setFirstSurname("Test");
        clientDtoResponse.setSecondSurname("Test");
        clientDtoResponse.setBirthDate(LocalDate.parse("2010-10-10"));
        clientDtoResponse.setGender("MALE");
        clientDtoResponse.setEmail("test@mail.com");
        clientDtoResponse.setPhone("967574382");

        ClientDtoRequest clientDtoRequest = new ClientDtoRequest(
                library.getAuthorClientId()
        );

        when(this.feignPort.getClientById(clientDtoRequest)).thenReturn(clientDtoResponse);

        ResponseEntity<LibraryDtoResponse> response = this.libraryController.getLibraryById(input);

        LibraryDtoResponse libraryDtoResponse = new LibraryDtoResponse();
        libraryDtoResponse.setId(1L);
        libraryDtoResponse.setName("Test");
        libraryDtoResponse.setAuthor(clientDtoResponse);
        libraryDtoResponse.setEditorial("Test");
        libraryDtoResponse.setPublicationDate(LocalDate.parse("2010-10-10"));

        assertEquals(libraryDtoResponse, response.getBody());
        assertEquals(200, response.getStatusCodeValue());
    }

}
