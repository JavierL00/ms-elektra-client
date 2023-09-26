package com.service.client.controller.dto;

import lombok.Data;

import javax.validation.constraints.Min;


@Data
public class ClientIdentifierDto {
    @Min(value = 1, message = "El campo 'id' debe ser un número positivo")
    private Long id;
}
