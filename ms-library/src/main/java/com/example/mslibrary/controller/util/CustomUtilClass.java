package com.example.mslibrary.controller.util;

import com.example.mslibrary.controller.feign.dto.ClientDtoResponse;
import com.example.mslibrary.controller.dto.response.LibraryDtoResponse;
import com.example.mslibrary.model.LibraryEntity;

public class CustomUtilClass {
    public LibraryDtoResponse toDtoResponse(LibraryEntity libraryEntity, ClientDtoResponse clientDtoResponse) {
        if (libraryEntity == null) {
            return null;
        }

        LibraryDtoResponse libraryDtoResponse = new LibraryDtoResponse();

        libraryDtoResponse.setId(libraryEntity.getId());
        libraryDtoResponse.setName(libraryEntity.getName());
        libraryDtoResponse.setEditorial(libraryEntity.getEditorial());
        libraryDtoResponse.setPublicationDate(libraryEntity.getPublicationDate());
        libraryDtoResponse.setAuthor(clientDtoResponse);

        return libraryDtoResponse;
    }
}
