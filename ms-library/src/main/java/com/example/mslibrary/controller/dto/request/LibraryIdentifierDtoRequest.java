package com.example.mslibrary.controller.dto.request;

import lombok.Data;

import java.time.LocalDate;

@Data
public class LibraryIdentifierDtoRequest {
    private Long id;
    private String name;
    private Long author;
    private String editorial;
    private LocalDate publicationDate;
}
