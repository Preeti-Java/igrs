/**
 * 
 */
package com.cg.neel.igrs.users.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.context.MessageSource;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.neel.igrs.users.UserRegAccessBean;
import com.cg.neel.igrs.users.dto.PasswordDto;
import com.cg.neel.igrs.users.service.RegistrationService;
import com.cg.neel.igrs.users.service.VerifyCredentialsService;
import com.cg.neel.igrs.utils.GenericResponse;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * @author Preeti
 *
 */
@RestController
@RequestMapping("/updateCred")
@RequiredArgsConstructor
@Slf4j
public class UpdateCredentialsCmdImpl implements UpdateCredentialsCmd{
	
	//MESSAGE
	private static final String OLD_PASSWORD_INCORRECT_MESSAGE = "message.oldPasswordIncorrect";
	
	private final MessageSource messageSource;

	
	private final  RegistrationService registrationService;
	
	
	private final VerifyCredentialsService verifyCredentialsService;
	
	@Override
	public GenericResponse passwordUpdate(HttpServletRequest request, PasswordDto password) {
		//Check old password is correct or not
		final UserRegAccessBean user = registrationService.findByMobileNo(SecurityContextHolder.getContext().getAuthentication().getName());
		if(!verifyCredentialsService.checkIfValidOldPassword(password.getOldPassword(),user))
			return new GenericResponse(messageSource.getMessage(OLD_PASSWORD_INCORRECT_MESSAGE, null, request.getLocale()));
		
		//check new password match confirm password
		/* if(!verifyCredentialsService.checkIfPass) */
			
		return null;
	}



}
