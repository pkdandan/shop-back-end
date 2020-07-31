package com.shop.online.order.vo;

import java.time.LocalDate;

import javax.validation.constraints.NotNull;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class OrderVO {

	private Long id;
	
	@NotNull
	private String customerName;
	
	private LocalDate orderDate;
	
	@NotNull
	private String shippingAddress;
	
	private Long orderItem;
	
}
