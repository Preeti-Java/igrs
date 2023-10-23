/**
 * 
 */
package com.cg.neel.igrs.ui.content.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cg.neel.igrs.ui.content.MenuAccessBean;

/**
 * @author Preeti
 *
 */

@Repository
public interface MenuRepository extends JpaRepository<MenuAccessBean, Long>{

	/**
	 * @param menuId
	 * @return
	 */
	MenuAccessBean getByMenuId(Long menuId);

	/**
	 * @param menuId
	 */
	@Modifying
    @Query(value = "DELETE t1, t2 FROM menu t1 INNER JOIN menurole t2 ON t2.menuid = t1.menu_id WHERE t1.menu_id = ?1", nativeQuery = true)
	void deleteMenuAndMenuRoleByMenuId(Long menuId);

	/**
	 * @param string
	 * @return
	 */
	List<MenuAccessBean> findByTitle(String string);


	/**
	 * @param menuId
	 * @return
	 */
	MenuAccessBean findByMenuId(Long menuId);



}
