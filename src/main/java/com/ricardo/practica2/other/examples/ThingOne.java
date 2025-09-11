package com.ricardo.practica2.other.examples;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.Set;

@Component
public class ThingOne {

    private ThingThree thingThree;

    @Genre(value = "credit", other = "credit1")
    private PaymentService creditPaymentService;

    @Offline
    private PaymentService cellphonePaymentService;


    public ThingOne(ThingTwo thingTwo, @Qualifier("debitPaymentService1") PaymentService paymentService,
                    Set<PaymentService> paymentServiceSet,
                    @Genre(value = "credit", other = "credit1") PaymentService creditPaymentService,
                    @Offline PaymentService cellphonePaymentService) {
        System.out.println("INSTANTIATED");
        System.out.println("CELLPHONE PAYMENT: " + cellphonePaymentService.processPayment());
        System.out.println("CREDIT PAYMENT: " + creditPaymentService.processPayment());

    }

    @Autowired
    public void setThingThree(ThingThree thingThree){
        System.out.println("setThingThree");
        this.thingThree = thingThree;
    }

}
