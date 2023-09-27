package com.example.mslibrary.controller.feign.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class ClientDtoResponse {
    private Long id;
    private String name;
    private String firstSurname;
    private String secondSurname;
    private LocalDate birthDate;
    private String gender;
    private String email;
    private String phone;
}
