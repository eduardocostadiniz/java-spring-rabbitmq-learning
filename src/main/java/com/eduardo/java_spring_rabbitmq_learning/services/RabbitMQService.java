package com.eduardo.java_spring_rabbitmq_learning.services;

import java.util.logging.Logger;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eduardo.java_spring_rabbitmq_learning.dtos.ProducerResponseDTO;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class RabbitMQService {

	@Autowired
	private AmqpTemplate amqpTemplate;

	private static final Logger LOGGER = Logger.getLogger(RabbitMQService.class.getName());

	private static final String RABBIT_MQ_EXCHANGE = "JAVA_NEW_DATA_EX";
	private static final String RABBIT_MQ_ROUTING_KEY = "JAVA_NEW_DATA_ROUTING_KEY_01";
	private static final String RABBIT_MQ_QUEUE = "JAVA_NEW_DATA_QUEUE_01";

	public void sendMessage(ProducerResponseDTO data) throws JsonProcessingException {
		ObjectMapper mapper = new ObjectMapper();

		String strData = mapper.writeValueAsString(data);

		LOGGER.info("*********************************************************************");
		LOGGER.info("Enviando mensagem:");
		LOGGER.info(strData);
		LOGGER.info("*********************************************************************");

		this.amqpTemplate.convertAndSend(RABBIT_MQ_EXCHANGE, RABBIT_MQ_ROUTING_KEY, strData);
	}

	@RabbitListener(queues = RABBIT_MQ_QUEUE)
	public void receiveMessage(String content) {
		LOGGER.info("-------------------------------------------------------------------");
		LOGGER.info("Consumindo mensagem:");
		LOGGER.info(content);
		LOGGER.info("-------------------------------------------------------------------");
	}

}
