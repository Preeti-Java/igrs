/**
 * 
 */
package com.cg.neel.igrs.core.shared.controller;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.ResponseEntity;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.neel.igrs.core.shared.service.HeaderService;
import com.cg.neel.igrs.ui.content.MenuAccessBean;
import com.cg.neel.igrs.ui.content.dto.ChildMenuDto;
import com.cg.neel.igrs.ui.content.dto.ChildRoleMenuGetDto;
import com.cg.neel.igrs.ui.content.dto.HeaderMapStructMapper;
import com.cg.neel.igrs.ui.content.dto.MenuDto;
import com.cg.neel.igrs.ui.content.dto.RoleMenuGetDto;
import com.cg.neel.igrs.utils.GenericResponse;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * @author Preeti Rani
 *
 */

@RestController
@RequestMapping("/header")
@Slf4j
@CrossOrigin("*")
@RequiredArgsConstructor
public class HeaderCmdImpl implements HeaderCmd{

	
	private final HeaderService headerService;
	
	
	private final HeaderMapStructMapper headerMapStructMapper;
	
	
	private static final String  DEFAULT_ROLE = "GUEST"; //Default User
	private static final String SUCCESS = "Success";
	private static final String ERROR = "Error";
	private static final String NOT_UPDATE_SUCCESSFULLY = "Not Update Successfully";
	
	
	
	@Override
	public ResponseEntity<Map<String,Object>> getDefaultMenu(HttpServletRequest httpServletRequest) {
		Map<String,Object> menuDto=headerService.getDefaultMenu();
		log.info("Request received for /header endpoint.");
		return ResponseEntity.ok().body(menuDto) ;
	}


	@Override
	public ResponseEntity<Map<String, Object>> getMenuByRole(HttpServletRequest httpServletRequest) {
		
		String roleName = DEFAULT_ROLE; //Default User
		
		Collection<? extends GrantedAuthority>  grantedAuthorityCollection =  SecurityContextHolder.getContext().getAuthentication().getAuthorities();
		for(GrantedAuthority grantedAuthority : grantedAuthorityCollection)
			roleName = grantedAuthority.getAuthority();
		
	    Map<String,Object> menuDto=headerService.getMenuByRole(roleName);
	    log.info("Request received for /header/dashboard endpoint.");
		return ResponseEntity.ok().body(menuDto) ;
	}


	@Override
	public ResponseEntity<List<Object[]>> getMenu(HttpServletRequest httpServletRequest) {
		log.info("Request received for /header/menu endpoint.");
		return ResponseEntity.ok().body(headerService.findAllRoles());
	}


	@Override
	public GenericResponse saveMenu(HttpServletRequest httpServletRequest, RoleMenuGetDto roleMenuGetDto) {
		
		//Convert RoleMenuGetDto -> MenuAccessBean with join table
		Set<MenuAccessBean>  data = headerMapStructMapper.roleMenuGetDtoToMenuAccessBean(roleMenuGetDto);
		
		headerService.saveMenu(roleMenuGetDto.getRoleId(),data);
		log.info("Manu Save Successfully");
		return new GenericResponse(SUCCESS);
	}


	@Override
	public GenericResponse deleteMenu(HttpServletRequest httpServletRequest, Long menuId) {
		headerService.deleteByMenuId(menuId);
		log.info("Manu Deleted Successfully");
		return  new GenericResponse(SUCCESS);
	}


	@Override
	public GenericResponse updateMenu(HttpServletRequest httpServletRequest, MenuDto menuDto) {
		//Convert MenuDto -> MenuAccessBean
		MenuAccessBean menuAccessBean = headerMapStructMapper.menuDtoToMenuAccessBean(menuDto);
		
		MenuAccessBean menuUpdate = headerService.updateMenu(menuAccessBean);
		if(menuUpdate == null)
			return new GenericResponse(ERROR, NOT_UPDATE_SUCCESSFULLY);
		return  new GenericResponse(SUCCESS);
	}


	@Override
	public GenericResponse saveSubMenu(HttpServletRequest httpServletRequest, ChildRoleMenuGetDto childMenuRoleGetDto) {
		return null;
	}


	@Override
	public GenericResponse deleteSubMenu(HttpServletRequest httpServletRequest, Long childMenuId) {
		return null;
	}


	@Override
	public GenericResponse updateSubMenu(HttpServletRequest httpServletRequest, ChildMenuDto childMenuDto) {
		return null;
	}

	
}
