package com.pkelji.kafka;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import javax.imageio.ImageIO;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;

import com.pkelji.kafka.entities.UserData;

public class ComplexProducer {
	
	public UserData createUserData() {
		UserData data = new UserData();
		data.id = 22;
		data.name = "Parag Radhakrishna Kelji";
		List<Integer> intValues = new ArrayList<>();
		for (int i = 0; i < 4; i++ ) {
			intValues.add((i + 1) * data.id);
		}
		data.intValues = intValues;
		List<String> stringValues = new ArrayList<>();
		stringValues.add("Parag");
		stringValues.add("Radhakrishna");
		stringValues.add("Reshma");
		stringValues.add("Kelji");
		data.stringValues = stringValues;
		File imgFile = new File("src/main/resources/PRK_Thumbnail.png");
		data.image = new BufferedImage(350, 350, BufferedImage.TYPE_INT_RGB);
		try {
			data.image = ImageIO.read(imgFile);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return data;
	}
	
	public static void main(String[] args) {
		if ( args.length == 0 ) {
			System.out.println("Enter topic name...");
			return;
		}
		ComplexProducer complexProducer = new ComplexProducer();
		String topicName = args[0];
		Properties props = new Properties();
		props.put("bootstrap.servers", "localhost:9092");
		//Set acknowledgements for producer requests.
		props.put("acks", "all");
		//If the request fails, the producer can automatically retry,
		props.put("retries", 0);
		props.put("batch.size", 16384);
		
		//Reduce the no of requests less than 0   
		props.put("linger.ms", 1);
		
		//The buffer.memory controls the total amount of memory available to the producer for buffering.   
		props.put("buffer.memory", 33554432);
		
		props.put("key.serializer", 
					"org.apache.kafka.common.serialization.StringSerializer");
		
		props.put("value.serializer", 
					"com.pkelji.kafka.serializer.UserDataSerializer");
		
		Producer<String, UserData> producer = new KafkaProducer<String, UserData>(props);
		
		UserData userData = complexProducer.createUserData();
		producer.send(new ProducerRecord<String, UserData>(topicName, "ParagRKelji", userData));
		System.out.println("Message sent successfully");
        producer.close();
	}

}
