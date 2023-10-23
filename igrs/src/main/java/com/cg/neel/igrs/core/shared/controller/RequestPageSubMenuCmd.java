package com.cg.neel.igrs.core.shared.controller;

import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.cg.neel.igrs.searchdata.DistrictAccessBean;
import com.cg.neel.igrs.searchdata.TehsilAccessBean;
import com.cg.neel.igrs.searchdata.VillageAccessBean;
import com.cg.neel.igrs.searchdata.YearAccessBean;


@RequestMapping
public interface RequestPageSubMenuCmd {
	
	@GetMapping("/byOwnerMenu")
	ResponseEntity<Map<String, Object>> getByOwnerMenu(@RequestParam("menuId") Long menuId);
	
	@GetMapping("/districtList2")
	ResponseEntity<Set<Object>> getDataList2(@RequestParam("menuId") Long menuId) throws NotFoundException,  IllegalAccessException,NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException;
	
	@GetMapping("/districtList1")
	ResponseEntity<Set<Object>> getDataListByMenuValue(@RequestParam Map<String,String> map,@RequestParam("menuId") Long menuId,@RequestParam("q") String ch) throws NotFoundException,  IllegalAccessException,NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException;
	
	@GetMapping("/districtList")
	 List<DistrictAccessBean> getDistrictList() throws NotFoundException,  IllegalAccessException,NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException;
	
	@GetMapping("/tehsilList")
	 List<TehsilAccessBean> getTehsilList() throws NotFoundException,  IllegalAccessException,NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException;
	
	@GetMapping("/villageList")
	Set<VillageAccessBean> getVillageListByDistrictId(@RequestParam("id") int districtId) throws NotFoundException,  IllegalAccessException,NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException;
	
	@GetMapping("/yearList")
	List<YearAccessBean> getYearList() throws NotFoundException,  IllegalAccessException,NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException;
	
}
