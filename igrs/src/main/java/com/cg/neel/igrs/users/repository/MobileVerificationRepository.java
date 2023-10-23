/**
 * 
 */
package com.cg.neel.igrs.users.repository;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.neel.igrs.users.MobileVerification;

/**
 * @author Preeti
 *
 */

@Repository
@Transactional
public interface MobileVerificationRepository extends JpaRepository<MobileVerification, Long>{

	/**
	 * @param mobileNumber
	 * @return MobileVerification
	 */
	MobileVerification findByMobileNumber(@Valid String mobileNumber);

	/**
	 * @param latest mobileNumber 
	 * @return MobileVerification
	 */
	MobileVerification findTopByMobileNumber(@Valid String mobileNumber);

	/**
	 * @param mobileNumber
	 */
	
	void deleteByMobileNumber(String mobileNumber);

	/**
	 * @param mobileNumber
	 * @return
	 */
	MobileVerification findTopByMobileNumberOrderByMobileVerificationIdDesc(@Valid String mobileNumber);

}
