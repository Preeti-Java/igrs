/**
 * 
 */
package com.cg.neel.igrs.users;

import java.util.Date;

import com.cg.neel.igrs.users.utils.DateAudit;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author Preeti
 * @Description : This dto contains all registered users login info
 *
 */

@Data
@EqualsAndHashCode(callSuper=false)
public class UserRegAccessBeanDto extends DateAudit{
	
	
	private Long userId;
	
	private int status;
	
	private String logonId;
	
	private String logonPassword;
	
	private int passwordExpired;
	
	private Date passwordCreation;
	
	
}

