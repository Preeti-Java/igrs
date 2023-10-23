/**
 * 
 */
package com.cg.neel.igrs.users.jwtconfiguration;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Preeti
 * @Des Used for return all type of token
 *
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class JwtResponseToken {

	private String token;
}
