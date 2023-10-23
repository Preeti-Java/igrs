/**
 * 
 */
package com.cg.neel.igrs.users.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.cg.neel.igrs.utils.GenericResponse;

/**
 * @author Preeti
 * @Des Reset the password
 *
 */
@RequestMapping("/default")
public interface ResetPasswordAdministratorCmd {
	
	//check mobilee no exist or not... if true -> send otp
	@PostMapping("/reset")
	GenericResponse resetPassword(HttpServletRequest httpServletRequest ,@RequestParam("param") String param);
	
	//After verification of otp , replace new password
	@PostMapping("/savePassword")
	GenericResponse savePassword(HttpServletRequest httpServletRequest ,@RequestParam("param") String param, @RequestParam("pass") String pass);
	
	
	
}
