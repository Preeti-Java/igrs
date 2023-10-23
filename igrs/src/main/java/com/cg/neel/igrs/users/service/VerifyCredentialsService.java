/**
 * 
 */
package com.cg.neel.igrs.users.service;

import java.util.concurrent.ExecutionException;

import javax.validation.Valid;

import com.cg.neel.igrs.users.UserRegAccessBean;

/**
 * @author Preeti
 *
 */
public interface VerifyCredentialsService {

	/**
	 * @param mobileNumber
	 * @return status Send or not
	 */
	String sendingOtp(final String mobileNumber) throws ExecutionException, InterruptedException;

	/**
	 * @param mobileNumber
	 * @param otp 
	 * @return
	 */
	String verifiedOtp(@Valid String mobileNumber, String otp);
	
	String otpSendMethod(String mobileNumber);

	/**
	 * @param password 
	 * @param user
	 * @return
	 */
	boolean checkIfValidOldPassword(String password, UserRegAccessBean user);


}
