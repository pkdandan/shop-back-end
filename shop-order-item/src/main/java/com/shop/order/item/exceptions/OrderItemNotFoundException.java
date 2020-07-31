package com.shop.order.item.exceptions;

public class OrderItemNotFoundException extends Exception{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public OrderItemNotFoundException(){
		
	}
	
	public OrderItemNotFoundException(String errorMessage) {
		super(errorMessage);
	}

}
