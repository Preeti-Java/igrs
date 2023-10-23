/**
 * 
 */
package com.cg.neel.igrs.exceptions;

/**
 * @author Preeti
 * @Des Class handle exception when mobile number saved in database
 *
 */
public final class LogonIdAlreadyExistException extends RuntimeException{
	
	   private static final long serialVersionUID = 5861310537366287163L;

	    public LogonIdAlreadyExistException() {
	        super();
	    }

	    public LogonIdAlreadyExistException(final String message, final Throwable cause) {
	        super(message, cause);
	    }

	    public LogonIdAlreadyExistException(final String message) {
	        super(message);
	    }

	    public LogonIdAlreadyExistException(final Throwable cause) {
	        super(cause);
	    }

}
