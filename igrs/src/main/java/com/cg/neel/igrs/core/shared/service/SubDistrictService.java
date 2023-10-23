package com.cg.neel.igrs.core.shared.service;

import java.util.List;

import com.cg.neel.igrs.searchdata.SubDistrictAccessBean;

public interface SubDistrictService {


	/**
	 * @param districtId
	 * @return List<SubDistrictAccessBean>
	 */
	List<SubDistrictAccessBean> getSubDistrictByDistrictId(Long districtId);

}
