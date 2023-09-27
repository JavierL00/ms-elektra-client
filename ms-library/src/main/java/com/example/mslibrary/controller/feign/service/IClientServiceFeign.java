package com.example.mslibrary.controller.feign.service;

import com.example.mslibrary.controller.feign.dto.ClientDtoResponse;
import com.example.mslibrary.controller.feign.dto.ClientDtoRequest;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;

@FeignClient(name = "ms-client", url = "http://localhost:9090")
public interface IClientServiceFeign {
    @PostMapping("/client/id")
    ClientDtoResponse getClientById(ClientDtoRequest input);
}
