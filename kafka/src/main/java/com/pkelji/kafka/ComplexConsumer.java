package com.pkelji.kafka;

import java.time.Duration;
import java.util.Arrays;
import java.util.Properties;
import java.util.stream.Collectors;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;

import com.pkelji.kafka.entities.UserData;

public class ComplexConsumer {

	public static void main(String[] args) {
		if(args.length == 0){
			System.out.println("Enter topic name");
			return;
		}
		String topicName = args[0];
		Properties props = new Properties();

		props.put("bootstrap.servers", "localhost:9092");
		props.put("group.id", "test");
		props.put("enable.auto.commit", "true");
		props.put("auto.commit.interval.ms", "1000");
		props.put("session.timeout.ms", "30000");
		props.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, "earliest");
		props.put("key.deserializer", 
		   "org.apache.kafka.common.serialization.StringDeserializer");
		props.put("value.deserializer", 
		   "com.pkelji.kafka.deserializer.UserDataDeserializer");
		
		KafkaConsumer<String, UserData> consumer = new KafkaConsumer<String, UserData>(props);
		
		//Kafka Consumer subscribes list of topics here.
		consumer.subscribe(Arrays.asList(topicName));
		
		//print the topic name
		System.out.println("Subscribed to topic " + topicName);
		consumer.seekToBeginning(consumer.assignment());
		while (true) {
			Duration duration = Duration.ofMillis(100);
			ConsumerRecords<String, UserData> records = consumer.poll(duration);
			for ( ConsumerRecord<String, UserData> record : records ) {
				System.out.printf("offset = %d, key = %s, \n", record.offset(),record.key(), record.value());
				UserData data = record.value();
				//Stream<String> = data.intValues.stream().map(String::valueOf);
				System.out.println("Ïd: " + data.id + ", name: " + data.name
						+ ", intValues: " + data.intValues.stream().map(String::valueOf).collect(Collectors.joining(", "))
						+ ", stringValues: " + data.stringValues.stream().collect(Collectors.joining(", "))
						+ " BufferedImage: " + data.image
				);
			}
		}
	}

}
