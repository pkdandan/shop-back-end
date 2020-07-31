package com.shop.order.item.controller;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shop.order.item.constant.Constant;
import com.shop.order.item.entity.OrderItem;
import com.shop.order.item.exceptions.OrderItemNotFoundException;
import com.shop.order.item.service.OrderItemService;
import com.shop.order.item.vo.Result;

@CrossOrigin
@RestController
@Validated
@RequestMapping("orderItem")
public class OrderItemController {
	
	@Autowired
	private OrderItemService orderItemService;
	
	@PostMapping("createOrderItem")
	public ResponseEntity<OrderItem> createOrderItem(@RequestBody @Valid OrderItem orderItem) {
		return ResponseEntity.ok(orderItemService.createOrderItem(orderItem));
	}
	
	@GetMapping("fetchOrderItem/{orderItemId}")
	public Result<OrderItem> fetchOrderItem(@PathVariable @NotNull Long orderItemId) throws OrderItemNotFoundException {
		return new Result<OrderItem>(Constant.SUCCESS,orderItemService.findOrderItemById(orderItemId));
	
	}
	
	@GetMapping("fetchAllItem")
	public Result<List<OrderItem>> fetchAllOrderItem() {
		
		return new Result<List<OrderItem>>(Constant.SUCCESS,orderItemService.findAllOrderItems());
	}
}
