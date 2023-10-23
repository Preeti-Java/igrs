package com.cg.neel.igrs.core.shared.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.neel.igrs.searchdata.YearAccessBean;
import com.cg.neel.igrs.searchdata.repository.YearRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class YearServiceImpl implements  YearService{
	
	
	private final YearRepository yearRepository;

	@Override
	public List<YearAccessBean> getYearList() {
		return yearRepository.findAll();
	}
	
}
