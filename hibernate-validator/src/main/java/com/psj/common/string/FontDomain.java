package com.psj.common.string;

import java.util.Set;

import javax.validation.ConstraintViolation;

import com.psj.common.ValidatorUtil;
import com.psj.common.custom.validator.annotation.FontConstraint;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class FontDomain {
	@FontConstraint(message = "this font cannot be used")
	private String font;
	
	
	public static void main(String[] args) {
		FontDomain domain = new FontDomain("4");
		
		Set<ConstraintViolation<Object>> constraintViolations = ValidatorUtil.getValidator().validate(domain);
		
		ValidatorUtil.printValidateInfo(constraintViolations);
	}
}
