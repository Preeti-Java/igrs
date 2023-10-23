/**
 * 
 */
package com.cg.neel.igrs.users.controller;

import java.util.concurrent.ExecutionException;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cg.neel.igrs.utils.GenericResponse;

/**
 * @author Preeti
 * @Des This interface contains all verify method of account 
 */

@RequestMapping("/default")
public interface VerifyCredentialsCmd {
	
	//Only verify mobile No
	@GetMapping("/mobileVerification")
	public GenericResponse mobileVerificationBySendingOTP(HttpServletRequest request, @Valid final String mobileNumber) throws ExecutionException, InterruptedException;
	
	//Only verify mobile No
	@PostMapping("/mobileVerification")
	public GenericResponse mobileVerificationByOTP(HttpServletRequest request, @Valid final String mobileNumber,final String otp);
	

}
