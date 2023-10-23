/**
 * 
 */
package com.cg.neel.igrs.users.controller;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cg.neel.igrs.users.dto.PasswordDto;
import com.cg.neel.igrs.utils.GenericResponse;

/**
 * @author Preeti
 * @Des this rest controller used for update credentials such as password, logoin etc //Used for future 
 *
 */
@RequestMapping
public interface UpdateCredentialsCmd {

	//Change User Password
	@PostMapping("/uPass")
	GenericResponse passwordUpdate(HttpServletRequest request, @RequestBody @Valid PasswordDto password);
	
}
