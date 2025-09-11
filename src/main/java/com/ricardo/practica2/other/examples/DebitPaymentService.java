package com.ricardo.practica2.other.examples;


import org.springframework.stereotype.Service;

@Service("debitPaymentService")
public class DebitPaymentService implements PaymentService {
    @Override
    public String processPayment() {
        return "payment with debit card";
    }
}
