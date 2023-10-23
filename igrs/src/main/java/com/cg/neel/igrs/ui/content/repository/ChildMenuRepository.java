/**
 * 
 */
package com.cg.neel.igrs.ui.content.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.neel.igrs.ui.content.ChildMenuAccessBean;

/**
 * @author Preeti
 *
 */

@Repository
public interface ChildMenuRepository extends JpaRepository<ChildMenuAccessBean, Long>{

	List<ChildMenuAccessBean> findByPageId(int nextPageId);

	/**
	 * @param menuId
	 * @return table name
	 */
	ChildMenuAccessBean findTableNameByChildMenuId(Long menuId);

}
