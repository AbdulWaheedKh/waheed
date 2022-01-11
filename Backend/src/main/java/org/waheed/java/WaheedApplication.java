package org.waheed.java;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.filter.CommonsRequestLoggingFilter;


@SpringBootApplication
public class WaheedApplication {

	private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());	
	
	@Bean
	public CommonsRequestLoggingFilter requestLoggingFilter() {
	    CommonsRequestLoggingFilter loggingFilter = new CommonsRequestLoggingFilter();
	    loggingFilter.setIncludeClientInfo(true);
	    loggingFilter.setIncludeQueryString(true);
	    loggingFilter.setIncludePayload(false);
	    loggingFilter.setIncludeHeaders(true);	    
	    loggingFilter.setMaxPayloadLength(10000);
	    
	    return loggingFilter;
	}

	public static void main(String[] args) {
		SpringApplication.run(WaheedApplication.class, args);
		System.out.println("pakistan");
		System.out.println("pakistan");
	}

}
