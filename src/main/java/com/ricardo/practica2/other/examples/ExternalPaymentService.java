package com.ricardo.practica2.other.examples;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

@Primary
@Service
public class ExternalPaymentService implements PaymentService {
    @Override
    public String processPayment() {
        System.out.println("PROCESSING EXTERNAL");
        return "external";
    }
}
