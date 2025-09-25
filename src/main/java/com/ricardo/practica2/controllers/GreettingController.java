package com.ricardo.practica2.controllers;

import com.ricardo.practica2.services.GreetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/greeting")
public class GreettingController {

    private GreetingService greetingService;

    @Autowired
    public GreettingController(GreetingService greetingService) {
        this.greetingService = greetingService;
    }

    @GetMapping("/hello")
    public String hello(@RequestParam(defaultValue = "nobody") String name) {
        return greetingService.greeting(name);
    }

}
