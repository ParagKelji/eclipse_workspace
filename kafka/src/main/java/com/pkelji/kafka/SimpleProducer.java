package com.pkelji.kafka;
//import util.properties packages
import java.util.Properties;

//import simple producer packages
import org.apache.kafka.clients.producer.Producer;

//import KafkaProducer packages
import org.apache.kafka.clients.producer.KafkaProducer;

//import ProducerRecord packages
import org.apache.kafka.clients.producer.ProducerRecord;

public class SimpleProducer {

	public static void main(String[] args) {
		if ( args.length == 0 ) {
			System.out.println("Enter topic name...");
			return;
		}
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
					"org.apache.kafka.common.serialization.StringSerializer");
		
		Producer<String, String> producer = new KafkaProducer<String, String>(props);
		
		for(int i = 11; i < 20; i++) {
			producer.send(new ProducerRecord<String, String>(topicName,  Integer.toString(i), Integer.toString(i)));
		}
		System.out.println("Message sent successfully");
        producer.close();
	}

}
