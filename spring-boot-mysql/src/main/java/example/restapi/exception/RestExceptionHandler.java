package example.restapi.exception;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.NoHandlerFoundException;

import example.restapi.dto.APIError;
//@EnableWebMvc
@RestControllerAdvice

public class RestExceptionHandler {

	private static final Logger log = LoggerFactory.getLogger(RestExceptionHandler.class);
	
	
   @ExceptionHandler(Exception.class)
   protected ResponseEntity<Object> handleJPAError(
		   Exception ex) {
	   log.info("--------------handleJPAError----------------" + ex.getMessage());
	   APIError apiError = new APIError(HttpStatus.INTERNAL_SERVER_ERROR.value(), ex.getMessage());
       apiError.setMessage(ex.getMessage());
       return buildResponseEntity(apiError, HttpStatus.INTERNAL_SERVER_ERROR);
   }
   
   private ResponseEntity<Object> buildResponseEntity(APIError apiError, HttpStatus status) {
       return new ResponseEntity<>("Error Occured", status );
   }
   
   @ExceptionHandler(NoHandlerFoundException.class)
   protected ResponseEntity<Object> NoHandlerFoundException(
		   Exception ex) {
	   log.info("--------------addDish----------------");
	   APIError apiError = new APIError(HttpStatus.CONFLICT.value(), "Resource not found");
       apiError.setMessage(ex.getMessage());
       return buildResponseEntity(apiError, HttpStatus.CONFLICT);
   }
   
   
   
   
}
