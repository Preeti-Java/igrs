/**
 * 
 */
package com.cg.neel.igrs.users.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.neel.igrs.users.UserRegAccessBean;
import com.cg.neel.igrs.users.service.RegistrationService;
import com.cg.neel.igrs.users.service.UserService;
import com.cg.neel.igrs.utils.GenericResponse;

/**
 * @author Preeti
 * @Des Reset functionality
 *
 */
@RestController
@RequestMapping("/pass")
@CrossOrigin("*")
public class ResetPasswordAdministratorCmdImpl implements ResetPasswordAdministratorCmd{
	
	
	//MESSAGE
	private static final String SOMETHING_ISSUE_MESSAGE = "message.somethingIssue";
	private static final String INCORRECT_MOBILE_MESSAGE = "message.incorrectMobile";
	private static final String USER_NOT_FOUND_MESSAGE = "message.userNotFound";
	private static final String RESET_PASSWORD_SUC_MESSAGE =  "message.resetPasswordSuc";
	
	@Autowired
	private MessageSource messageSource;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private RegistrationService registrationService;

	@Override
	public GenericResponse resetPassword(HttpServletRequest httpServletRequest,final String param) {
		//first check param is email or mobile-number
		String response = null;
		 if (userService.isMobileNumber(param.substring(2))) {
	          response = userService.validateMobile(param);
	        } 
			if(response == null)
				return new GenericResponse(messageSource.getMessage(SOMETHING_ISSUE_MESSAGE, null, httpServletRequest.getLocale()));
		    return new GenericResponse(response);
	}

	@Override
	public GenericResponse savePassword(HttpServletRequest httpServletRequest ,String param, String pass) {
		//mobile validate
		if(!userService.isMobileNumber(param.substring(2)))
			return new GenericResponse(messageSource.getMessage(INCORRECT_MOBILE_MESSAGE, null, httpServletRequest.getLocale()));
		// check user exit or not
		UserRegAccessBean userRegAccessBean = registrationService.findByMobileNo(param.substring(2));
		if(userRegAccessBean == null)
			return new GenericResponse(messageSource.getMessage(USER_NOT_FOUND_MESSAGE, null, httpServletRequest.getLocale()));
		//save password
		
		userRegAccessBean.setLogonPassword(passwordEncoder.encode(pass));
		userService.savePassword(userRegAccessBean);
		return new GenericResponse(messageSource.getMessage(RESET_PASSWORD_SUC_MESSAGE, null, httpServletRequest.getLocale()));
	}

}
