package com.Aspect;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@ComponentScan(basePackages = {"com.Aspect","com.Aspect.Services"})
@EnableAspectJAutoProxy
public class Config {

}
