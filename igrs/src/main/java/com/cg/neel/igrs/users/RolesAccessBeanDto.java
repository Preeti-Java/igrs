/**
 * 
 */
package com.cg.neel.igrs.users;

import lombok.Data;

/**
 * @author User
 * @Description : This dto stores the roles defined, Once a role is created, you cannot change the
 *  name or description of a role 
 *
 */

@Data
public class RolesAccessBeanDto {
	
	private Long roleId;
	
	private String name;
	
	private String description;
	
	private int optCounter;
	
}
