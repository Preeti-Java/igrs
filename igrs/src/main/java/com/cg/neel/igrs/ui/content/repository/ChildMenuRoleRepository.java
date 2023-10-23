/**
 * 
 */
package com.cg.neel.igrs.ui.content.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.neel.igrs.ui.content.ChildMenuRoleAccessBean;

/**
 * @author Preeti
 *
 */
@Repository
public interface ChildMenuRoleRepository extends JpaRepository<ChildMenuRoleAccessBean, Long>{


}
