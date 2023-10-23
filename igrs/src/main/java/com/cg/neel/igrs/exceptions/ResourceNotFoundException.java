/**
 * 
 */
package com.cg.neel.igrs.exceptions;

/**
 * @author Preeti
 * @Des Handle error resource not found in database
 *
 */
public class ResourceNotFoundException extends RuntimeException{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ResourceNotFoundException () {
		super("Resource not found Exception on server");
	}
	
	public ResourceNotFoundException(String message) {
		super(message);
	}
	
	

}
