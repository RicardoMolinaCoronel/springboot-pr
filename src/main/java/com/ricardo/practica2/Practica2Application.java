package com.ricardo.practica2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Practica2Application {

	public static void main(String[] args) {
		String[] customArgs = new String[] {"--option1=value1", "arg1", "arg2"};
        SpringApplication.run(Practica2Application.class, customArgs);
	}

}
