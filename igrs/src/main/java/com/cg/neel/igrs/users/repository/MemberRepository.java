/**
 * 
 */
package com.cg.neel.igrs.users.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.neel.igrs.users.MemberAccessBean;

/**
 * @author User
 *
 */

@Repository
public interface MemberRepository extends JpaRepository<MemberAccessBean, Long>{

}
