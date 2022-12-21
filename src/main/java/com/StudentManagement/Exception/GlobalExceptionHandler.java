package com.StudentManagement.Exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<ErrorDetails> OtherExceptionHandler(Exception exp, WebRequest req){
		ErrorDetails authEx = new ErrorDetails();
		authEx.setTimestamp(LocalDateTime.now());
		authEx.setMessage(exp.getMessage());
		authEx.setDescription(req.getDescription(false));
		
		return new ResponseEntity<ErrorDetails>(authEx,HttpStatus.BAD_REQUEST);
	}
	
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<ErrorDetails> MethodArgumentNotValidExceptionHandler(MethodArgumentNotValidException exp) {
		
		ErrorDetails authEx = new ErrorDetails();
		authEx.setTimestamp(LocalDateTime.now());
		authEx.setMessage("Validation Error");
		authEx.setDescription(exp.getBindingResult().getFieldError().getDefaultMessage());
		
		return new ResponseEntity<ErrorDetails>(authEx,HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(AccessDeniedException.class)
	public ResponseEntity<ErrorDetails> AccessDeniedExceptionHandler(AccessDeniedException exp, WebRequest req){
		ErrorDetails authEx = new ErrorDetails();
		authEx.setTimestamp(LocalDateTime.now());
		authEx.setMessage(exp.getMessage());
		authEx.setDescription(req.getDescription(false));
		
		return new ResponseEntity<ErrorDetails>(authEx,HttpStatus.FORBIDDEN);
	}
	@ExceptionHandler(StudentException.class)
	public ResponseEntity<ErrorDetails> StudentExceptionHandler(StudentException exp, WebRequest req){
		ErrorDetails authEx = new ErrorDetails();
		authEx.setTimestamp(LocalDateTime.now());
		authEx.setMessage(exp.getMessage());
		authEx.setDescription(req.getDescription(false));
		
		return new ResponseEntity<ErrorDetails>(authEx,HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(InvalidCredentialException.class)
	public ResponseEntity<ErrorDetails> InvalidCredentialExceptionHandler(InvalidCredentialException exp, WebRequest req){
		ErrorDetails authEx = new ErrorDetails();
		authEx.setTimestamp(LocalDateTime.now());
		authEx.setMessage(exp.getMessage());
		authEx.setDescription(req.getDescription(false));
		
		return new ResponseEntity<ErrorDetails>(authEx,HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(UserAlreadyExistsException.class)
	public ResponseEntity<ErrorDetails> UserAlreadyExistsExceptionHandler(UserAlreadyExistsException exp, WebRequest req){
		ErrorDetails authEx = new ErrorDetails();
		authEx.setTimestamp(LocalDateTime.now());
		authEx.setMessage(exp.getMessage());
		authEx.setDescription(req.getDescription(false));
		
		return new ResponseEntity<ErrorDetails>(authEx,HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(CourseException.class)
	public ResponseEntity<ErrorDetails> CourseExceptionHandler(CourseException exp, WebRequest req){
		ErrorDetails authEx = new ErrorDetails();
		authEx.setTimestamp(LocalDateTime.now());
		authEx.setMessage(exp.getMessage());
		authEx.setDescription(req.getDescription(false));
		
		return new ResponseEntity<ErrorDetails>(authEx,HttpStatus.NOT_FOUND);
	}
	@ExceptionHandler(EnumException.class)
	public ResponseEntity<ErrorDetails> EnumExceptionHandler(EnumException exp, WebRequest req){
		ErrorDetails authEx = new ErrorDetails();
		authEx.setTimestamp(LocalDateTime.now());
		authEx.setMessage(exp.getMessage());
		authEx.setDescription(req.getDescription(false));
		
		return new ResponseEntity<ErrorDetails>(authEx,HttpStatus.NOT_FOUND);
	}
	

}
