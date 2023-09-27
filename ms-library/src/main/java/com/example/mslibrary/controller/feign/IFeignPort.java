package com.example.mslibrary.controller.feign;

import com.example.mslibrary.controller.feign.dto.ClientDtoResponse;
import com.example.mslibrary.controller.feign.dto.ClientDtoRequest;

public interface IFeignPort {
    ClientDtoResponse getClientById(ClientDtoRequest input);
}
