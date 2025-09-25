package com.ricardo.practica2.services;

public class SpanishGreetingService implements GreetingService {

    @Override
    public String greeting(String name) {
        return "Hola " + name;
    }
}
