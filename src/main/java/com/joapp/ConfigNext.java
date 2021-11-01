package com.joapp;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile({"prod","dev","swagger"})
public class ConfigNext {
	
	@Bean
	public HelloWorld helloWorld() {
		return new HelloWorld();
	}
}
