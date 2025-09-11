package com.ricardo.practica2.other.examples;


import org.springframework.stereotype.Service;

@Offline
@Service
public class CellphonePayment implements PaymentService {


    @Override
    public String processPayment() {
        return "cellphone payment";
    }
}
