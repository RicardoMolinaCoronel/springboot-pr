package com.ricardo.practica2.other;

import java.beans.ConstructorProperties;

public class ConstructorInjection {

    private int years;
    private String other;


    @ConstructorProperties({"years", "other"})
    public ConstructorInjection(int years, String other) {
        this.years =  years;
        this.other = other;
    }

}
