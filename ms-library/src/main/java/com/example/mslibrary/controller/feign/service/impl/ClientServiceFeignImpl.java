package com.example.mslibrary.controller.feign.service.impl;

import com.example.mslibrary.controller.feign.dto.ClientDtoResponse;
import com.example.mslibrary.controller.feign.dto.ClientDtoRequest;
import com.example.mslibrary.controller.feign.service.IClientServiceFeign;
import com.example.mslibrary.controller.feign.IFeignPort;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class ClientServiceFeignImpl implements IFeignPort {
    private final IClientServiceFeign clientServiceFeign;

    @Override
    public ClientDtoResponse getClientById(ClientDtoRequest input) {
        return clientServiceFeign.getClientById(input);
    }
}
