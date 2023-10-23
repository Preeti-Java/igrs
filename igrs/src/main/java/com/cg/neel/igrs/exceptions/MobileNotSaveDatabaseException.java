/**
 * 
 */
package com.cg.neel.igrs.exceptions;

/**
 * @author Preeti
 * @Des Class handle exception when mobile number saved in database
 *
 */
public final class MobileNotSaveDatabaseException extends RuntimeException{
	
	   private static final long serialVersionUID = 5861310537366287163L;

	    public MobileNotSaveDatabaseException() {
	        super();
	    }

	    public MobileNotSaveDatabaseException(final String message, final Throwable cause) {
	        super(message, cause);
	    }

	    public MobileNotSaveDatabaseException(final String message) {
	        super(message);
	    }

	    public MobileNotSaveDatabaseException(final Throwable cause) {
	        super(cause);
	    }

}
