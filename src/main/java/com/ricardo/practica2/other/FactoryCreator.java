package com.ricardo.practica2.other;

public abstract class FactoryCreator {

    abstract FactoryProduct createFactoryProduct();

    String mainFunction() {

        FactoryProduct product = createFactoryProduct();

        return "Im doing my stuff with a product....\n" + product.doSomething();
    }


}
