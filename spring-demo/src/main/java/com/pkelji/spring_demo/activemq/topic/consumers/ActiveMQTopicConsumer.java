package com.pkelji.spring_demo.activemq.topic.consumers;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import com.pkelji.spring_demo.activemq.model.Message;

@Component
public class ActiveMQTopicConsumer {
	
	@JmsListener(destination = "active.topic1.ex", containerFactory = "topicListenerFactory")
	public void receiveMessage1(Message message) {
		System.out.println("Received message on subscriber 1: " + Thread.currentThread().getStackTrace()[0].getMethodName() + "message: " + message.getText());
	}
	
	@JmsListener(destination = "active.topic1.ex", containerFactory = "topicListenerFactory")
	public void receiveMessage2(Message message) {
		System.out.println("Received message on subscriber 2: " + Thread.currentThread().getStackTrace()[0].getMethodName() + "message: " + message.getText());
	}
}
