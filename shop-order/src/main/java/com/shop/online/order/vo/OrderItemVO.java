package com.shop.online.order.vo;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class OrderItemVO {

	private Long id;
	
	private Long orderId;
	
	private String productCode;
	
	private String productName;
	
	private Long quality;

}
