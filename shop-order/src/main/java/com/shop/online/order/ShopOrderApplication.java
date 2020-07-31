package com.shop.online.order;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
@EnableWebMvc
public class ShopOrderApplication {

	public static void main(String[] args) {
		SpringApplication.run(ShopOrderApplication.class, args);
	}
	
}
