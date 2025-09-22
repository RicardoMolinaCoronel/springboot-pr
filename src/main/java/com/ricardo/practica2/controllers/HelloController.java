package com.ricardo.practica2.controllers;


import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("other")
public class HelloController {

    public HelloController() {

    }

    @PreAuthorize("hasRole('ADMIN') or hasRole('USER')")
    @GetMapping("/hello")
    public String hello(){
        return "Hello authenticated user!";
    }

    @Secured("ROLE_ADMIN")
    @GetMapping("/helloAdmin")
    public String helloAdmin(){
        return "Hello authenticated ADMIN user!";
    }

    @Secured("ROLE_USER")
    @GetMapping("/helloUser")
    public String helloUser(){
        return "Hello authenticated USER user!";
    }

    @GetMapping("/public")
    public String publicHello(){
        return "Hello public user!";
    }



}
