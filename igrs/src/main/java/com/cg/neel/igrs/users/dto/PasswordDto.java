/**
 * 
 */
package com.cg.neel.igrs.users.dto;

import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.Setter;

/**
 * @author Preeti
 *
 */
@Getter
@Setter

public class PasswordDto {
	
	
	@NotNull
	private String oldPassword;
	
	@NotNull
	private String newPassword;
	
	@NotNull
	private String confirmPassword;

}
