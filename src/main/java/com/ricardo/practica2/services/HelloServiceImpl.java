package com.ricardo.practica2.services;


import com.ricardo.practica2.dto.auth.hello.HelloResponse;
import com.ricardo.practica2.feign.ForestClient;
import com.ricardo.practica2.feign.ForestHelloDTO;
import io.github.resilience4j.retry.annotation.Retry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HelloServiceImpl implements HelloService {

    private ForestClient forestClient;
    private static final Logger log = LoggerFactory.getLogger(HelloServiceImpl.class);

    @Autowired
    public HelloServiceImpl(ForestClient forestClient) {
        this.forestClient = forestClient;
    }

   // @Retry(name = "helloRetry")
    public HelloResponse hello() {
        log.info("Calling forest /hello from practica2");

        ForestHelloDTO forestHelloDTO = forestClient.hello();
        return new HelloResponse("Hello from the practice service and the "+forestHelloDTO.getMessage());
    }

}
