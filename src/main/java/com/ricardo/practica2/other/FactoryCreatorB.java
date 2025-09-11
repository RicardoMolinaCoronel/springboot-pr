package com.ricardo.practica2.other;

public class FactoryCreatorB extends FactoryCreator {

    @Override
    FactoryProduct createFactoryProduct() {
        return new FactoryProductB();
    }
}
