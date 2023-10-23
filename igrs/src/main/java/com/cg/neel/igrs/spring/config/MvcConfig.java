package com.cg.neel.igrs.spring.config;

import java.util.Locale;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.i18n.CookieLocaleResolver;

import com.cg.neel.igrs.validator.MobileValidator;


/**
 * @author Preeti
 *
 */
@Configuration
@ComponentScan(basePackages = { "com.cg.neel.igrs" })
public class MvcConfig{

	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}
	
	public MvcConfig() {
		super();
	}

	 //Set Default language English
	 @Bean
	 @Primary
	 public LocaleResolver myLocaleResolver() {
		 final CookieLocaleResolver cookieLocaleResolver=new CookieLocaleResolver();
		 cookieLocaleResolver.setDefaultLocale(Locale.ENGLISH);
		 return  cookieLocaleResolver;
	 }

	 //Add your Intercepter
	 //Helps with configuring a list of mapped intercepters
	 
	 //For Login
	 public MobileValidator loginIdValidator() {
		 return new MobileValidator();
	 }
	 
}
