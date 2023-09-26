package com.service.client.controller;

import com.service.client.model.ClientEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IClientRepository extends JpaRepository<ClientEntity, Long> {
    ClientEntity findClientEntityByName(String name);
}
