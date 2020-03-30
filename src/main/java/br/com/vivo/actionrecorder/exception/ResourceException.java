package br.com.vivo.actionrecorder.exception;

import org.springframework.http.HttpStatus;

public class ResourceException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private HttpStatus status;
	private String message;
	
	public ResourceException(HttpStatus status, String message) {
		super(message);
		this.status =  status;
		this.message = message;
	}

	public HttpStatus getStatus() {
		return status;
	}

	public String getMessage() {
		return message;
	}
	
	
}
