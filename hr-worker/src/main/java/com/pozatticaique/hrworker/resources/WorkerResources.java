package com.pozatticaique.hrworker.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pozatticaique.hrworker.entities.Worker;
import com.pozatticaique.hrworker.services.WorkerService;

@RestController
@RequestMapping(value="/workers")
public class WorkerResources {
	
	@Autowired
	private WorkerService workerService;	
	
	@GetMapping
	public ResponseEntity<List<Worker>> findAll(){
		List<Worker> result = workerService.findAll();
		return ResponseEntity.ok().body(result);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Worker> findById(@PathVariable Long id){
		Worker result = workerService.findById(id);
		return ResponseEntity.ok().body(result);
	}

}
