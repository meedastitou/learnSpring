package com.Scope.SingleTon;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

    public static void main(String[] args) {

    	AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ProjectConfig.class);
        Person person = context.getBean(Person.class);
        Person person2 = context.getBean(Person.class);
        /*
         * 
         * person and person2 are some!!!
         */
        if(person == person2) {
        	System.out.println("person " + person.hashCode());
        	System.out.println("person 2 " + person2.hashCode());
        }
        System.out.println("Person name from Spring Context is: " + person.getName());
        System.out.println("Vehicle that Person own is: " + person.getVehicle());

    }
}
