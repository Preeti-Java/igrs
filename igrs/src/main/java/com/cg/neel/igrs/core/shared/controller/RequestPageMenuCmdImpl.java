package com.cg.neel.igrs.core.shared.controller;





import java.util.List;

import org.springframework.web.bind.annotation.RestController;

import com.cg.neel.igrs.core.shared.service.RequestPageService;
import com.cg.neel.igrs.ui.content.MenuAccessBean;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;


@RestController
@RequiredArgsConstructor
@Slf4j
public class RequestPageMenuCmdImpl implements RequestPageMenuCmd{
	
	
	private final RequestPageService requestPageService;
	

	@Override
	public List<MenuAccessBean> getSearchMenu() {
		log.info("Request received for /menu/getSearchMenu endpoint.");
		return requestPageService.getSearchMenu();
	}
	

}
