/**
 * 
 */
package com.cg.neel.igrs.users.service;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.neel.igrs.exceptions.MobileSaveDatabaseException;
import com.cg.neel.igrs.users.UserRegAccessBean;
import com.cg.neel.igrs.users.repository.UserRegRepository;
import com.cg.neel.igrs.utils.Utils;

import lombok.RequiredArgsConstructor;

/**
 * @author Preeti
 *
 */
@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
	

	private final RegistrationService registrationService;
	
	
	private final  VerifyCredentialsService verifyCredentialsService;
	
	
	private final UserRegRepository userRegRepository;
	
	private static final String MOBILE_PATTERN = "(0/91)?[7-9]\\d{9}";
	private static final String EMAIL_PATTERN = "^[A-Za-z0-9+_.-]+@(.+)$";
	
	private static final String MOBILE_NOT_EXIST = "This mobile is not Exist : ";

	@Override
	public boolean isMobileNumber(String param) {
		  // Regular expression pattern for a  mobile number 
        Pattern pattern = Pattern.compile(MOBILE_PATTERN);
        Matcher matcher = pattern.matcher(param);
        return matcher.matches();
	}

	@Override
	public boolean isEmail(String param) {
		 // Regular expression pattern for a  email address 
        Pattern pattern = Pattern.compile(EMAIL_PATTERN);
        Matcher matcher = pattern.matcher(param);
        return matcher.matches();
	}

	@Override
	public String validateMobile(String recipientPhoneNumber) {
		//Remove 2 starting digit because this is code of country
		//check mobile already exit or not, condition mobile number should be exist or verified
			if(!registrationService.isMobileExists(recipientPhoneNumber.substring(2)) && !registrationService.isMobileVerified(recipientPhoneNumber.substring(2))) {
				throw new MobileSaveDatabaseException(MOBILE_NOT_EXIST+recipientPhoneNumber);
			}
			//Send new OTP
			return verifyCredentialsService.otpSendMethod(recipientPhoneNumber);
	}

	@Override
	public void savePassword(UserRegAccessBean userRegAccessBean) {
		//Update Password Creation
		userRegAccessBean.setPasswordCreation(Utils.getDate());
		userRegRepository.save(userRegAccessBean);
	}

	@Override
	public Long getUserId(Object object) {
		UserRegAccessBean userRegAccessBean = userRegRepository.findByMobileNo(object.toString());
		return userRegAccessBean.getUserId();
	}

}
