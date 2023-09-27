package com.service.client.controller.mapper;

import com.service.client.controller.dto.request.ClientDtoRequest;
import com.service.client.model.ClientEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface IClientMapper {
    @Mapping(target = "id", ignore = true)
    ClientEntity toEntity(ClientDtoRequest input);
}
