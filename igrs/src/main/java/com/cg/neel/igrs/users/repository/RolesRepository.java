/**
 * 
 */
package com.cg.neel.igrs.users.repository;

import java.util.List;
import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cg.neel.igrs.users.RolesAccessBean;

/**
 * @author User
 *
 */

@Repository
public interface RolesRepository extends JpaRepository<RolesAccessBean, Long> {

	/**
	 * @param l
	 * @return
	 */
	RolesAccessBean getByRoleId(long l);

	/**
	 * @param role name
	 * @return
	 */
	Set<RolesAccessBean> findByName(String name);

	/**
	 * @param roleName
	 * @return
	 */
	RolesAccessBean getByName(String name);

	/**
	 * @return
	 */
	/*
	 * @Query("SELECT a FROM Role a")
	 * 
	 * @EntityGraph(attributePaths = {"roleId","name"}) List<RolesAccessBean>
	 * findAll();
	 */
	public static final String FIND_ROLEID_NAME = "SELECT role_Id, name FROM roles";

	@Query(value = FIND_ROLEID_NAME, nativeQuery = true)
	public List<Object[]> findRoles();

}
