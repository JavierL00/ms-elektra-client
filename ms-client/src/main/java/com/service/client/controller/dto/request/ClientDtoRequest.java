package com.service.client.controller.dto.request;

import com.service.client.model.GenderEnum;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Data
public class ClientDtoRequest {
    @NotNull
    private String name;
    @NotNull
    private String firstSurname;
    @NotNull
    private String secondSurname;
    @NotNull
    private LocalDate birthDate;
    @NotNull
    private GenderEnum gender;
    @NotNull
    private String email;
    @NotNull
    private String phone;
}
