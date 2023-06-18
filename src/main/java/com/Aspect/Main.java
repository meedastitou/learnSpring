package com.Aspect;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.Aspect.Services.ArticleService;

public class Main {
	public static void main(String []argv) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
		ArticleService articleService = context.getBean(ArticleService.class);
//		articleService.fetchArticle();
//		int id =2;
//		articleService.getSomthing(id);
		articleService.testingOurAspect();
	}
}
