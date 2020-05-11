package com.example.demo.nilesh;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.google.common.base.Predicate;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class ConfigurationSwagger {
	
	private ApiInfo apiInfo() {
		return new ApiInfoBuilder().title("Swagger API")
				.description("Swagger API ")
				.termsOfServiceUrl("http://MyAbc.com")
				.contact("nileshtiwarirxl@gmail.com").build();
	}
	
	 @Bean
	    public Docket api() {
	        return new Docket(DocumentationType.SWAGGER_2).select()
	            .apis(RequestHandlerSelectors
	                .basePackage("com.example.demo.controller"))
	            .paths(PathSelectors.regex("/.*"))
	            .build().apiInfo(apiInfo());
	    }


}
