/**
 * 
 */
package com.cg.neel.igrs.ui.content.dto;

import java.util.Set;

import org.mapstruct.Mapper;

import com.cg.neel.igrs.ui.content.MenuAccessBean;
import com.cg.neel.igrs.users.RolesAccessBean;
import com.cg.neel.igrs.users.dto.RoleSlimDto;

/**
 * @author Preeti
 * @Des Header Controller DTO converter method
 *
 */
@Mapper(
		componentModel = "String"
		)
public interface HeaderMapStructMapper {
	
	RolesAccessBean roleDtoToRoleAccessBean(RoleSlimDto roleDto);
	
	MenuAccessBean menuDtoToMenuAccessBean(MenuDto menuDto);
	
	Set<MenuAccessBean> roleMenuGetDtoToMenuAccessBean(RoleMenuGetDto roleMenuGetDto);
	
	

}
