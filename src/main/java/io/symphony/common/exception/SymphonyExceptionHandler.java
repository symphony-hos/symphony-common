package io.symphony.common.exception;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class SymphonyExceptionHandler {

    @ExceptionHandler(PointAccessDeniedException.class)
    public ResponseEntity<ErrorDetails> pointAccessDenied(PointAccessDeniedException exception, WebRequest request) {
        exception.printStackTrace();
        return new ResponseEntity<>(getDetails(exception, request), HttpStatus.FORBIDDEN);
    }

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<ErrorDetails> pointNotFound(EntityNotFoundException exception, WebRequest request) {
    	exception.printStackTrace();
        return new ResponseEntity<>(getDetails(exception, request), HttpStatus.NOT_FOUND);
    }
    
    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<ErrorDetails> messageNotReadable(HttpMessageNotReadableException exception, WebRequest request) {
    	exception.printStackTrace();
        return new ResponseEntity<>(getDetails(exception, request), HttpStatus.BAD_REQUEST);
    } 
    
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorDetails> pointNotFound(Exception exception, WebRequest request) {
    	exception.printStackTrace();
        return new ResponseEntity<>(getDetails(exception, request), HttpStatus.INTERNAL_SERVER_ERROR);
    }
    
    private ErrorDetails getDetails(Throwable th, WebRequest req) {
    	return ErrorDetails.builder()
			.timestamp(LocalDateTime.now())
			.message(th.getMessage())
			.details(req.getDescription(false))
			.trace(getTrace(th))
			.build();
    }
       
    private String getTrace(Throwable th) {
    	StringWriter sw = new StringWriter();
    	PrintWriter pw = new PrintWriter(sw);
    	th.printStackTrace(pw);
    	return sw.toString();
    }

}
