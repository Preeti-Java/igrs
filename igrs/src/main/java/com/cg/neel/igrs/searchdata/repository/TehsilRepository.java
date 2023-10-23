package com.cg.neel.igrs.searchdata.repository;


import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cg.neel.igrs.searchdata.TehsilAccessBean;

@Repository
public interface TehsilRepository extends MappedTypeRepository<TehsilAccessBean>{
	
	  @Query("SELECT t FROM #{#entityName} t")
	  public List<TehsilAccessBean> findByDistrictId(Integer id);

	/**
	 * @return
	 */
	public List<TehsilAccessBean> findByOrderByEnglishAsc();
	 
}
