/**
 * 
 */
package com.cg.neel.igrs.users.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cg.neel.igrs.users.service.UserService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * @author Preeti
 * @apiNote this controller is used for join user and query service.
 *
 */
@RestController
@RequestMapping("/query_user")
@RequiredArgsConstructor
@Slf4j
public class UserQueryServiceController {
	

	private final UserService userService;
	
	@PostMapping(value = "/userId", consumes = "application/json")
	public Long getUserIdByPrincipal(@RequestParam Object object) {
		return userService.getUserId(object);
	}
	

}
