package com.webservice.apicontratos.exceptions;

import java.time.Instant;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import jakarta.servlet.http.HttpServletRequest;

@ControllerAdvice
public class ResourceExceptionHandler {
	@ExceptionHandler(NotFoundException.class)
	public ResponseEntity<StandardError> notFoundException(NotFoundException e, HttpServletRequest request) {
		String error = "Not Found";
		HttpStatus status = HttpStatus.NOT_FOUND;
		StandardError err = new StandardError(Instant.now(), status.value(), error, e.getMessage(), request.getRequestURI());
		return ResponseEntity.status(status).body(err);
	}
	
	@ExceptionHandler(BadRequestException.class)
	public ResponseEntity<StandardError> badRequestException(BadRequestException e, HttpServletRequest request) {
		String error = "Bad Request";
		HttpStatus status = HttpStatus.BAD_REQUEST;
		StandardError err = new StandardError(Instant.now(), status.value(), error, e.getMessage(), request.getRequestURI());
		return ResponseEntity.status(status).body(err);
	}
	
	@ExceptionHandler(UnauthorizedException.class)
	public ResponseEntity<StandardError> unauthorizedException(UnauthorizedException e, HttpServletRequest request) {
	    String error = "Unauthorized";
	    HttpStatus status = HttpStatus.UNAUTHORIZED;
	    StandardError err = new StandardError(Instant.now(), status.value(), error, e.getMessage(), request.getRequestURI());
	    return ResponseEntity.status(status).body(err);
	}
	
	@ExceptionHandler(InternalServerErrorException.class)
	public ResponseEntity<StandardError> tokenCreationException(InternalServerErrorException e, HttpServletRequest request) {
	    String error = "Internal Server Error";
	    HttpStatus status = HttpStatus.INTERNAL_SERVER_ERROR;
	    StandardError err = new StandardError(Instant.now(), status.value(), error, e.getMessage(), request.getRequestURI());
	    return ResponseEntity.status(status).body(err);
	}
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<StandardError> validationException(MethodArgumentNotValidException e, HttpServletRequest request) {
		String error = "Bad Request";
		HttpStatus status = HttpStatus.BAD_REQUEST;
		Map<String, Object> fieldErrors = new HashMap<String, Object>();
		
		for (FieldError fieldError: e.getBindingResult().getFieldErrors()) {
			fieldErrors.put(fieldError.getField(), fieldError.getDefaultMessage());
		}

		ValidationError err = new ValidationError(Instant.now(), status.value(), error, "Invalid fields", request.getRequestURI(), fieldErrors);
		return ResponseEntity.status(status).body(err);
	}
	
	@ExceptionHandler(HttpMessageNotReadableException.class)
	public ResponseEntity<StandardError> handleHttpMessageNotReadable(HttpMessageNotReadableException e, HttpServletRequest request) {
	    HttpStatus status = HttpStatus.BAD_REQUEST;
	    String error = "Malformed JSON request";
	    StandardError err = new StandardError(Instant.now(), status.value(), error, "Request body is missing or invalid JSON", request.getRequestURI());
	    return ResponseEntity.status(status).body(err);
	}
}
