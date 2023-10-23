/**
 * 
 */
package com.cg.neel.igrs.users.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.neel.igrs.users.UserRegAccessBean;

/**
 * @author User
 *
 */
@Repository
public interface UserRegRepository extends JpaRepository<UserRegAccessBean, Long>{

	/**
	 * @param username - mobile No
	 * @return UserRegAccessBean
	 */
	UserRegAccessBean findByLogonId(String username);

	/**
	 * @param mobileId
	 * @return UserRegAccessBean
	 */
	UserRegAccessBean findByMobileNo(String mobileId);


	/**
	 * @param mobileNo
	 * @return
	 */
	boolean existsMobileVerifiedByMobileNo(String mobileNo);
	
	

}
