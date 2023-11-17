package com.opensource.vaxlocator;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class VaxlocatorApplication {

	public static void main(String[] args) {
		SpringApplication.run(VaxlocatorApplication.class, args);
	}

}
