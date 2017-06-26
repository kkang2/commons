package com.psj.common.string;

import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.psj.common.ValidatorUtil;

public class StringDomain {
	// ""(공백)은 허용된다.
	@NotNull
	private String notNull;
	
	// 값이 null 일 경우 허용되므로 @NotNull 과 같이 사용해야 함.
	@Size(min = 2, max = 14)
	private String size;
	
	public StringDomain(String notNull, String size) {
		this.notNull = notNull;
		this.size = size;
	}
	
	public static void main(String[] args) {
		StringDomain domain = new StringDomain("", "4");
		
		Set<ConstraintViolation<Object>> constraintViolations = ValidatorUtil.getValidator().validate(domain);
		
		ValidatorUtil.printValidateInfo(constraintViolations);
	}
}
