/**
 * 
 */
package com.cg.neel.igrs.searchdata.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.neel.igrs.searchdata.YearAccessBean;

/**
 * @author Preeti
 *
 */
@Repository
public interface YearRepository extends JpaRepository<YearAccessBean, Long>{

	/**
	 * @param parseLong
	 * @return YearAccessBean
	 */
	YearAccessBean getBySno(long sno);



}
