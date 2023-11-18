package com.opensource.vaxlocator;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableFeignClients
@EnableJpaRepositories(basePackages = "com.opensource.vaxlocator.domains.repositories")
public class VaxlocatorApplication {

	public static void main(String[] args) {
		SpringApplication.run(VaxlocatorApplication.class, args);
	}

}
