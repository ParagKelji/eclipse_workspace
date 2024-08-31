package com.pkelji.spring_demo.activemq.queue.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.pkelji.spring_demo.activemq.model.Message;
import com.pkelji.spring_demo.activemq.queue.producer.ActiveMQMessageProducer;


@RestController
public class ActiveMQMessageController {
	
	private final ActiveMQMessageProducer messageProducer;
	
	public ActiveMQMessageController(ActiveMQMessageProducer messageProducer) {
		this.messageProducer = messageProducer;
	}
	
	@PostMapping("/publish-message")
	public ResponseEntity<String> publishMessage(@RequestBody String messageText) {
		Message message = new Message(messageText);
		try {
			messageProducer.sendMessage(message);
			return new ResponseEntity<String>("Message published successfully", HttpStatus.OK);
		} catch(Exception e) {
			return new ResponseEntity<String>("Error publishing the message: " + e.toString(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/hello")
	public ResponseEntity<String> sayHello() {
		return new ResponseEntity<String>("Hello from spring: ", HttpStatus.OK);
	}
	
}
