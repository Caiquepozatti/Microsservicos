package com.pozatticaique.hrpayroll.services;

import org.springframework.stereotype.Service;

import com.pozatticaique.hrpayroll.entities.Payment;

import jakarta.transaction.Transactional;

@Service
public class PaymentService {
	
	@Transactional
	public Payment getPayment(long workerId, int days) {
		return new Payment("Bob", 200.00, days);
	}
}
