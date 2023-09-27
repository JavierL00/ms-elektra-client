package com.service.client.controller.mapper;

import com.service.client.controller.dto.request.ClientDtoRequest;
import com.service.client.model.ClientEntity;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-09-26T19:10:00-0500",
    comments = "version: 1.5.2.Final, compiler: javac, environment: Java 17.0.8.1 (JetBrains s.r.o.)"
)
@Component
public class IClientMapperImpl implements IClientMapper {

    @Override
    public ClientEntity toEntity(ClientDtoRequest input) {
        if ( input == null ) {
            return null;
        }

        ClientEntity clientEntity = new ClientEntity();

        clientEntity.setName( input.getName() );
        clientEntity.setFirstSurname( input.getFirstSurname() );
        clientEntity.setSecondSurname( input.getSecondSurname() );
        clientEntity.setBirthDate( input.getBirthDate() );
        clientEntity.setGender( input.getGender() );
        clientEntity.setEmail( input.getEmail() );
        clientEntity.setPhone( input.getPhone() );

        return clientEntity;
    }
}
