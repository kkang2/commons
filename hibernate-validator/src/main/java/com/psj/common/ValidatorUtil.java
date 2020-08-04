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
		//Set<ConstraintViolation<NumberDomain>> constraintViolations = getValidator().validate(domain); // 객체에 선언된 모든 제약검사
        //Set<ConstraintViolation<NumberDomain>> constraintViolations = getValidator().validateProperty(domain, "count"); // 프로퍼티 명을 사용하여 해당 객체의 프로퍼티에 선언된 제약을 검사
        //Set<ConstraintViolation<NumberDomain>> constraintViolations = getValidator().validateValue(NumberDomain.class, "count", 1);
	}
}
