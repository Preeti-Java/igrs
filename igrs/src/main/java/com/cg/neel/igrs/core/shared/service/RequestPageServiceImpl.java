package com.cg.neel.igrs.core.shared.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.neel.igrs.ui.content.MenuAccessBean;
import com.cg.neel.igrs.ui.content.repository.MenuRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class RequestPageServiceImpl implements RequestPageService{
	
	
	private final MenuRepository menuRepository;
	
	@Override
	public List<MenuAccessBean> getSearchMenu() {
	   return menuRepository.findByTitle("getSearchMenu");
		
	}	

}
