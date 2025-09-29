package com.ricardo.practica2.services;


import com.ricardo.practica2.dto.auth.hello.HelloResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HelloServiceImpl implements HelloService {
    private static final Logger log = LoggerFactory.getLogger(HelloServiceImpl.class);

   // private ForestClient forestClient;

  //  @Autowired
 //   public HelloServiceImpl(ForestClient forestClient) {
  //      this.forestClient = forestClient;
  //  }

    public HelloResponse hello() {
        log.info("forest /hello served");

        //  ForestHelloDTO forestHelloDTO = forestClient.hello();
        return new HelloResponse("Hello from the forest service");
    }

}
