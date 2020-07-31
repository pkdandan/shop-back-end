package com.shop.online.order.entity;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="shop_order")
public class Order {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="customer_name")
	private String customerName;
	
	@Column(name="order_date")
	private LocalDate orderDate;	
	
	@Column(name="shipping_address")
	private String shippingAddress;
	
	@Column(name="total", precision = 22, scale = 4)
	private BigDecimal total;

}
