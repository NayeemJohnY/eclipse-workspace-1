package com.springboot.telusko;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Scope;

@SpringBootApplication
public class SpringbootTeluskoApplication {

	public static void main(String[] args) {
//		ConfigurableApplicationContext context = SpringApplication.run(SpringbootTeluskoApplication.class, args);

		// Instead usual Object creation - Injecting -Container - component 
//		Alien alien = context.getBean(Alien.class);
//		alien.show();
//		
//		Alien alien2 = context.getBean(Alien.class);
//		alien2.show();
		
		SpringApplication.run(SpringbootTeluskoApplication.class, args);
	}

}
