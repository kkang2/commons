package com.psj.common.numeric;

import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.constraints.Min;

import com.psj.common.ValidatorUtil;

public class IntDomain {
	@Min(2)
	private int minNum;
	
	public IntDomain(int minNum) {
		this.minNum = minNum;
	}
	
	public static void main(String[] args) {
		IntDomain domain = new IntDomain(1);
		
		Set<ConstraintViolation<Object>> constraintViolations = ValidatorUtil.getValidator().validate(domain);
		
		ValidatorUtil.printValidateInfo(constraintViolations);
	}
}