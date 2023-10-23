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
 * @Description : This class validate the mobile number 
 *
 */
public class MobileValidator implements ConstraintValidator<ValidMobile, String>{
	
	public static final String MOBILE_PATTERN = "(0/91)?[7-9][0-9]{9}";
	
	private static final Pattern PATTERN = Pattern.compile(MOBILE_PATTERN);

	@Override
	public boolean isValid(final String value,  final ConstraintValidatorContext context) {
		return validateMobile(value);
	}

	/**
	 * @param mobile Number
	 * @return validation
	 */
	private boolean validateMobile(final String value) {
		Matcher matcher = PATTERN.matcher(value);
		return matcher.matches();
	}

}
