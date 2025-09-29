package com.ricardo.practica2.controllers;

import com.ricardo.practica2.dto.auth.hello.HelloResponse;
import com.ricardo.practica2.services.HelloService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hello")
public class HelloController {

    private HelloService helloService;

    public HelloController(HelloService helloService) {
        this.helloService = helloService;
    }

    @GetMapping("/first")
    public HelloResponse first()
    {
       return helloService.hello();
    }
}
