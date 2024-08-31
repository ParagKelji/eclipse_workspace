package com.pkelji.spring_demo.activemq.topic.producer;

import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

import com.pkelji.spring_demo.activemq.model.Message;


@Component
public class ActiveMQTopicProducer {
	private final JmsTemplate jmsTemplate;
	
	public ActiveMQTopicProducer(JmsTemplate jmsTemplate) {
		this.jmsTemplate = jmsTemplate;
	}
	
	public void sendMessageToTopic(Message message) {
		jmsTemplate.convertAndSend("active.topic1.ex", message);
	}
}
