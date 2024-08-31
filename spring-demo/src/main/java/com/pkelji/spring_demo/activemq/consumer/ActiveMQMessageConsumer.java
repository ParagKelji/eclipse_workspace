package com.pkelji.spring_demo.activemq.consumer;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import com.pkelji.spring_demo.activemq.model.Message;


@Component
public class ActiveMQMessageConsumer {
	
	@JmsListener(destination = "active.queue1.ex")
	public void receiveMessage(Message message) {
		System.out.println("Active MQ JMS message received: " + message.getText());
	}
}
