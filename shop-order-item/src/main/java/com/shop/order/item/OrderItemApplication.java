package com.shop.order.item;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;


@SpringBootApplication
@EnableDiscoveryClient
public class OrderItemApplication 
{
	public static void main(String[] args) {
		SpringApplication.run(OrderItemApplication.class, args);
	}
	
}
