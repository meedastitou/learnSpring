package com.Aspect.Services;

import java.time.Duration;
import java.time.Instant;
import java.util.logging.Logger;

import org.springframework.stereotype.Component;

import com.Aspect.logAspect;

@Component
public class ArticleService {
	
	private Logger logger = Logger.getLogger(ArticleService.class.getName());
	
	
	public String fetchArticle() {
		/*Instant start = Instant.now();
		logger.info("method execution Started");
		*/
		
		// Start traitement
		System.out.println("i'm method fetchArticle");
		
		
		// Fin traitement
		/*
		Instant fin = Instant.now();
		long timeOfTheMethod = Duration.between(start, fin).toMillis();
		logger.info("Time took to execute the method : " + timeOfTheMethod);
		*/
		return "meed";
	}
	public String getSomthing(int id) {
		System.out.println("i'm in method getSomthing");
		return "meed";
	}
	
	@logAspect
	public void testingOurAspect() {
		System.out.println("i'm in method testingOurAspect ");
	}
	
}
