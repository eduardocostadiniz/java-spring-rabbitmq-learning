package com.eduardo.java_spring_rabbitmq_learning.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.eduardo.java_spring_rabbitmq_learning.dtos.ProducerResponseDTO;
import com.eduardo.java_spring_rabbitmq_learning.services.ProducerService;
import com.fasterxml.jackson.core.JsonProcessingException;

@RestController
@RequestMapping("/producer")
public class ProducerController {

	@Autowired
	private ProducerService producer;

	@GetMapping
	public ResponseEntity<ProducerResponseDTO> publishMessage() throws JsonProcessingException {
		return ResponseEntity.status(HttpStatus.OK).body(producer.generateData());
	}

}
