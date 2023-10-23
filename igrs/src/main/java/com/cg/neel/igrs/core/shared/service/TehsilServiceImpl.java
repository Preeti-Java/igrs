package com.cg.neel.igrs.core.shared.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.neel.igrs.searchdata.TehsilAccessBean;
import com.cg.neel.igrs.searchdata.repository.TehsilRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class TehsilServiceImpl implements  TehsilService{
	
	
	private final TehsilRepository tehsilRepository;

	@Override
	public List<TehsilAccessBean> getAllTehsil() {
		return tehsilRepository.findByOrderByEnglishAsc();
	}
	
}
