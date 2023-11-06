/**
 * 
 */
package com.cg.neel.igrs.users.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.context.ApplicationEventPublisher;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.neel.igrs.listener.OnRegistrationCompleteEvent;
import com.cg.neel.igrs.users.UserRegAccessBean;
import com.cg.neel.igrs.users.UserRegDto;
import com.cg.neel.igrs.users.service.RegistrationService;
import com.cg.neel.igrs.utils.GenericResponse;
import com.cg.neel.igrs.utils.Utils;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * @author Preeti
 *
 */

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
@Slf4j
public class UserRegistrationCmdImpl implements UserRegistrationCmd{
	
	private static final String SUCCESS = "Success";
	private static final String SOMETHING_ISSUE = "Something Issue";
	
	private final RegistrationService registrationService;
	
	
	private final ApplicationEventPublisher eventPublisher;

	@Override
	public GenericResponse registration( final UserRegDto userRegDto, HttpServletRequest request) {
		
		//Verified your Credential -> mobile No exit, mobile verified, email exit
		//final boolean verifiedCred = registrationService.verifiedCreditional(userRegDto);
		final boolean verifiedCred = userRegDto.isMobileVerified();
		if(!verifiedCred)
		{
			return  new GenericResponse(SOMETHING_ISSUE);
		}
		 final UserRegAccessBean userReg = registrationService.registerNewUserAccount(userRegDto);
		eventPublisher.publishEvent(new OnRegistrationCompleteEvent(Utils.getAppUrl(request), request.getLocale(), userReg));
		//Mail Services -> Sending a mail
		return new GenericResponse(SUCCESS);
	}

}
