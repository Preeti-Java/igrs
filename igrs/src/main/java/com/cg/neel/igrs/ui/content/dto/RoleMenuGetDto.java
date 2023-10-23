/**
 * 
 */
package com.cg.neel.igrs.ui.content.dto;

import java.io.Serializable;
import java.util.Set;

import lombok.Data;

/**
 * @author Preeti
 * @Description : This dto stores menu list and  role id of role 
 *   
 *
 */

@Data
public class RoleMenuGetDto implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	//Role
	private Long roleId;
	
	//Menu
	private Set<MenuDto> menuDto;
	
}
