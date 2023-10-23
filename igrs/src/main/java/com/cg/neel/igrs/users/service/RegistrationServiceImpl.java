/**
 * 
 */
package com.cg.neel.igrs.users.service;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.cg.neel.igrs.exceptions.InternalServerErrorException;
import com.cg.neel.igrs.exceptions.LogonIdAlreadyExistException;
import com.cg.neel.igrs.users.RolesAccessBean;
import com.cg.neel.igrs.users.UserRegAccessBean;
import com.cg.neel.igrs.users.UserRegDto;
import com.cg.neel.igrs.users.repository.RolesRepository;
import com.cg.neel.igrs.users.repository.UserRegRepository;
import com.cg.neel.igrs.utils.Utils;

import lombok.RequiredArgsConstructor;

/**
 * @author Preeti
 *
 */
@Service
@RequiredArgsConstructor
public class RegistrationServiceImpl implements RegistrationService{
	

	private final PasswordEncoder passwordEncoder;
	
	
	private final  UserRegRepository userRegRepository;
	
	
	private final RolesRepository rolesRepository;
	
	private static final String MOBILE_NOT_VERIFIED = "Mobile Not Verified : ";
	private static final String LOGONID_ALREADY_EXIST = "This Email-Id already exist : ";
	
	private static final String REGISTERED_ROLE = "REGISTERED";
	
	@Override
	public UserRegAccessBean registerNewUserAccount(final UserRegDto userRegDto) {
		
		final UserRegAccessBean userRegAccessBean=new UserRegAccessBean();
		userRegAccessBean.setLogonId(userRegDto.getLogonId());
		userRegAccessBean.setLogonPassword(passwordEncoder.encode(userRegDto.getLogonPassword()));
		userRegAccessBean.setStatus(0);
		userRegAccessBean.setMobileVerified(true);
		userRegAccessBean.setMobileNo(userRegDto.getMobileNo());
		userRegAccessBean.setPasswordExpired(0);
		//Today Date
		userRegAccessBean.setPasswordCreation(Utils.getDate());
		//Assign Role Group
		Set<RolesAccessBean> rolesList = rolesRepository.findByName(REGISTERED_ROLE);
		userRegAccessBean.setRolesAccessBeans(rolesList);	
		
		return userRegRepository.save(userRegAccessBean);
	}

	/**
	 * @param mobileNo
	 * @return
	 */
	public boolean isMobileVerified(String mobileNo) {
		return userRegRepository.existsMobileVerifiedByMobileNo(mobileNo);
	}

	/**
	 * @param logonId (mail-Id)
	 * @return
	 */
	private boolean isLogonIdExists(String logonId) {
		return userRegRepository.findByLogonId(logonId) != null;
	}

	/**
	 * @parammobileId (mobile No)
	 * @return boolean value
	 */
	@Override
	public boolean isMobileExists(final String mobileNo) {
		return userRegRepository.findByMobileNo(mobileNo) != null;
	}

	@Override
	public boolean verifiedCreditional(UserRegDto userRegDto) {
		//Check Mobile Exit and Verified

		if (!isMobileExists(userRegDto.getMobileNo()) && !isMobileVerified(userRegDto.getMobileNo())) { // Update in future 
			throw new InternalServerErrorException(MOBILE_NOT_VERIFIED + userRegDto.getMobileNo());
		}
		 
		//Check LogonId (Email-Id) already Exist or not

		if (isLogonIdExists(userRegDto.getLogonId())) {
			throw new LogonIdAlreadyExistException(LOGONID_ALREADY_EXIST + userRegDto);
		}

		return true;
	}

	@Override
	public UserRegAccessBean findByLogonid(String logonId) {
		return userRegRepository.findByLogonId(logonId);
	}

	@Override
	public UserRegAccessBean findByMobileNo(String mobileNo) {
		return userRegRepository.findByMobileNo(mobileNo);
	}

}
