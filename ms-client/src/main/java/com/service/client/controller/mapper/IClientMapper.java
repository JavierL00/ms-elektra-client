package com.service.client.controller.mapper;

import com.service.client.controller.dto.request.ClientDtoRequest;
import com.service.client.model.ClientEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface IClientMapper {
    ClientEntity toEntity(ClientDtoRequest input);
}
