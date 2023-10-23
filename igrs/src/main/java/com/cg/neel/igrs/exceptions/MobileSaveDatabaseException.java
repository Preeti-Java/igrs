/**
 * 
 */
package com.cg.neel.igrs.exceptions;

/**
 * @author Preeti
 * @Des Class handle exception when mobile number saved in database
 *
 */
public final class MobileSaveDatabaseException extends RuntimeException{
	
	   private static final long serialVersionUID = 5861310537366287163L;

	    public MobileSaveDatabaseException() {
	        super();
	    }

	    public MobileSaveDatabaseException(final String message, final Throwable cause) {
	        super(message, cause);
	    }

	    public MobileSaveDatabaseException(final String message) {
	        super(message);
	    }

	    public MobileSaveDatabaseException(final Throwable cause) {
	        super(cause);
	    }

}
