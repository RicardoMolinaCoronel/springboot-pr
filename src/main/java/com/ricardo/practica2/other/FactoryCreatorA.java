package com.ricardo.practica2.other;

public class FactoryCreatorA extends FactoryCreator {

    @Override
    FactoryProduct createFactoryProduct() {
        return new FactoryProductA();
    }
}
