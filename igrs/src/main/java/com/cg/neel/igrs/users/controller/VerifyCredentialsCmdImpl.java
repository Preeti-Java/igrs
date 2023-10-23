/**
 * 
 */
package com.cg.neel.igrs.users.controller;

import java.util.concurrent.ExecutionException;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.neel.igrs.users.service.VerifyCredentialsService;
import com.cg.neel.igrs.utils.GenericResponse;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * @author Preeti
 * @Des This class contains all verify method of account 
 *
 */
@RestController
@RequestMapping("/verify")
@RequiredArgsConstructor
@Slf4j
public class VerifyCredentialsCmdImpl implements VerifyCredentialsCmd{
	
	private static final String SOMETHING_ISSUE = "Something Issue";
	
	private final VerifyCredentialsService verifyCredentialsService;

	@Override
	public GenericResponse mobileVerificationBySendingOTP(HttpServletRequest request,final String mobileNumber) throws ExecutionException, InterruptedException {
		final String response = verifyCredentialsService.sendingOtp(mobileNumber); //false for not update password
		
		if(response == null)
			return new GenericResponse(SOMETHING_ISSUE);
		return new GenericResponse(response);
	}

	@Override
	public GenericResponse mobileVerificationByOTP(HttpServletRequest request, @Valid final String mobileNumber,final String otp) {
		final String response = verifyCredentialsService.verifiedOtp(mobileNumber,otp);
		if(response == null)
			return new GenericResponse(SOMETHING_ISSUE);
	    return new GenericResponse(response);
	}

}
