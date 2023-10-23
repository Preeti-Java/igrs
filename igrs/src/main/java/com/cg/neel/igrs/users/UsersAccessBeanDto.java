/**
 * 
 */
package com.cg.neel.igrs.users;

import java.util.Date;

import lombok.Data;

/**
 * @author Preeti
 * @Description : This class dto of UserAccessBean.
 */

@Data 
public class UsersAccessBeanDto {

	private Long userId;
	
	private char registerType;
	
	private Date registration;
	
	private Date lastSession; 
	
	private Date registrationUpdate;
	
	private Date registrationCancel;
	
}
