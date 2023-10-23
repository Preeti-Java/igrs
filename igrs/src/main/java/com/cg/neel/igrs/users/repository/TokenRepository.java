/**
 * 
 */
package com.cg.neel.igrs.users.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.neel.igrs.users.VerificationToken;

/**
 * @author Preeti
 *
 */

@Repository
public interface TokenRepository extends JpaRepository<VerificationToken, Long>{

	/**
	 * @param token
	 * @return VerificationToken
	 */
	VerificationToken findByToken(String token);
}
