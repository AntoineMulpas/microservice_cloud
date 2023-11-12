package com.medilabo.microservice_cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients("com.medilabo")
public class MicroserviceCloudApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroserviceCloudApplication.class, args);
	}

}