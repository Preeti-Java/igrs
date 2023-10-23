/**
 * 
 */
package com.cg.neel.igrs.ui.content.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cg.neel.igrs.ui.content.MenuRoleAccessBean;

/**
 * @author Preeti
 *
 */

@Repository
public interface MenuRoleRepository extends JpaRepository<MenuRoleAccessBean, Long>{



	/**
	 * @param roleId
	 * @return
	 */
	@Query(value = "Select r from MenuRoleAccessBean r where r.rolesAccessBean.roleId = ?1" )
	List<MenuRoleAccessBean> findAllByRole(Long roleId);

}
