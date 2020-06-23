package com.bootng.handler.exception;

import java.util.Collections;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import com.bootng.beans.AppException;
import com.bootng.beans.NotFoundException;

/**
 * Global Exception Handler Class to process exceptions in the whole
 * application.
 *
 */

@ControllerAdvice
public class GlobalExceptionHandler {

	private static final Logger log = LoggerFactory.getLogger(GlobalExceptionHandler.class);

	/** Customize the response for NotFoundException. */
	@ExceptionHandler({ NotFoundException.class })
	protected ResponseEntity<Object> handleNotFoundException(Exception ex, WebRequest request) {

		log.info("global exception handler " + ex.getMessage());
		List<String> errors = Collections.singletonList(ex.getMessage());
		ResponseEntity<Object> ret = ResponseEntity.status(HttpStatus.NOT_FOUND).body(errors);
		return ret;
	}

	/** Customize the response for AppException. */
	@ExceptionHandler({ AppException.class })
	protected ResponseEntity<Object> handleException(Exception ex, WebRequest request) {

		log.info("global exception handler " + ex.getMessage());
		String errors = "We cannot serve the request now, please try later";
		ResponseEntity<Object> ret = ResponseEntity.status(HttpStatus.FORBIDDEN).body(errors);
		return ret;
	}

	/** Customize the response for HttpMediaTypeNotSupportedException. */
	@ExceptionHandler({ HttpMediaTypeNotSupportedException.class })
	protected ResponseEntity<Object> handleMediaException(Exception ex, WebRequest request) {

		log.info("global exception handler " + ex.getMessage());
		String errors = "We only understand JSON payload for simplicity";
		ResponseEntity<Object> ret = ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errors);
		return ret;
	}

	/** Customize the response for HttpRequestMethodNotSupportedException. */
	@ExceptionHandler({ HttpRequestMethodNotSupportedException.class })
	protected ResponseEntity<Object> handleMethodException(Exception ex, WebRequest request) {

		log.info("global exception handler " + ex.getMessage());
		String errors = "Check the URL, HTTP Verb, seems like we dont support it.";
		ResponseEntity<Object> ret = ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errors);
		return ret;
	}
}
