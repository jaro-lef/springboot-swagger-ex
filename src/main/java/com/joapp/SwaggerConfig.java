package com.joapp;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


@Configuration
@Profile({"dev"})
@EnableSwagger2
//@ConditionalOnExpression(value = "${useSwagger:false}")
public class SwaggerConfig {
	
	@Bean
	public Docket productApi() {
	    return new Docket(DocumentationType.SWAGGER_2)
	            .select()
	            .apis(RequestHandlerSelectors.basePackage("com.joapp"))	            
	            //.paths(regex("/api/users.*"))
	            //.paths(PathSelectors.ant("/api/**"))
	            //.paths( PathSelectors.any() )
	            .build();
	            //.apiInfo(metaData());
	}
	
	
	/*@Bean
	public WebMvcConfigurer webMvcConfigurer()
	{
	    return new WebMvcConfigurer()
	    {
	        @Override
	        public void addResourceHandlers( ResourceHandlerRegistry registry )
	        {
	            //registry.addResourceHandler( "swagger-ui.html" ).addResourceLocations( "classpath:/META-INF/resources/" );
	            registry.addResourceHandler( "swagger-ui/" ).addResourceLocations( "classpath:/META-INF/resources/" );
	            registry.addResourceHandler( "/webjars/**" ).addResourceLocations( "classpath:/META-INF/resources/webjars/" );
	        }
	    };
	}*/
}