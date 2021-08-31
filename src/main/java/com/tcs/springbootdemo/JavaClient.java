//package com.tcs.springbootdemo;
//
//import org.apache.catalina.core.ApplicationContext;
//import org.springframework.boot.SpringApplication;
//import org.springframework.boot.WebApplicationType;
//import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.boot.builder.SpringApplicationBuilder;
//import org.springframework.context.ConfigurableApplicationContext;
//import org.springframework.context.annotation.Bean;
//import org.springframework.web.client.RestTemplate;
//
//@SpringBootApplication
//public class JavaClient {
//	private static String URL = "http://localhost:8080/user/";
//	
//	@Bean
//	RestTemplate rest() {
//		return new RestTemplate();
//	}
//	public static void main(String[] args) {
//		ConfigurableApplicationContext context = new SpringApplicationBuilder(JavaClient.class)
//				.web(WebApplicationType.NONE)
//				.run(args);
//		RestTemplate restTemplate = context.getBean(RestTemplate.class);
//		User response = restTemplate.getForObject(URL + "1", User.class);
//		System.out.println(response.getFirstName());
//	}
//}
