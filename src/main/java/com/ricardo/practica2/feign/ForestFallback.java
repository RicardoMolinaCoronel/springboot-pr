package com.ricardo.practica2.feign;

import org.springframework.stereotype.Component;

@Component
public class ForestFallback implements ForestClient{

    @Override
    public ForestHelloDTO hello() {
        return new ForestHelloDTO("No hello for forest service");
    }
}
