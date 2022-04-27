package com.subhajit.SpringBootInputOutputStorehouse;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.servlet.config.annotation.PathMatchConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.util.UrlPathHelper;

@SpringBootApplication
@ComponentScan(basePackages = "com.subhajit")
public class SpringBootInputOutputStorehouseApplication implements WebMvcConfigurer{

	public static void main(String[] args) {
		SpringApplication.run(SpringBootInputOutputStorehouseApplication.class, args);
	}

		// Mandatory if we want MaxtrixParams to work
		@Override
	    public void configurePathMatch(PathMatchConfigurer configurer) {
	        UrlPathHelper urlPathHelper = new UrlPathHelper();
	        urlPathHelper.setRemoveSemicolonContent(false);
	        configurer.setUrlPathHelper(urlPathHelper);
	    }
		
}

/*
 * This Spring Boot application acts as Web Service. It's controllers contains all
 * input techniques and output techniques related to spring framework. This web service can be called by any client. This
 * application will detail in the field of Spring Framework Input taking and
 * output propagating techniques.
 * 
 * This app is not registered to Eureka or Zuul.
 * 
 * Clients who can use this Web Service :
 * 1. Rest Template 		--> RestTemplateTutorial, /rest-template-tutorial, 10001
 * 2. Feign Client  		--> FeignClientTutorial, /spring-feign-client, 10003
 * 3. Spring 5 WebCLient	--> WebClientTutorial, /spring-web-client, 10002
 * 4. Postman
 */