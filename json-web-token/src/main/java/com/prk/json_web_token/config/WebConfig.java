package com.prk.json_web_token.config;

import java.util.Arrays;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

//@Configuration
//@EnableWebMvc
public class WebConfig implements WebMvcConfigurer {

	@Override
	public void addCorsMappings(CorsRegistry registry) {
//		registry.addMapping("/**")
//		.allowedOrigins("http://localhost:4200")
//		.allowedMethods(
//				HttpMethod.DELETE.name(),
//				HttpMethod.GET.name(),
//				HttpMethod.HEAD.name(),
//				HttpMethod.OPTIONS.name(),
//				HttpMethod.PATCH.name(),
//				HttpMethod.POST.name(),
//				HttpMethod.PUT.name(),
//				HttpMethod.TRACE.name()
//			)
//		.allowedHeaders(
//				HttpHeaders.AUTHORIZATION, 
//				HttpHeaders.CONTENT_TYPE, 
//				HttpHeaders.ACCEPT
//			)
//		.allowCredentials(true)
//		.maxAge(3600L)
//		;
	}

}
