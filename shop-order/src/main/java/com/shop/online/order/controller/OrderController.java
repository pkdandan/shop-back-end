package com.shop.online.order.controller;

import java.time.LocalDate;
import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shop.online.order.constant.Constant;
import com.shop.online.order.entity.Order;
import com.shop.online.order.exception.OrderNotFoundException;
import com.shop.online.order.service.OrderService;
import com.shop.online.order.vo.OrderItemVO;
import com.shop.online.order.vo.OrderVO;
import com.shop.online.order.vo.Result;

@CrossOrigin
@RestController
@RequestMapping("/order")
@Validated
public class OrderController {
	
	@Autowired
	private OrderService orderService;
	
	@Autowired
	OrderItemClient orderItemClient;
	
	@PostMapping("saveOrder")
	public Result<Order> saveOrder(@RequestBody @Valid OrderVO orderVo) {
		Order order = new Order();
		BeanUtils.copyProperties(orderVo, order);
		order.setOrderDate(LocalDate.now());
		order = orderService.saveOrder(order);
		return new Result<Order>(Constant.SUCCESS,order);
	}
	
	@GetMapping("/getOrderDetails/{orderId}")
	public Result<List<OrderItemVO>> getAllOrderItemsByOrderId(@PathVariable(name="orderId") @NotNull Long orderId) throws OrderNotFoundException{
		Order order= orderService.getOrderById(orderId);
		List<OrderItemVO> orderItemVoList = orderItemClient.getOrderItems(orderId);
		OrderVO orderVo = new OrderVO();
		BeanUtils.copyProperties(order, orderVo);
		//orderVo.setOrderItemVoList(orderItemVoList);
		return new Result<List<OrderItemVO>>(Constant.SUCCESS, orderItemVoList);
	}
	
	@GetMapping("/getAllOrders")
	public Result<List<Order>> findAllOrders(){
		List<Order> orderList = orderService.findAllOrder();
		
		return new Result<List<Order>>(Constant.SUCCESS, orderList);
	}

}
