/**
 * 
 */
package com.cg.neel.igrs.users.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.neel.igrs.users.UserDemoAccessBean;

/**
 * @author User
 *
 */

@Repository
public interface UserDemoRepository extends  JpaRepository<UserDemoAccessBean, Long>{

}
