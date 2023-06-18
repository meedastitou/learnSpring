package com.auto_wire;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Person {

    public Person(){
        System.out.println("Person bean created by Spring");
        this.name="mohamed";
    }

    private String name;
    
    
    /*
     * 
     * by default autowire has parametre required true
     * you can change it to ::: @AutoWired(required = false)
     */
    @Autowired
    private Vehicle vehicle;

    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }
}
