package com.ricardo.practica2.other.examples;


import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashSet;
import java.util.Set;

@Configuration
public class AppConfiguration {

    @Bean
   // @Qualifier("creditPaymentService1")
    public PaymentService creditPaymentService1() {
        return new CreditPaymentService();
    }

    @Bean
    @Qualifier("debitPaymentService2")
    public PaymentService debitPaymentService1() {
        System.out.println("debitPaymentService1");
        return new DebitPaymentService();
    }

    @Bean
    public Set<PaymentService> paymentServiceSet() {
        System.out.println("paymentServiceSet");
        return new HashSet<>();
    }


}
