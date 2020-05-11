package com.example.demo;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
@SpringBootApplication
public class MongodbSpringSwaggerLog4jApplication {
	private static final Logger logger = LogManager.getLogger(MongodbSpringSwaggerLog4jApplication.class);
	public static void main(String[] args) {
		SpringApplication.run(MongodbSpringSwaggerLog4jApplication.class, args);
		
		logger.error("App started  " +logger.getLevel() + " level ---");
		
		 

	}

}
