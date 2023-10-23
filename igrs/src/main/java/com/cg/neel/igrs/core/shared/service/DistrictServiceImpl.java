package com.cg.neel.igrs.core.shared.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.neel.igrs.searchdata.DistrictAccessBean;
import com.cg.neel.igrs.searchdata.repository.DistrictRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class DistrictServiceImpl implements  DistrictService{
	

	private final DistrictRepository districtRepository;
	

	@Override
	public List<DistrictAccessBean> getAllDistrict() {
		return districtRepository.findByOrderByEnglishAsc();
	}

}
