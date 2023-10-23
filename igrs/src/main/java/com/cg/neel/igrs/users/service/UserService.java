/**
 * 
 */
package com.cg.neel.igrs.users.service;

import com.cg.neel.igrs.users.UserRegAccessBean;

/**
 * @author Preeti
 *
 */
public interface UserService {

	/**
	 * @param param
	 * @return true/false
	 */
	boolean isMobileNumber(String param);

	/**
	 * @param param
	 * @return true/false
	 */
	boolean isEmail(String param);

	/**
	 * @param param
	 * @return 
	 */
	String validateMobile(String param);

	/**
	 * @param userRegAccessBean
	 */
	void savePassword(UserRegAccessBean userRegAccessBean);

	/**
	 * @param object
	 * @return userId
	 */
	Long getUserId(Object object);

}
