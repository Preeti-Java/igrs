/**
 * 
 */
package com.cg.neel.igrs.users.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.neel.igrs.users.UsersAccessBean;

/**
 * @author Preeti
 *
 */
@Repository
public interface UsersRepository extends JpaRepository<UsersAccessBean, Long>{

}
