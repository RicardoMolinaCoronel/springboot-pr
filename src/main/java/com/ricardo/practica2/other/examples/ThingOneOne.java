package com.ricardo.practica2.other.examples;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ThingOneOne {

    PaymentService paymentService;

    @Autowired
    public ThingOneOne(PaymentService paymentService) {
        this.paymentService = paymentService;
        paymentService.processPayment();

    }


}
