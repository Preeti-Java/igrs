/**
 * 
 */
package com.cg.neel.igrs.users.controller;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cg.neel.igrs.users.UserRegDto;
import com.cg.neel.igrs.utils.GenericResponse;

/**
 * @author Preeti 
 * @Description User Registration 
 *
 */

@RequestMapping("/default")
public interface UserRegistrationCmd {
	
	@GetMapping("/registration")
	GenericResponse registration(@Valid final UserRegDto userRegDto, final HttpServletRequest request);
	
}
