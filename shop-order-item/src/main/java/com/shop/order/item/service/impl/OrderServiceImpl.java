package com.shop.order.item.service.impl;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.shop.order.item.entity.OrderItem;
import com.shop.order.item.exceptions.OrderItemNotFoundException;
import com.shop.order.item.repositories.OrderItemRepository;
import com.shop.order.item.service.OrderItemService;


@Service
public class OrderServiceImpl implements OrderItemService {
	
	@Autowired
	private OrderItemRepository orderItemRepository;

	@Override
	public Page<OrderItem> queryBossByPageAndSort(Integer page, Integer size, String sortBy, Boolean desc, String key) {
		Pageable pageable = PageRequest.of(page, size, desc ? Direction.DESC : Direction.ASC, key);
		return orderItemRepository.findAll(pageable);
	}
	
	@Override
	public OrderItem createOrderItem(OrderItem orderItem) {
		return orderItemRepository.save(orderItem);
	}

	@Override
	public OrderItem findOrderItemById(Long id) throws OrderItemNotFoundException {
		
		return orderItemRepository.findById(id).orElseThrow(()->new OrderItemNotFoundException("order item not found"));
	}
	
	@Override
	public List<OrderItem> findAllOrderItems(){
		return orderItemRepository.findAll();
	}
	
	

}
