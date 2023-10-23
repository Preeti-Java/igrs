/**
 * 
 */
package com.cg.neel.igrs.listener;

import java.util.Locale;

import org.springframework.context.ApplicationEvent;

import com.cg.neel.igrs.users.UserRegAccessBean;


/**
 * @author Preeti
 *
 */
@SuppressWarnings("serial")
public class OnRegistrationCompleteEvent extends ApplicationEvent{

	private final String appUrl;
	private final Locale locale;
	private final UserRegAccessBean userRegAccessBean;
	
	
	/**
	 * @param appUrl
	 * @param locale
	 * @param userRegAccessBean
	 */
	public OnRegistrationCompleteEvent(final String appUrl, final Locale locale,
			final UserRegAccessBean userRegAccessBean) {
		super(userRegAccessBean);
		this.appUrl = appUrl;
		this.locale = locale;
		this.userRegAccessBean = userRegAccessBean;
	}

	/**
	 * @return the appUrl
	 */
	public String getAppUrl() {
		return appUrl;
	}

	/**
	 * @return the locale
	 */
	public Locale getLocale() {
		return locale;
	}

	/**
	 * @return the userRegAccessBean
	 */
	public UserRegAccessBean getUserRegAccessBean() {
		return userRegAccessBean;
	}
	
	

	
}
