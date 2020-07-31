package com.shop.online.order.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.shop.online.order.entity.Order;
import com.shop.online.order.exception.OrderNotFoundException;

public interface OrderService {
	
	Page<Order> queryBossByPageAndSort(Integer page, Integer size, String sortBy, Boolean desc, String key);
	
	Order saveOrder(Order order);
	
	Order getOrderById(Long id) throws OrderNotFoundException;
	
	List<Order> findAllOrder();
}
