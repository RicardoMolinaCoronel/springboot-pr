package com.ricardo.practica2.controllers;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/logger")
public class LoggerController {

    Logger logger = LoggerFactory.getLogger(LoggerController.class);


    @GetMapping("/")
    public String index() {
        logger.trace("TRACE");
        logger.warn("WARN");
        logger.info("INFO");
        logger.error("ERROR");
        logger.debug("DEBUG");
        return "Im logging....";
    }

}
