package com.cg.neel.igrs.core.shared.controller;

import java.lang.reflect.InvocationTargetException;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.neel.igrs.core.shared.service.DistrictService;
import com.cg.neel.igrs.core.shared.service.HeaderService;
import com.cg.neel.igrs.core.shared.service.TehsilService;
import com.cg.neel.igrs.core.shared.service.VillageService;
import com.cg.neel.igrs.core.shared.service.YearService;
import com.cg.neel.igrs.searchdata.DistrictAccessBean;
import com.cg.neel.igrs.searchdata.TehsilAccessBean;
import com.cg.neel.igrs.searchdata.VillageAccessBean;
import com.cg.neel.igrs.searchdata.YearAccessBean;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/searchSubMenu")
@RequiredArgsConstructor
public class RequestPageSubMenuCmdImpl implements RequestPageSubMenuCmd {
	
	private static final String MENU_NOT_FOUND = "Menu value : ";
	private static final String DATA = "data";
	private static final String MENU = "menu";

	
	private final HeaderService headerService;
	
	
	private final  DistrictService districtService;
	
	private final TehsilService tehsilService;

	private final VillageService villageService;
	
	
	private final YearService yearService;

	// This method return all the menu
	// Menu Hierarchy like District -> SubDistrict Always
	@Override
	public ResponseEntity<Map<String, Object>> getByOwnerMenu(final Long menudId) {
		Map<String, Object> menuDto = headerService.getByOwnerMenu(menudId);
		return ResponseEntity.ok().body(menuDto);
	}

	@Override
	public ResponseEntity<Set<Object>> getDataList2(final Long menuId)
			throws NotFoundException, IllegalAccessException, NoSuchMethodException, SecurityException,
			IllegalArgumentException, InvocationTargetException {
		// First check required -> data or child menu
			return ResponseEntity.ok().body(headerService.getDataList(menuId));
	}

	// Map<key,value> -> key: menuId , value: menuValue(this menuId is a dependency
	// of main menuId which data is required)
	// menuId -> Data required
	// ch -> table data
	@Override
	public ResponseEntity<Set<Object>> getDataListByMenuValue(final Map<String, String> map, final Long menuId,
			final String ch) throws NotFoundException, IllegalAccessException, NoSuchMethodException, SecurityException,
			IllegalArgumentException, InvocationTargetException {
		 //validate value is null or not
        if(menuId == null)
        	 throw new NullPointerException(MENU_NOT_FOUND + menuId);
		
		// First check required -> data or child menu
		if (ch.equals(DATA)) {
			return ResponseEntity.ok(headerService.getDataListByMenuValue(map, menuId, ch));
		}
		else if (ch.equals(MENU)) {
			Map<String, Object> menuDto = headerService.getByOwnerMenu(menuId);
			Set<Object> data = new LinkedHashSet<>(menuDto.values());
			return ResponseEntity.ok().body(data);
		}

			return ResponseEntity.ok().body(null);
	}

	////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	@Override
	public  List<DistrictAccessBean> getDistrictList() throws NotFoundException, IllegalAccessException,
			NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
		return districtService.getAllDistrict();
	}

	@Override
	public List<TehsilAccessBean> getTehsilList() throws NotFoundException, IllegalAccessException,
			NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
		return tehsilService.getAllTehsil();
	}

	@Override
	public Set<VillageAccessBean> getVillageListByDistrictId(int districtId) throws NotFoundException, IllegalAccessException,
			NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
		return villageService.getVillageListByDistrictId(districtId);
	}

	@Override
	public List<YearAccessBean> getYearList() throws NotFoundException, IllegalAccessException, NoSuchMethodException,
			SecurityException, IllegalArgumentException, InvocationTargetException {
		return yearService.getYearList();
	}

	

}
