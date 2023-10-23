package com.cg.neel.igrs.core.shared.service;

import java.util.Set;

import com.cg.neel.igrs.searchdata.VillageAccessBean;

public interface VillageService {

	/**
	 * @param districtId 
	 * @return Village List
	 */
	Set<VillageAccessBean> getVillageListByDistrictId(int districtId);

}
