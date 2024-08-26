package com.prk.json_web_token;

import java.util.TimeZone;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class JsonWebTokenApplication {
	
	public static void main(String[] args) {
		TimeZone timeZone = TimeZone.getDefault();
		TimeZone.setDefault(timeZone);
		SpringApplication.run(JsonWebTokenApplication.class, args);
	}
	
}
