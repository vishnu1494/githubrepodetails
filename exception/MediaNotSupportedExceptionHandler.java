/**
 * 
 */
package com.githubrepo.githubrepoinformation.exception;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpMediaTypeNotAcceptableException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import com.githubrepo.githubrepoinformation.pojo.ServiceResponse;

/**
 * @author Vishnu
 *
 */

@ControllerAdvice
public class MediaNotSupportedExceptionHandler {

	@ExceptionHandler(value = { HttpMediaTypeNotAcceptableException.class })
	protected ResponseEntity<Object> handleMediaNotSupported(HttpMediaTypeNotAcceptableException ex,
			WebRequest request) {

		ServiceResponse obj = new ServiceResponse();
		obj.setMessage(ex.getMessage());
		obj.setStatus(HttpStatus.NOT_ACCEPTABLE.toString());
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);

		return new ResponseEntity<>(obj, headers, HttpStatus.NOT_ACCEPTABLE);
	}

}
