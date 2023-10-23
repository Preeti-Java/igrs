/**
 * 
 */
package com.cg.neel.igrs.external.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.cg.neel.igrs.users.UserRegDto;
import com.cg.neel.igrs.utils.GenericResponse;

/**
 *@author Preeti
 *@Des this service called mail_service controller by feign client
 */

@FeignClient("MAIL-SERVICE")
@Service
public interface Mail_Service {

	@PostMapping(value = "/mail/constructEmail", consumes = "application/json")
	public GenericResponse constructEmailMessage(
			@RequestBody UserRegDto userRegDto,
			@RequestParam("token") String token);
}
 