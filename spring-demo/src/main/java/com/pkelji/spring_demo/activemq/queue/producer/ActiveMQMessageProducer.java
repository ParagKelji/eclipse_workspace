package com.pkelji.spring_demo.activemq.queue.producer;

import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

import com.pkelji.spring_demo.activemq.model.Message;


@Component
public class ActiveMQMessageProducer {
	private final JmsTemplate jmsTemplate;
	
	public ActiveMQMessageProducer(JmsTemplate jmsTemplate) {
		this.jmsTemplate = jmsTemplate;
	}
	
	public void sendMessage(Message message) {
		jmsTemplate.convertAndSend("active.queue1.ex", message);
	}
}
