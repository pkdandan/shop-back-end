package com.shop.online.order.vo;

import lombok.Data;

@Data
public class Result <T> {

	private String status;
	private T data;
	
	public Result(String status,T data) {
		this.status = status;
		this.data = data;
	}
}
