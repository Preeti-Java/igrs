/**
 * 
 */
package com.cg.neel.igrs.exception;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.cg.neel.igrs.exceptions.MobileSaveDatabaseException;
import com.cg.neel.igrs.exceptions.SearchingCredentialException;
import com.cg.neel.igrs.utils.GenericResponse;

import lombok.RequiredArgsConstructor;

/**
 * @author Preeti
 * @Des Handle all the User related Exception
 *
 */
@RestControllerAdvice
@RequiredArgsConstructor
public class UserExceptionHandler extends ResponseEntityExceptionHandler{
	
	
	private final MessageSource messageSource;
	
	@ExceptionHandler({ UsernameNotFoundException.class })
	@ResponseStatus(value = HttpStatus.NOT_FOUND)
	public ResponseEntity<Object> handleUsernameNotFoundException(final RuntimeException ex, final WebRequest request){
		//logger.error("409 Status Code",ex);
		final GenericResponse bodyResponse = new GenericResponse(messageSource.getMessage("", null, request.getLocale()));
		return handleExceptionInternal(ex, bodyResponse, new HttpHeaders(), HttpStatus.NOT_FOUND, request);
		
	}
	
	@ExceptionHandler({ MobileSaveDatabaseException.class })
	@ResponseStatus(value = HttpStatus.OK)
	public ResponseEntity<Object> handleMobileSaveDatabase(final RuntimeException ex, final WebRequest request){
		//logger.error("409 Status Code",ex);
		final GenericResponse bodyResponse = new GenericResponse(ex.getMessage());
		return handleExceptionInternal(ex, bodyResponse, new HttpHeaders(), HttpStatus.OK, request);
		
	}
	
	
	@ExceptionHandler({ SearchingCredentialException.class })
	@ResponseStatus(value = HttpStatus.OK)
	public ResponseEntity<Object> handleSearchingCredentialException(final SearchingCredentialException ex, final WebRequest request) {
		//logger.error("429 Too Many Request Error",ex);
		final GenericResponse bodyResponse = new GenericResponse(messageSource.getMessage("message.searchingCredentialsException", null, request.getLocale()));
		return handleExceptionInternal(ex, bodyResponse, new HttpHeaders(), HttpStatus.OK, request);
	}
	
	
}
