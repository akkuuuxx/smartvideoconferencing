package com.akshat.smartconferencing.utility;

import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.akshat.smartconferencing.exception.ErrorInfo;
import com.akshat.smartconferencing.exception.SmartConferencingException;

import jakarta.validation.ConstraintViolationException;


@RestControllerAdvice
public class ExceptionControllerAdvice {
@Autowired
	Environment environment;

@ExceptionHandler(Exception.class)
	public ResponseEntity<ErrorInfo> generalExceptionHandler(Exception exception) {
		ErrorInfo error = new ErrorInfo();
		error.setMessage("Something went wrong, please check the log");
		error.setErrorCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
		return new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
	}
@ExceptionHandler(SmartConferencingException.class)
	public ResponseEntity<ErrorInfo> SmartConferencingExceptionHandler(SmartConferencingException exception) {
		ErrorInfo error = new ErrorInfo();
		error.setMessage(exception.getMessage());
		error.setErrorCode(HttpStatus.BAD_REQUEST.value());
		return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler({ MethodArgumentNotValidException.class, ConstraintViolationException.class })
	public ResponseEntity<ErrorInfo> exceptionHandler(Exception exception) {
		ErrorInfo errorInfo = new ErrorInfo();
		errorInfo.setErrorCode(HttpStatus.BAD_REQUEST.value());
		String errorMsg = "";
		if (exception instanceof MethodArgumentNotValidException) {
			MethodArgumentNotValidException exception1 = (MethodArgumentNotValidException) exception;
			errorMsg = exception1.getBindingResult().getAllErrors().stream().map(x -> x.getDefaultMessage())
					.collect(Collectors.joining(", "));
		} else {
			ConstraintViolationException exception1 = (ConstraintViolationException) exception;
			errorMsg = exception1.getConstraintViolations().stream().map(x -> x.getMessage())
					.collect(Collectors.joining(", "));
		}
		errorInfo.setMessage(errorMsg);
		return new ResponseEntity<>(errorInfo, HttpStatus.BAD_REQUEST);
	}

}
