/**
 * 
 */
package com.cg.neel.igrs.listener;

import java.util.UUID;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import com.cg.neel.igrs.external.service.Mail_Service;
import com.cg.neel.igrs.users.UserRegAccessBean;
import com.cg.neel.igrs.users.UserRegDto;
import com.cg.neel.igrs.utils.GenericResponse;

import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;



/**
 * @author Preeti
 * @Description Use this listener for sending a confirmation mail 
 *
 */
@Component
@RequiredArgsConstructor
@Slf4j
public class RegistrationListener implements ApplicationListener<OnRegistrationCompleteEvent>{
	
	
	public final  ModelMapper modelMapper;
	
	
	final Mail_Service MAIL_SERVICE;

	@Override
	public void onApplicationEvent(final OnRegistrationCompleteEvent event) {
		this.confirmRegistration(event);
	}

	/**
	 * @param event
	 */
	
	@RateLimiter(name="confirmRegistrationLimiter", fallbackMethod="confirmRegistrationFallback")
	private void confirmRegistration(final OnRegistrationCompleteEvent event) {
		final UserRegAccessBean userRegAccessBean = event.getUserRegAccessBean();
		final String token = UUID.randomUUID().toString();
		
		//@Mail Services -> Sending a mail
		
		//Convert Entity to DTO
		UserRegDto userRegDto = modelMapper.map(userRegAccessBean, UserRegDto.class);

		GenericResponse response = MAIL_SERVICE.constructEmailMessage(userRegDto,token);
		
		System.out.println(response);
		//GenericResponse response = constructEmailMessage(event, userRegDto, token);
	}
	
	
	
	//creating fallback method for confirm Registration 
	private void confirmRegistrationFallback(final OnRegistrationCompleteEvent event,Exception ex) {
		log.info("Fallback is executed because Mail Service is down :" + ex.getStackTrace().toString());
	}

}
