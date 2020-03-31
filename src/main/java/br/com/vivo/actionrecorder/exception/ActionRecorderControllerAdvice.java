package br.com.vivo.actionrecorder.exception;

import java.sql.SQLIntegrityConstraintViolationException;
import java.time.LocalDateTime;

import org.hibernate.exception.ConstraintViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import br.com.vivo.actionrecorder.dto.response.CustomErrorDTOResponse;

@RestControllerAdvice
public class ActionRecorderControllerAdvice {
  
  @ExceptionHandler(ResourceException.class)
  public ResponseEntity<CustomErrorDTOResponse> handleNotFoundException(ResourceException ex) {
	  
   CustomErrorDTOResponse errorResponse = new CustomErrorDTOResponse();
   errorResponse.setStatus(ex.getStatus().value());
   errorResponse.setMessage(ex.getMessage());
   errorResponse.setTimestamp(LocalDateTime.now());
   ex.printStackTrace();
   return ResponseEntity.status(ex.getStatus()).body(errorResponse);
   
  }
  
  @ExceptionHandler(SQLIntegrityConstraintViolationException.class)
  public ResponseEntity<CustomErrorDTOResponse> handleUniqueConstraintException(SQLIntegrityConstraintViolationException ex) {
	  
   CustomErrorDTOResponse errorResponse = new CustomErrorDTOResponse();
   errorResponse.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.ordinal());
   errorResponse.setMessage(ex.getMessage());
   errorResponse.setTimestamp(LocalDateTime.now());
   
   return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorResponse);
   
  }
  
  
  @ExceptionHandler(ConstraintViolationException.class)
  public ResponseEntity<CustomErrorDTOResponse> handleUniqueConstraintException(ConstraintViolationException ex) {
  
   CustomErrorDTOResponse errorResponse = new CustomErrorDTOResponse();
   errorResponse.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
   errorResponse.setMessage(ex.getSQLException().getMessage());
   errorResponse.setTimestamp(LocalDateTime.now());
   
   return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorResponse);
   
  }
  
  
  @ExceptionHandler(Exception.class)
  public ResponseEntity<CustomErrorDTOResponse> handleUniqueConstraintException(Exception ex) {
  
   CustomErrorDTOResponse errorResponse = new CustomErrorDTOResponse();
   errorResponse.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
   errorResponse.setMessage(ex.getMessage());
   errorResponse.setTimestamp(LocalDateTime.now());
   ex.printStackTrace();
   return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorResponse);
   
  }
  
  
  
}
