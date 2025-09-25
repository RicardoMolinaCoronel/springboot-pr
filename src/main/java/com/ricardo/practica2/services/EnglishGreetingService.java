package com.ricardo.practica2.services;

public class EnglishGreetingService implements GreetingService {
    @Override
    public String greeting(String name) {
        return "HIII " + name;
    }
}
