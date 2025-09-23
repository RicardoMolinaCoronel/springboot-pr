package com.ricardo.practica2.controllers;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v2/other")
public class HelloControllerV2 {

    @PreAuthorize("hasRole('ADMIN') or hasRole('USER')")
    @GetMapping(value = "/hello", headers = "X-API-VERSION=2")
    public String hello(){
        return "Hello authenticated user!";
    }
}
