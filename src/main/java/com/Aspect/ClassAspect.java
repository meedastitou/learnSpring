package com.Aspect;

import java.time.Duration;
import java.time.Instant;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;


@Aspect
@Component
@Order(1)
public class ClassAspect {
	
	private Logger logger = Logger.getLogger(ClassAspect.class.getName());
	
	
	@Around("execution(* com.Aspect.Services.*.*(..))")
	public void log(ProceedingJoinPoint joinPoint) throws Throwable {
		Instant start = Instant.now();
		logger.info(joinPoint.getSignature().toString()+" method execution Started");
	// Start traitement
		joinPoint.proceed();
	// Fin traitement
		logger.info(joinPoint.getSignature().toString()+" method execution Fin");
		Instant fin = Instant.now();
		long timeOfTheMethod = Duration.between(start, fin).toMillis();
		logger.info("Time took to execute the method : " + timeOfTheMethod);
	}
	
	
	@AfterThrowing(value = "execution(* com.Aspect.Services.*.*(..))" , throwing="ex")
	public void ArticleAfterThrowingAspect(JoinPoint joinPoint, Exception ex) {
		System.out.println("i'm in method ArticleAfterThrowingAspect");
		logger.log(Level.SEVERE, joinPoint.getSignature() + " An Exception throw with the help of "+
				"@AfterThrowing with happened due to : " + ex.getMessage());
	}
	
	@AfterReturning(value = "execution(* com.Aspect.Services.*.*(..))", returning="retVal")
	public void ArticleAfterReturningAspect(JoinPoint joinPoint, Object retVal) {
		System.out.println("i'm in method ArticleAfterReturningAspect");
		logger.log(Level.INFO, joinPoint.getSignature() + " Method successfully processed with the status  "+
		retVal);
	}
	
	@Around("@annotation(com.Aspect.logAspect)")
    public void logWithAnnotation(ProceedingJoinPoint joinPoint) throws Throwable {
        logger.info(joinPoint.toString() + " method execution start");
        Instant start = Instant.now();
        joinPoint.proceed();
        Instant finish = Instant.now();
        long timeElapsed = Duration.between(start, finish).toMillis();
        logger.info("Time took to execute the method : "+timeElapsed);
        logger.info(joinPoint.getSignature().toString() + " method execution end");
    }
}
