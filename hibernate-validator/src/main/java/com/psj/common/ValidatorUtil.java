package com.psj.common;

import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ValidatorUtil {
	private static Logger logger = LoggerFactory.getLogger(ValidatorUtil.class);
	
	public static Validator getValidator() {
		ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
		return factory.getValidator();
	}
	
	public static void printValidateInfo(Set<ConstraintViolation<Object>> constraintViolations) {
		logger.debug("벨리데이션 오류 갯수 : {}", constraintViolations.size());
		
		for (ConstraintViolation<Object> constraintViolation : constraintViolations) {
			logger.debug("오류메시지 : {}", constraintViolation.getMessage());
			logger.debug("입력된 값 : {}", constraintViolation.getInvalidValue() + "");
			logger.debug("오류메세지 설정패스 : {}, 오류 필드 : {}, 오류 어노테이션 : {}", constraintViolation.getMessageTemplate(),
					constraintViolation.getPropertyPath(), constraintViolation.getConstraintDescriptor().getAnnotation().annotationType());
		}
	}
	
	public static void main(String[] args) {

	}
}
