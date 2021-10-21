package br.com.newsletter.handler;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

@RestController
@RestControllerAdvice
public class CustomizedResponseEntityExceptionHandler{

	@ExceptionHandler(Exception.class)
	public ResponseEntity<Object> allHandlerException(Exception ex, WebRequest request) {
		return new ResponseEntity<Object>(
				new ExceptionResponse(ex.getMessage(), request.getDescription(false), LocalDateTime.now()),
				HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<Object> allHandlerMethodArgumentNotValidException(MethodArgumentNotValidException ex,
			WebRequest request) {
		return new ResponseEntity<Object>(new ErrorResponse(LocalDateTime.now(), ex.getBindingResult().getAllErrors()),
				HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(AssinanteNotFoundException.class)
	public ResponseEntity<Object> handlerAssinanteNotFoundException(AssinanteNotFoundException ex, WebRequest request) {
		return new ResponseEntity<Object>(
				new ExceptionResponse(ex.getMessage(), request.getDescription(false), LocalDateTime.now()),
				HttpStatus.NOT_FOUND);
	}
}
