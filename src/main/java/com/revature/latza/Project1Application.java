package com.revature.latza;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

import lombok.extern.slf4j.Slf4j;

@SpringBootApplication
@Slf4j
public class Project1Application{
	private static final Logger aLogger = LoggerFactory.getLogger(Project1Application.class);
	
	public static void main(String[] args) {
		aLogger.info("programStart");
		SpringApplication.run(Project1Application.class, args);
		//this run() method bootstraps the rest of the program and its features
	
	}
	

}
//TODO: is this the one on my repo now?