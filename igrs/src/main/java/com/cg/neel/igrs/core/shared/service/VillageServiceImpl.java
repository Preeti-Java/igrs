package com.cg.neel.igrs.core.shared.service;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.neel.igrs.searchdata.DistrictAccessBean;
import com.cg.neel.igrs.searchdata.VillageAccessBean;
import com.cg.neel.igrs.searchdata.repository.DistrictRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class VillageServiceImpl implements  VillageService{
	

	private final  DistrictRepository districtRepository;

	@Override
	public Set<VillageAccessBean> getVillageListByDistrictId(int districtId) {
		DistrictAccessBean districtAccessBean = districtRepository.findByIdOrderByEnglishAsc(districtId);
		return districtAccessBean.getVillageAccessBeans(); 
	}

}
