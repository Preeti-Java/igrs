/**
 * 
 */
package com.cg.neel.igrs.users;

import java.util.Date;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.cg.neel.igrs.users.utils.DateAudit;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 * @author Preeti
 * @Description : This dto contains all registered users login info
 *
 */

@Data
@EqualsAndHashCode(callSuper=false)
//@PasswordMatches
public class UserRegDto extends DateAudit{
	
	@ToString.Exclude
	private int status;
	
	private Long userId;
	
	@NotNull
//	@ValidMobile
	private String logonId; //Email Id

	@NotNull
	@Size(min = 10, max = 10, message = "{Size.userRegDto.mobile}")
	private String mobileNo;
	
	@NotNull
	private boolean mobileVerified;
	
	@NotNull
	//@ValidPassword
	@Size(min = 1, message = "{Size.userRegDto.password}")
	private String logonPassword;
	
	@NotNull
	@Size(min = 1)
	@ToString.Exclude
	private String logonMatchPassword;
	
	@ToString.Exclude
	private int passwordExpired;
	
	@ToString.Exclude
	private Date passwordCreation;
	
	
}

