package com.pozatticaique.hrpayroll.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pozatticaique.hrpayroll.entities.Payment;
import com.pozatticaique.hrpayroll.entities.Worker;
import com.pozatticaique.hrpayroll.feignclients.WorkerFeignClient;

import jakarta.transaction.Transactional;

@Service
public class PaymentService {	
	/*
	//Variavel que foi criada dentro do Application.Properties
	@Value("${hr-worker.host}")
	private String workerHost;*/
			
	@Autowired
	private WorkerFeignClient workerFeignClient;
	
	@Transactional
	public Payment getPayment(long workerId, int days) {
		/*Map<String, String> uriVariables = new HashMap<>();
		uriVariables.put("id", toString(workerId));
		Worker worker = workerFeignClient.getForObject(workerHost + "/workers/{id}", Worker.class, uriVariables);
		*/
		Worker worker = workerFeignClient.findById(workerId).getBody();
		return new Payment(worker.getName(), worker.getDailyIncome(), days);
	}
	
	/*
	private String toString(long workerId) {		
		String longForString = String.valueOf(workerId);		
		return longForString;	
	}
	*/
}
