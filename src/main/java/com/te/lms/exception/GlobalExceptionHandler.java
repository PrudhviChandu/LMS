package com.te.lms.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.te.lms.response.Response;

@ControllerAdvice
public class GlobalExceptionHandler {
@ExceptionHandler(CustomException.class)
	public ResponseEntity<?> handleResponse(CustomException customException){
		Response response=new Response();
		response.setIsError(true);
		response.setMsg(customException.getMessage());
		return new ResponseEntity<>(response,HttpStatus.BAD_REQUEST);
	}
}
