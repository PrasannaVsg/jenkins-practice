package com.spring.rest.advise;

import org.aspectj.lang.annotation.Pointcut;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class LogingAdvise {
	
	@Pointcut()
	
	public void methodStarts() {
		
	}

}
