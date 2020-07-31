package com.shop.online.order.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.shop.online.order.entity.Order;
import com.shop.online.order.exception.OrderNotFoundException;
import com.shop.online.order.repositories.OrderRepository;
import com.shop.online.order.service.OrderService;

@Service
public class OrderServiceImpl implements OrderService {
	
	@Autowired
	private OrderRepository orderRepository;

	@Override
	public Page<Order> queryBossByPageAndSort(Integer page, Integer size, String sortBy, Boolean desc, String key) {
		Pageable pageable = PageRequest.of(page, size, desc ? Direction.DESC : Direction.ASC, key);
		return orderRepository.findAll(pageable);
	}
	
	@Transactional
	@Override
	public Order saveOrder(Order order) {
		return orderRepository.save(order);
	}

	@Override
	public Order getOrderById(Long orderId) throws OrderNotFoundException {
		
		return orderRepository.findById(orderId).orElseThrow(()-> new OrderNotFoundException("order not found"));
	}

	@Override
	public List<Order> findAllOrder() {
		return orderRepository.findAll();
	}
	
	

}
