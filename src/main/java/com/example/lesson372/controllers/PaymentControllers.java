package com.example.lesson372.controllers;

import com.example.lesson372.exceptions.NotEnoughMoneyException;
import com.example.lesson372.model.ErrorDetails;
import com.example.lesson372.model.PaymentDetails;
import com.example.lesson372.services.PaymentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.logging.Logger;

@RestController
public class PaymentControllers {

    private static Logger logger = Logger.getLogger(PaymentControllers.class.getName());

    private final PaymentService paymentService;

    public PaymentControllers(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    @PostMapping("/payment")
    public ResponseEntity<?> makePayment(){
            PaymentDetails paymentDetails = paymentService.processPayment();
            return ResponseEntity
                    .status(HttpStatus.ACCEPTED)
                    .body(paymentDetails);

    }

    @PostMapping("/mpayment")
    public ResponseEntity<PaymentDetails> mPayment(
            @RequestBody PaymentDetails paymentDetails
    ){
        logger.info("Receive payment " + paymentDetails.getAmount());
        return ResponseEntity
                .status(HttpStatus.ACCEPTED)
                .body(paymentDetails);

    }
}
