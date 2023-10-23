package com.cg.neel.igrs.core.shared.controller;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cg.neel.igrs.ui.content.MenuAccessBean;

@RequestMapping("/menu")
public interface RequestPageMenuCmd {
	
	@GetMapping("/getSearchMenu")
	 List<MenuAccessBean> getSearchMenu();
	

}
