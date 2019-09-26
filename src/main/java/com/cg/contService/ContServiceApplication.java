package com.cg.contService;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
//import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableAutoConfiguration
@ComponentScan("com.cg.contService.*")
public class ContServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ContServiceApplication.class, args);
	}

}
