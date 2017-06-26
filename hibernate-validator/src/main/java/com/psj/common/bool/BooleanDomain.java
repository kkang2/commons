package com.psj.common.bool;

import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.constraints.AssertFalse;
import javax.validation.constraints.AssertTrue;

import com.psj.common.ValidatorUtil;

public class BooleanDomain {
	@AssertTrue
	private boolean mustTrue;
	
	@AssertFalse
	private boolean mustFalse;
	
	public BooleanDomain(boolean mustTrue, boolean mustFalse) {
		this.mustTrue = mustTrue;
		this.mustFalse = mustFalse;
	}
	
	public static void main(String[] args) {
		BooleanDomain domain = new BooleanDomain(false, true);
		
		Set<ConstraintViolation<Object>> constraintViolations = ValidatorUtil.getValidator().validate(domain);
		
		ValidatorUtil.printValidateInfo(constraintViolations);
	}
}