package com.example.lesson372.services;

import com.example.lesson372.exceptions.NotEnoughMoneyException;
import com.example.lesson372.model.PaymentDetails;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {

    public PaymentDetails processPayment(){
        throw new NotEnoughMoneyException();
    }

}
