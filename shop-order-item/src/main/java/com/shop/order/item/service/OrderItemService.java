package com.shop.order.item.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.shop.order.item.entity.OrderItem;
import com.shop.order.item.exceptions.OrderItemNotFoundException;


public interface OrderItemService {
	
	Page<OrderItem> queryBossByPageAndSort(Integer page, Integer size, String sortBy, Boolean desc, String key);
	
	OrderItem createOrderItem(OrderItem orderItem);
	
	OrderItem findOrderItemById(Long id) throws OrderItemNotFoundException;
	
	List<OrderItem> findAllOrderItems();
}
