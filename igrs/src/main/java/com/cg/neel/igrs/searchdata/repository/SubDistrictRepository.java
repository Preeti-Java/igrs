package com.cg.neel.igrs.searchdata.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cg.neel.igrs.searchdata.SubDistrictAccessBean;

@Repository
public interface SubDistrictRepository extends JpaRepository<SubDistrictAccessBean, Integer>{

	/**
	 * @param districtId
	 * @return SubDistrictAccessBean List
	 */
	
	
	
	 @Query( value="Select subDistrictId,subDistrict,subDistrictHi from subdistrict where districtId = ?1", nativeQuery = true )
	//@Meta(comment = "find subdistrict by districtId")
	// @Query(value = "SELECT subDistrictId,subDistrict,subDistrictHi  FROM subdistrict a INNER JOIN district b WHERE a.districtId = ?1", nativeQuery = true) 
	List<SubDistrictAccessBean> findByDistrictId(int districtId);

}
