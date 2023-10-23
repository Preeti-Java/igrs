/**
 * 
 */
package com.cg.neel.igrs.users;

import lombok.Data;

/**
 * @author Preeti
 * @Description : This dto contains member connect with roles name, Each member
 *              can play one or more roles
 *
 */

@Data
public class MemberRolesAccessBeanDto {

	private Long memberId;

	private Long roleId;

	private int optCounter;

}
