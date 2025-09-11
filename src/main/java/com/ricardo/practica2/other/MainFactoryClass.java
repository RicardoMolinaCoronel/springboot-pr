package com.ricardo.practica2.other;

public class MainFactoryClass {

    public static void main(String[] args){


        String need = "A";

        FactoryCreator creator = switch (need) {
            case "A" -> new FactoryCreatorA();
            case "B" -> new FactoryCreatorB();
            default -> new FactoryCreatorA();
        };

        

        System.out.println(creator.mainFunction());



    }


}
