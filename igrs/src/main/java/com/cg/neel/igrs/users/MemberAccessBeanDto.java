/**
 * 
 */
package com.cg.neel.igrs.users;

import lombok.Data;

/**
 * @author Preeti
 * @Description : Stores the list of members (participants) -
 *  A member is either a user, an organizational entity or a member group.
 *
 */

@Data
public class MemberAccessBeanDto {
	
	private Long memberId;

	private char type;
	
	private int state;
	
}
