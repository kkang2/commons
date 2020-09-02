package com.psj.common.custom.validator;

import java.util.Arrays;
import java.util.List;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.psj.common.custom.validator.annotation.FontConstraint;

public class FontConstraintValidator implements ConstraintValidator<FontConstraint, String> { 
	public static final List<String> fonts = Arrays.asList("serif", "sans-serif", "d2coding", "verdana"); 
	
	@Override 
	public boolean isValid(String value, ConstraintValidatorContext context) { 
		return value != null && fonts.contains(value.toLowerCase()) ; 
	} 
}