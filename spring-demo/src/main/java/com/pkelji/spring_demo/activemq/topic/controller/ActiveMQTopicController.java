package com.pkelji.spring_demo.activemq.topic.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.pkelji.spring_demo.activemq.model.Message;
import com.pkelji.spring_demo.activemq.topic.producer.ActiveMQTopicProducer;

@RestController
public class ActiveMQTopicController {

	private final ActiveMQTopicProducer messageProducer;
	
	public ActiveMQTopicController(ActiveMQTopicProducer messageProducer) {
		this.messageProducer = messageProducer;
	}
	
	@PostMapping("/publish-topic-message")
	public ResponseEntity<String> publishMessage(@RequestBody String messageText) {
		Message message = new Message(messageText);
		try {
			messageProducer.sendMessageToTopic(message);
			return new ResponseEntity<String>("Message published successfully", HttpStatus.OK);
		} catch(Exception e) {
			return new ResponseEntity<String>("Error publishing the message: " + e.toString(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
}
