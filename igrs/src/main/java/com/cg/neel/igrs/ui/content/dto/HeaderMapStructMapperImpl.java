/**
 * 
 */
package com.cg.neel.igrs.ui.content.dto;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import org.springframework.stereotype.Component;

import com.cg.neel.igrs.ui.content.MenuAccessBean;
import com.cg.neel.igrs.users.RolesAccessBean;
import com.cg.neel.igrs.users.dto.RoleSlimDto;

/**
 * @author Preeti
 *
 */
@Component
public class HeaderMapStructMapperImpl implements HeaderMapStructMapper{

	@Override
	public RolesAccessBean roleDtoToRoleAccessBean(RoleSlimDto roleDto) {
		return null;
	}

	@Override
	public MenuAccessBean menuDtoToMenuAccessBean( MenuDto menuDto ) {
		
		if( menuDto == null ) {
			return new MenuAccessBean();
		}
		
		MenuAccessBean menuAccessBean = new MenuAccessBean();
		menuAccessBean.setLabelEn(menuDto.getLabelEn());
		menuAccessBean.setLabelHi(menuDto.getLabelHi());
		menuAccessBean.setUrl(menuDto.getUrl());
		menuAccessBean.setDescriptionEn(menuDto.getDescriptionEn());
		menuAccessBean.setDescriptionHi(menuDto.getDescriptionHi());
		menuAccessBean.setStatus(false);
		menuAccessBean.setOptCounter(0);
		if(menuDto.getMenuId() != null)
			menuAccessBean.setMenuId(menuDto.getMenuId());
		
		return menuAccessBean;
	}

	@Override
	public Set<MenuAccessBean> roleMenuGetDtoToMenuAccessBean(RoleMenuGetDto roleMenuGetDto) {
		
		if(roleMenuGetDto == null) {
			return Collections.emptySet();
		}
		
		Set<MenuDto> menuDtoList = roleMenuGetDto.getMenuDto();
		//return
		Set<MenuAccessBean> list = new HashSet<>( menuDtoList.size() );
		
		  for ( MenuDto menuDto : menuDtoList ) {
	            list.add( menuDtoToMenuAccessBean( menuDto ) );
	        }
		
		  return list;
	}

	

}
