package com.Bank_Property_Evaluation.PropertyManagement;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.camunda.zeebe.spring.client.EnableZeebeClient;

@EnableZeebeClient
@SpringBootApplication
public class PropertyManagementApplication {

	public static void main(String[] args) {
		SpringApplication.run(PropertyManagementApplication.class, args);
	}

}
