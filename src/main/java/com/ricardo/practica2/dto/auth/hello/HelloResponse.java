package com.ricardo.practica2.dto.auth.hello;

public class HelloResponse {

    private String message;

    public HelloResponse(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
    public void setMessage(String message) {}

}
