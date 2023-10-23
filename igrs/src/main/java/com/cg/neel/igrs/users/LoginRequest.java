/**
 * 
 */
package com.cg.neel.igrs.users;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Preeti
 * @Des For Login
 *
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class LoginRequest {

	private String mobileNo;
	private String password;

}
