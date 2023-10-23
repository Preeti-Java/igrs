package com.cg.neel.igrs.searchdata.repository;


import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cg.neel.igrs.searchdata.RegistrationYearAccessBean;

@Repository
public interface RegistrationYearRepository extends MappedTypeRepository<RegistrationYearAccessBean>{
	
	  @Query("SELECT t FROM #{#entityName} t")
	  public List<RegistrationYearAccessBean> findByDistrictId(Integer id);
	 
}
