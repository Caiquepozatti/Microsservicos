package com.pozatticaique.hrpayroll.services;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.pozatticaique.hrpayroll.entities.Payment;
import com.pozatticaique.hrpayroll.entities.Worker;

import jakarta.transaction.Transactional;

@Service
public class PaymentService {
	
	//Variavel que foi criada dentro do Application.Properties
	@Value("${hr-worker.host}")
	private String workerHost;
			
	@Autowired
	private RestTemplate restTemplate;
	
	@Transactional
	public Payment getPayment(long workerId, int days) {
		Map<String, String> uriVariables = new HashMap<>();
		uriVariables.put("id", toString(workerId));
		Worker worker = restTemplate.getForObject(workerHost + "/workers/{id}", Worker.class, uriVariables);
		return new Payment(worker.getName(), worker.getDailyIncome(), days);
	}

	private String toString(long workerId) {		
		String longForString = String.valueOf(workerId);		
		return longForString;
	}
}
