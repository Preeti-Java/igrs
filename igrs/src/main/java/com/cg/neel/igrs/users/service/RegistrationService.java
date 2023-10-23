/**
 * 
 */
package com.cg.neel.igrs.users.service;

import javax.validation.Valid;

import com.cg.neel.igrs.users.UserRegAccessBean;
import com.cg.neel.igrs.users.UserRegDto;

/**
 * @author Preeti
 *
 */
public interface RegistrationService {

	/**
	 * @param userRegDto
	 * @return UserRegAccessBean
	 */
	UserRegAccessBean registerNewUserAccount(final UserRegDto userRegDto);

	/**
	 * @param userRegDto
	 * @return true/false
	 */
	boolean verifiedCreditional(@Valid UserRegDto userRegDto);
		boolean isMobileExists(final String recipientPhoneNumber);

		/**
		 * @param recipientPhoneNumber
		 * @return true/false
		 */
		boolean isMobileVerified(String recipientPhoneNumber);

		/**
		 * @param logonId
		 * @return UserRegAccessBean
		 */
		UserRegAccessBean findByLogonid(String logonId);

		/**
		 * @param name
		 * @return UserRegAccessBean
		 */
		UserRegAccessBean findByMobileNo(String name);

}
