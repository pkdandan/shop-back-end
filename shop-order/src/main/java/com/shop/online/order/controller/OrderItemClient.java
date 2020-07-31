package com.shop.online.order.controller;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.shop.online.order.vo.OrderItemVO;

@FeignClient(name = "shop-order-item")
public interface OrderItemClient {
	
	@GetMapping("/orderItem/fetchOrderItem//{orderId}")
    List<OrderItemVO> getOrderItems(@PathVariable Long orderId);

}
