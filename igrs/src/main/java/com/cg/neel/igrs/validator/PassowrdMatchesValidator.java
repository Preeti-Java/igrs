/**
 * 
 */
package com.cg.neel.igrs.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.cg.neel.igrs.users.UserRegDto;

/**
 * @author Preeti
 *
 */
public class PassowrdMatchesValidator implements ConstraintValidator<PasswordMatches, Object>{

	@Override
	public boolean isValid(final Object value, final ConstraintValidatorContext context) {
		final UserRegDto userReg = (UserRegDto) value;
		return userReg.getLogonPassword().equals(userReg.getLogonMatchPassword());
	}

}
