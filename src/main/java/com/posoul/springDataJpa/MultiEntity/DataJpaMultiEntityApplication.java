package com.posoul.springDataJpa.MultiEntity;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class DataJpaMultiEntityApplication {

	public static void main(String[] args) {
		SpringApplication.run(DataJpaMultiEntityApplication.class, args);
	}
}
