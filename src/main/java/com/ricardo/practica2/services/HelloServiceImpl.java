package com.ricardo.practica2.services;


import com.ricardo.practica2.dto.auth.hello.HelloResponse;
import com.ricardo.practica2.feign.ForestClient;
import com.ricardo.practica2.feign.ForestHelloDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HelloServiceImpl implements HelloService {

    private ForestClient forestClient;

    @Autowired
    public HelloServiceImpl(ForestClient forestClient) {
        this.forestClient = forestClient;
    }

    public HelloResponse hello() {
        ForestHelloDTO forestHelloDTO = forestClient.hello();
        return new HelloResponse("Hello from the practice service and the "+forestHelloDTO.getMessage());
    }

}
