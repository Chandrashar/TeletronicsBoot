package com.chan.uae.teletronics.config;


import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.servlet.config.annotation.ContentNegotiationConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@EnableWebMvc
@ComponentScan(basePackages = { "com.chan.uae.teletronics.entity" })
@Configuration
public class WebConfig implements WebMvcConfigurer {
	
    @Override
    public void configureContentNegotiation(final ContentNegotiationConfigurer configurer) {
    	
    	configurer.favorPathExtension(true).
        favorParameter(false).
        parameterName("mediaType").
        ignoreAcceptHeader(false).
        useJaf(false).
        defaultContentType(MediaType.APPLICATION_JSON).
        mediaType("xml", MediaType.APPLICATION_XML). 
        mediaType("json", MediaType.APPLICATION_JSON);
    	
    	
		/*
		 * configurer.favorPathExtension(true) .favorParameter(true)
		 * .parameterName("mediaType") .ignoreAcceptHeader(false)
		 * .useRegisteredExtensionsOnly(false) .mediaType("xml",
		 * MediaType.APPLICATION_XML) .mediaType("json", MediaType.APPLICATION_JSON)
		 * .defaultContentType(MediaType.APPLICATION_JSON);
		 */
        	
    }

}
