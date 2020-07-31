package com.shop.order.item.utils;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.client.HttpClientErrorException.BadRequest;
import org.springframework.web.servlet.NoHandlerFoundException;

import com.shop.order.item.vo.ErrorResponse;
import com.shop.order.item.exceptions.OrderItemNotFoundException;

@RestControllerAdvice
public class ApplicationExceptionHandler {

	@ExceptionHandler(BadRequest.class)
	public ResponseEntity<ErrorResponse>  handleBadRequestException(BadRequest e) {
		ErrorResponse error = new ErrorResponse();
		error.setErrorCode("400");
		error.setErrorMessage(e.getMessage());
		error.setRequestTime(LocalDateTime.now());
		error.setStatus((HttpStatus.BAD_REQUEST.value()));
		return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(NoHandlerFoundException.class)
	@ResponseStatus(value= HttpStatus.NOT_FOUND)
	public ResponseEntity<ErrorResponse>  handleNotFoundException(NoHandlerFoundException e) {
		ErrorResponse error = new ErrorResponse();
		error.setErrorCode("404");
		error.setErrorMessage(e.getMessage());
		error.setRequestTime(LocalDateTime.now());
		error.setStatus((HttpStatus.NOT_FOUND.value()));
		return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(OrderItemNotFoundException.class)
	public ResponseEntity<ErrorResponse>  handleOrderNotFoundException(OrderItemNotFoundException e) {
		ErrorResponse error = new ErrorResponse();
		error.setErrorCode("400");
		error.setErrorMessage(e.getMessage());
		error.setRequestTime(LocalDateTime.now());
		error.setStatus((HttpStatus.OK.value()));
		return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<ErrorResponse>  handleExceptions(Exception e) {
		ErrorResponse error = new ErrorResponse();
		error.setErrorCode("500");
		error.setErrorMessage(e.getMessage());
		error.setRequestTime(LocalDateTime.now());
		error.setStatus((HttpStatus.OK.value()));
		return new ResponseEntity<>(error, HttpStatus.OK);
	}
}
