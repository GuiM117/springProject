package com.example.springProject.resources.exceptions;

import java.time.Instant;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.example.springProject.Services.exceptions.DataBaseException;
import com.example.springProject.Services.exceptions.ResourceNotFoundException;

@ControllerAdvice  //Intercepts exceptions
public class ResourceExceptionHandler {
	
	@ExceptionHandler(ResourceNotFoundException.class) // intercepts this type to get Http 404
	public ResponseEntity<StandardError> resourceNotFound(ResourceNotFoundException e, HttpServletRequest request){
		String error = "Resource not found";
		HttpStatus status = HttpStatus.NOT_FOUND;
		StandardError err = new StandardError(Instant.now(), status.value(), error, e.getMessage(), request.getRequestURI());
		return ResponseEntity.status(status).body(err);
	}
	
	@ExceptionHandler(DataBaseException.class) // intercepts this type to get Http 404
	public ResponseEntity<StandardError> database(DataBaseException e, HttpServletRequest request){
		String error = "DataBase Error";
		HttpStatus status = HttpStatus.BAD_REQUEST;
		StandardError err = new StandardError(Instant.now(), status.value(), error, e.getMessage(), request.getRequestURI());
		return ResponseEntity.status(status).body(err);
	}
}
