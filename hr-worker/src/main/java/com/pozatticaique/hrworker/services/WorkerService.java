package com.pozatticaique.hrworker.services;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pozatticaique.hrworker.entities.Worker;
import com.pozatticaique.hrworker.repositories.WorkerRepository;

import jakarta.transaction.Transactional;

@Service
public class WorkerService implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Autowired
	private WorkerRepository workerRepository;
	
	@Transactional
	public List<Worker> findAll(){
		List<Worker> result = workerRepository.findAll();
		return result;
	}
	
	@Transactional
	public Worker findById(Long id){
		Worker result = workerRepository.findById(id).get();
		return result;
	}

}
