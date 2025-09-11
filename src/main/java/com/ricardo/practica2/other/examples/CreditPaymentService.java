package com.ricardo.practica2.other.examples;

import org.springframework.stereotype.Service;

@Service
@Genre(value = "credit", other = "credit1")
public class CreditPaymentService implements PaymentService {
    @Override
    public String processPayment() {
        System.out.println("processPaymentCredit");
        return "payment with credit card";
    }
}
