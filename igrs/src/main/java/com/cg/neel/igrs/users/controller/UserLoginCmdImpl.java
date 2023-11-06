/**
 * 
 */
package com.cg.neel.igrs.users.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.User;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.neel.igrs.exceptions.UnauthorizedException;
import com.cg.neel.igrs.users.LoginRequest;
import com.cg.neel.igrs.users.UserRegAccessBean;
import com.cg.neel.igrs.users.configuration.IgrsUser;
import com.cg.neel.igrs.users.configuration.IgrsUserDetails;
import com.cg.neel.igrs.users.jwtconfiguration.JwtTokenGeneratorFilter;
import com.cg.neel.igrs.utils.GenericResponse;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * @author User
 *
 */
@RestController
@RequestMapping("/login")
@RequiredArgsConstructor
@Slf4j
public class UserLoginCmdImpl implements UserLoginCmd{
	
	private static final String AUTHORIZATION = "Authorization";
	private static final String ACCESS_CONTROL_EXPOSE_HEADERS = "Access-Control-Expose-Headers";
	private static final String SUCCESS = "Success";
	
	//EXCEPTION
	private static final String USER_ID_PASSWORD_NOT_MATCH_EXCEPTION = "User Id or Password  is not  matched ";
	private static final String USER_DISABLED_EXCEPTION = "USER_DISABLED";
	private static final String INVALID_CREDENTIALS_EXCEPTION = "INVALID_CREDENTIALS";
		

	  @Autowired
	  private IgrsUserDetails igrsUserDetails;
	  
	  
	  private final JwtTokenGeneratorFilter jwtTokenGeneratorFilter;
	  
	 
	  private final AuthenticationManager authenticationManager;
	  
		
	  		@Override 
	  	public GenericResponse login(HttpServletRequest request, HttpServletResponse response, final LoginRequest loginRequest) throws Exception
	  		{
		  
		  //Authenticate //Updated in future
	  	authenticate(loginRequest.getMobileNo(), loginRequest.getPassword());
		  
		  //Send language English and Hindi Locale locale = request.getLocale(); final
		  IgrsUser userDetails = igrsUserDetails.loadUserByUsername(loginRequest.getMobileNo());
		  
		  //check password is matched or not
		 boolean isMatchPasswordFlag =  igrsUserDetails.matchPassword(loginRequest.getPassword(), userDetails.getPassword());
		 if(isMatchPasswordFlag)
			 throw new UnauthorizedException(USER_ID_PASSWORD_NOT_MATCH_EXCEPTION);
		  
		  //Generate JWT Token //JWT Token contains -> header, payload, signature
		  //Update in future
		  
		  final String token = jwtTokenGeneratorFilter.generateToken(userDetails);
		  
		  //Send token 
		  //Redirect to igrs_user service for get Data for 'Registered User'
		  response.setHeader(ACCESS_CONTROL_EXPOSE_HEADERS, AUTHORIZATION);
		  response.setHeader(AUTHORIZATION, token);
		  return new GenericResponse(SUCCESS);
		  }

	

	private void authenticate(String mobileNo, String password) {
		try {
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(mobileNo, password));
		} catch (DisabledException e) {
			throw new DisabledException(USER_DISABLED_EXCEPTION, e);
		} catch (BadCredentialsException e) {
			throw new BadCredentialsException(INVALID_CREDENTIALS_EXCEPTION, e);
		}
			}


	


}
