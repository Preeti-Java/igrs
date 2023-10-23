/**
 * 
 */
package com.cg.neel.igrs.core.shared.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.cg.neel.igrs.ui.content.dto.ChildMenuDto;
import com.cg.neel.igrs.ui.content.dto.ChildRoleMenuGetDto;
import com.cg.neel.igrs.ui.content.dto.MenuDto;
import com.cg.neel.igrs.ui.content.dto.RoleMenuGetDto;
import com.cg.neel.igrs.utils.GenericResponse;

/**
 * @author Preeti Rani
 *
 */

@RequestMapping("/default")
public interface HeaderCmd {
	
	@GetMapping("/default")
	public ResponseEntity<Map<String,Object>> getDefaultMenu(HttpServletRequest httpServletRequest);
	
	
	@GetMapping("/dashboard")
	public ResponseEntity<Map<String, Object>> getMenuByRole(HttpServletRequest httpServletRequest );
	
	//For other micro-service
	@GetMapping("/menu")
	public ResponseEntity<List<Object[]>> getMenu(HttpServletRequest httpServletRequest);
	
	@PostMapping("/menu")
	public GenericResponse saveMenu(HttpServletRequest httpServletRequest, @RequestBody RoleMenuGetDto roleMenuGetDto);
	
	@DeleteMapping("/menu")
	public GenericResponse deleteMenu(HttpServletRequest httpServletRequest, @RequestParam Long menuId);
	
	@PutMapping("/menu")
	public GenericResponse updateMenu(HttpServletRequest httpServletRequest, @RequestBody MenuDto menuDto);
	
	//For other micro-service
	@PostMapping("/submenu")
	public GenericResponse saveSubMenu(HttpServletRequest httpServletRequest, @RequestBody ChildRoleMenuGetDto childMenuRoleGetDto);
	
	@DeleteMapping("/submenu")
	public GenericResponse deleteSubMenu(HttpServletRequest httpServletRequest, @RequestParam Long childMenuId);
	
	@PutMapping("/submenu")
	public GenericResponse updateSubMenu(HttpServletRequest httpServletRequest, @RequestBody ChildMenuDto childMenuDto);
	
	

}
