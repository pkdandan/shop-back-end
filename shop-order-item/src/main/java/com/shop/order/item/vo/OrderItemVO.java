package com.shop.order.item.vo;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class OrderItemVO {

	private Long id;
	
	private String productCode;
	
	private String productName;
	
	private Long quality;

}
