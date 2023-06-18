package com.Aspect;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(2)
public class ArticleStartCheckAspect {
	
	private Logger logger = Logger.getLogger(ArticleStartCheckAspect.class.getName());
	
	
	@Before("execution(* com.Aspect.Services.*.*(..)) && args(isdd,..)")
	public void checkArticleStarted(JoinPoint joinPoint, int isdd) throws Throwable {
		System.out.println("sem");
	}
	
	
	
}
