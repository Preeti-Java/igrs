/**
 * 
 */
package com.cg.neel.igrs.validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * @author Preeti
 * @Description : This class validate the PASSWORD  
 *
 */
public class PasswordValidator implements ConstraintValidator<ValidPassword, String>{
	
	public static final String PASSWORD_PATTERN = "(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])(?=.*[$@$!%*?&])[A-Za-z\\d$@$!%*?&].{6,}";
	
	private static final Pattern PATTERN = Pattern.compile(PASSWORD_PATTERN);

	@Override
	public boolean isValid(final String value,  final ConstraintValidatorContext context) {
		return validatePassword(value);
	}

	/**
	 * @param PASSWORD Number
	 * @return validation
	 */
	private boolean validatePassword(final String value) {
		Matcher matcher = PATTERN.matcher(value);
		return matcher.matches();
	}

}
