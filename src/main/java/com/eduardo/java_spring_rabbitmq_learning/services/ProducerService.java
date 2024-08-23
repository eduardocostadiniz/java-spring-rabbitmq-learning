package com.eduardo.java_spring_rabbitmq_learning.services;

import java.time.LocalDateTime;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eduardo.java_spring_rabbitmq_learning.dtos.ProducerResponseDTO;
import com.fasterxml.jackson.core.JsonProcessingException;

@Service
public class ProducerService {

	@Autowired
	private RabbitMQService rabbitmqService;

	public ProducerResponseDTO generateData() throws JsonProcessingException {
		String now = LocalDateTime.now().toString();
		String id = UUID.randomUUID().toString();
		ProducerResponseDTO data = new ProducerResponseDTO(id, now);

		this.rabbitmqService.sendMessage(data);
		return data;
	}

}
