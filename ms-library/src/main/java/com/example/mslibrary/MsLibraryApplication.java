package com.example.mslibrary;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class MsLibraryApplication {

    public static void main(String[] args) {
        SpringApplication.run(MsLibraryApplication.class, args);
    }

}
