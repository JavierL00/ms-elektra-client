package com.example.mslibrary.configuration;

import com.example.mslibrary.controller.feign.service.impl.ClientServiceFeignImpl;
import com.example.mslibrary.controller.feign.service.IClientServiceFeign;
import com.example.mslibrary.controller.feign.IFeignPort;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class BeanConfiguration {
    private final IClientServiceFeign clientServiceFeign;

    @Bean
    public IFeignPort feignPort() {
        return new ClientServiceFeignImpl(clientServiceFeign);
    }
}
