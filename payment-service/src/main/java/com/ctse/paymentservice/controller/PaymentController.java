package com.ctse.paymentservice.controller;

import com.ctse.paymentservice.model.Payment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@RestController
@RequestMapping("/payments")
public class PaymentController {

    private final List<Payment> payments = new ArrayList<>();
    private final AtomicLong counter = new AtomicLong(0);

    @GetMapping
    public ResponseEntity<List<Payment>> getAllPayments() {
        return ResponseEntity.ok(payments);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Payment> getPaymentById(@PathVariable Long id) {
        return payments.stream()
                .filter(payment -> payment.getId().equals(id))
                .findFirst()
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping("/process")
    public ResponseEntity<Payment> processPayment(@RequestBody Payment payment) {
        payment.setId(counter.incrementAndGet());
        payment.setStatus("SUCCESS");
        payments.add(payment);
        return ResponseEntity.status(HttpStatus.CREATED).body(payment);
    }
}
