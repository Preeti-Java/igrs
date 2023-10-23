/**
 * 
 */
package com.cg.neel.igrs.users.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cg.neel.igrs.users.LoginRequest;
import com.cg.neel.igrs.utils.GenericResponse;

/**
 * @author Preeti
 *
 */
//@CrossOrigin("*")
@RequestMapping("/default")
public interface UserLoginCmd {

	
	/**
	 * @param request
	 * @param model
	 * @param messageKey
	 * @param error
	 * @return Login Page
	 */
	 @PostMapping("/user") 
	 GenericResponse login(HttpServletRequest request, HttpServletResponse response,@RequestBody LoginRequest loginRequest) throws Exception;
	
	
	 
	
}
