package com.example.mslibrary.controller.dto.response;

import lombok.Data;

import java.time.LocalDate;

@Data
public class LibraryDtoResponse {
    private Long id;
    private String name;
    private ClientDtoResponse author;
    private String editorial;
    private LocalDate publicationDate;
}
