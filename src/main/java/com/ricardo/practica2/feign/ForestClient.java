package com.ricardo.practica2.feign;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "forest-service", fallback = ForestFallback.class)
public interface ForestClient {

    @GetMapping("/hello")
    ForestHelloDTO hello();
}
