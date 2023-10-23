package com.cg.neel.igrs.searchdata.repository;


import java.util.List;

import org.springframework.stereotype.Repository;

import com.cg.neel.igrs.searchdata.DistrictAccessBean;

@Repository
public interface DistrictRepository extends MappedTypeRepository<DistrictAccessBean>{

	/**
	 * @param districtId
	 * @return
	 */
	DistrictAccessBean findById(int districtId);

	/**
	 * @return
	 */
	List<DistrictAccessBean> findByOrderByEnglishAsc();

	/**
	 * @param districtId
	 * @return
	 */
	DistrictAccessBean findByIdOrderByEnglishAsc(int districtId);


}
