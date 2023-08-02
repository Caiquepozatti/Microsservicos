package com.pozatticaique.hrpayroll.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pozatticaique.hrpayroll.entities.Payment;
import com.pozatticaique.hrpayroll.services.PaymentService;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;

@RestController
@RequestMapping(value = "/payments")
public class PaymentResource {
	
	@Autowired
	private PaymentService service;
	
	@CircuitBreaker(name = "getPayment", fallbackMethod = "getPaymentFallback")
	@GetMapping(value = "/{workerId}/days/{days}")
	public ResponseEntity<Payment> getPayment(@PathVariable Long workerId,@PathVariable Integer days) {		
		Payment result= service.getPayment(workerId,days); 
		return ResponseEntity.ok().body(result);		
	}
	
	public ResponseEntity<Payment> getPaymentFallback(Long workerId,Integer days) {
		Payment result = new Payment("Brann", 400.00, days);
		return ResponseEntity.ok().body(result);	
	}
}
