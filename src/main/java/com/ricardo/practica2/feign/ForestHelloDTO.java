package com.ricardo.practica2.feign;

public class ForestHelloDTO {

    private  String message;

    public ForestHelloDTO() {}                  // needed for Jackson

    public ForestHelloDTO(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
    public void setMessage(String message) {}


}
