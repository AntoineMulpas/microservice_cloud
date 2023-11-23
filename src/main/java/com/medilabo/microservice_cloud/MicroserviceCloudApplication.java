package com.medilabo.microservice_cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.config.server.EnableConfigServer;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients("com.medilabo")
@EnableConfigServer
@EnableDiscoveryClient
public class MicroserviceCloudApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroserviceCloudApplication.class, args);
	}

}
