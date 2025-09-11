package com.ricardo.practica2.other.examples;

import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component("myCommandLineRunner")
@Order(1)
public class MyCommandLineRunner implements CommandLineRunner {
    @Override
    public void run(String... args) throws Exception {
        System.out.println("COMMAND LINE RUNNER STARTED");
        System.out.println(Arrays.toString(args));
    }
}
